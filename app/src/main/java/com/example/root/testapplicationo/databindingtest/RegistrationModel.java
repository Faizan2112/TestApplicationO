package com.example.root.testapplicationo.databindingtest;

import android.databinding.ObservableField;

import java.util.Observable;

/**
 * Created by root on 4/17/18.
 */
// to access this model class we will make data variable in layout for reference
public class RegistrationModel {
    public ObservableField<String> name = new ObservableField<>();

    public RegistrationModel(String name) {
        this.name.set(name);
    }
}
