package com.example.root.testapplicationo.databindingtest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.databinding.ActivityDataBindTestBinding;

public class DataBindTestActivity extends AppCompatActivity implements View.OnClickListener {
    // name is as
    ActivityDataBindTestBinding activityDataBindTestBinding;
    RegistrationModel registrationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_bind_test);

        activityDataBindTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_bind_test);
        registrationModel = new RegistrationModel("faizan");
        activityDataBindTestBinding.setRegistration(registrationModel);
        activityDataBindTestBinding.normalBtn.setOnClickListener(this);
        activityDataBindTestBinding.normalBtn.setOnClickListener(this);
        // to get text
        //activityDataBindTestBinding.normalEdt.getText().toString()
       activityDataBindTestBinding.normalTxt.setText(activityDataBindTestBinding.normalEdt.getText().toString());

    }

    @Override
    public void onClick(View view) {
        int id = activityDataBindTestBinding.normalBtn.getId();
        switch (view.getId())

        {
            case  R.id.normal_btn :
                Toast.makeText(getApplicationContext(),"test1",Toast.LENGTH_SHORT ).show();
                break;
            case  R.id.normal_btn1 :
                Toast.makeText(getApplicationContext(),"test2",Toast.LENGTH_SHORT ).show();
                break;



        }

    }
}
