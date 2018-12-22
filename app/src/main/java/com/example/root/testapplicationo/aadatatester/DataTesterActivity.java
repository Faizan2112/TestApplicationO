package com.example.root.testapplicationo.aadatatester;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.fragments.ItemFragment;

import java.util.HashMap;
import java.util.Map;

public class DataTesterActivity extends FragmentActivity implements View.OnClickListener {
    TextView data;
    Button btn;
    EditText editText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_tester);
       // loadData();
        btn = findViewById(R.id.test_data);
        data = findViewById(R.id.test_text);
        editText = findViewById(R.id.text_edit);
        btn.setOnClickListener(this);
        loadFragment(new ItemFragment());


    }

    private boolean loadFragment(Fragment itemFragment) {
        if (itemFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, itemFragment).commit();
            return true;
        }
        return false;



    }

    @Override
    protected void onResume() {
        super.onResume();

        // loadData();

    }

    private void loadData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
              //  "http://emavens.in/glasifiednew/mobile/customer/signup?email=faizan@emavens.com&firstname=faizan&lastname=khan&password=test1234&quote_id=7"
                "http://www.glasified.com/mobile/customer/signup?email=faizan@emavens.com&firstname=faizan&lastname=khan&password=test1234&quote_id=7"
               // "http://emavens.in/glasifiednew/mobile/catalog/categorytree"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                data.setText(response.toString());
                //  AppUtility.dismissCustomProgress(mCustomProgressDialog);
                //  parseResponse(response);
                //ToastMessage.getInstance(getApplicationContext()).showFancyDefaultTextMessage(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            //  @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> userIds = new HashMap<>();

             //   userIds.put("user_id", "11");
                /*  userIds.put("limit_to", "16");*/
                // mobileNo

                //       pin

                // mobileDevice


                return userIds;
            }
        };
        RequestQueue sendOrderData = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendOrderData.add(stringRequest);


    }

    @Override
    public void onClick(View view) {
    switch (view.getId())
    {
        case R.id.test_data:
           loadData();
            break ;

    }
    }
}
