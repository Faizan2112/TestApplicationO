package com.example.root.testapplicationo.custombase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.testapplicationo.R;

//import com.example.root.testapplicationo.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.test_main, "My Activity Name");
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setFonts() {

    }

}