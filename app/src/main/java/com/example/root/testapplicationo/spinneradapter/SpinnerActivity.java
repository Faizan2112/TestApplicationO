/*
package com.example.root.testapplicationo.spinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.example.root.testapplicationo.MainActivity;
import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    public static final String[] cat_id = new String[] { "Strawberry",
            "Banana", "Orange", "Hello" };

    public static final String[] cat_name = new String[] { "Strawberry",
            "Banana", "Orange", "Hello" };

    Spinner spinner;
    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < cat_name.length; i++) {

            RowItem item = new RowItem(cat_id[i],cat_name[i]);
            rowItems.add(item);
        }

        spinner = (Spinner)findViewById(R.id.spinner);
        CustomAdapter adapter = new CustomAdapter(SpinnerActivity.this,
                R.layout.display_item, rowItems);
        spinner.setAdapter(adapter);
    }
}
*/
