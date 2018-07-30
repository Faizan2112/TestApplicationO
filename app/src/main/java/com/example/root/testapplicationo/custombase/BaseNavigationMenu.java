package com.example.root.testapplicationo.custombase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.testapplicationo.R;

public class BaseNavigationMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_navigation_menu);
    }
}
