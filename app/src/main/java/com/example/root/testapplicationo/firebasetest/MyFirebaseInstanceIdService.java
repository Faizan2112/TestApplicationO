package com.example.root.testapplicationo.firebasetest;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by root on 3/20/18.
 */

public class MyFirebaseInstanceIdService  extends FirebaseInstanceIdService {


    //this method will be called
    //when the token is generated
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        //now we will have the token
        String token = FirebaseInstanceId.getInstance().getToken();

        //for now we are displaying the token in the log
        //copy it as this method is called only when the new token is generated
        //and usually new token is only generated when the app is reinstalled or the data is cleared
        storeToken(token);
        Log.d("MyRefreshedToken", token);
    }

    private void storeToken(String token) {
        //we will save the token in sharedpreferences later
        SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);

    }
}
