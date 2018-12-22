package com.example.root.testapplicationo.databindingtest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class DataBindingViewModel extends AndroidViewModel implements MainActivityContracter {

    public DataBindingViewModel(@NonNull Application application , RegistrationModel model) {
        super(application);

    }


}
