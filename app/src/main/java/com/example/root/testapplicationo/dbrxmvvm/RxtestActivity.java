package com.example.root.testapplicationo.dbrxmvvm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.testapplicationo.R;

public class RxtestActivity extends AppCompatActivity {
    RxTestViewModel mRxTestViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxtest);
        mRxTestViewModel = ViewModelProviders.of(RxtestActivity.this).get(RxTestViewModel.class);

    }
}
