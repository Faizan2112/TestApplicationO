package com.example.root.testapplicationo.retofit_test.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.retofit_test.viewmodels.LoginActivityViewModel;
import com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate.UserAuthenticationState;

public class NewLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEdtTxt;
    private ImageView mIvAuthenticateMobileNumber;
    private LoginActivityViewModel mLoginActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);
        mLoginActivityViewModel= ViewModelProviders.of(NewLoginActivity.this).get(LoginActivityViewModel.class);

    initView();
    setOnClickListeners();

    mLoginActivityViewModel.subscribeForUserLoginByNumber().observe(this, new Observer<UserAuthenticationState>() {
        @Override
        public void onChanged(@Nullable UserAuthenticationState userAuthenticationState) {
            if (userAuthenticationState.getStatus() == UserAuthenticationState.Status.SUCCESS) {
                Log.i("Response In View", "" + userAuthenticationState.getUserData().toString());
            }
        }
    });
    }

    private void setOnClickListeners() {
        mIvAuthenticateMobileNumber.setOnClickListener(this);
    }

    private void initView() {
        mEdtTxt = findViewById(R.id.login_mobile_number);

        mIvAuthenticateMobileNumber = findViewById(R.id.login_check_mobile_details);

    }

    @Override
    public void onClick(View view) {
        String s = mEdtTxt.getText().toString();
        if (view.getId() == mIvAuthenticateMobileNumber.getId()) {
            mLoginActivityViewModel.setUserLoginByMobileNumber(s);
        }
    }
}
