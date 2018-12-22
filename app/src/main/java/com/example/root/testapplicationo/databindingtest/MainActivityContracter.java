package com.example.root.testapplicationo.databindingtest;
// call from
public interface MainActivityContracter {
    public interface Presenter
    {
        void onShowData(RegistrationModel temperatureData);
        void showList();

    }

    public interface View
    {

        void showData(RegistrationModel registrationModel);


    }

}
