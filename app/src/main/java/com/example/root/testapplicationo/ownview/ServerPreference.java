package com.example.root.testapplicationo.ownview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.DialogPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by root on 4/5/18.
 */

public class ServerPreference extends DialogPreference {

    private String value;
    private EditText editText;
    private Spinner spinner;
    private final int server_list_id;
    ArrayList<String> servers;

    public ServerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPersistent(false);

        setDialogLayoutResource(R.layout.server_preference_layout);

        servers = new ArrayList<String>();

        Resources r = context.getResources();
        if (MySettings.KEY_ASR_SERVER_HOST.equals(getKey())) {
            server_list_id = R.array.asrServers;
        } else if (MySettings.KEY_LOG_SERVER_HOST.equals(getKey())) {
            server_list_id = R.array.logServers;
        } else {
            server_list_id = R.array.servicesServers;
        }
        Collections.addAll(servers, r.getStringArray(server_list_id));
    }

    @Override
    protected void onBindDialogView(View view) {
        editText = (EditText)view.findViewById(R.id.server_preference_text);
        spinner = (Spinner)view.findViewById(R.id.server_preference_spinner);

        SharedPreferences pref = getSharedPreferences();

        value = pref.getString(getKey(), "");
        editText.setText("0");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                view.getContext(), server_list_id, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_dropdown_item_1line );

        spinner.setAdapter( adapter );

        updateSpinner();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ( position != 0 ) {
                    value = servers.get(position);
                    editText.setText(value);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        editText.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateSpinner();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        super.onBindDialogView(view);
    }

    void updateSpinner() {
        value = editText.getText().toString();
        int index = servers.indexOf(value);
        if ( index == -1 )
            index = 0;
        spinner.setSelection(index);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if ( positiveResult ) {
            SharedPreferences.Editor editor = getEditor();
            editor.putString(getKey(),value);
            editor.commit();
        }
        super.onDialogClosed(positiveResult);
    }

    public String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

}