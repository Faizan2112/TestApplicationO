package com.example.root.testapplicationo.calltest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.List;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {
    Button mCall;
    Context mContext;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.test);
        mCall = findViewById(R.id.pick_call);
*/
        setContentView(R.layout.test_call);
        mCall = findViewById(R.id.callss);
        mCall.setOnClickListener(this);
        verifyStoragePermissions(this);
        fetchSimSerialNumver();
    }

    private void fetchSimSerialNumver() {
        // String phoneNumber = TelephonyManager.getDefault().getLine1Number();
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }}
        /*String num = tm.getSimSerialNumber().toString();
        Toast.makeText(getApplicationContext(),num, Toast.LENGTH_SHORT).show();
*//*
        TelephonyInfo telephonyInfo = TelephonyInfo.getInstance(this);
        if (telephonyInfo.isDualSIM()) {
            // Check if the first SIM is ready
            if (telephonyInfo.isSIM1Ready()) {
                String imsiSIM1 = telephonyInfo.getImsiSIM1();
            }
            // Check if the second SIM is ready
            if (telephonyInfo.isSIM2Ready()) {
                String imsiSIM2 = telephonyInfo.getImsiSIM2();
            }

    }*/

    private void verifyStoragePermissions(CallActivity callActivity) {
        int calss = ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE);
        int phoneState = ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.READ_PHONE_STATE);

        if (calss != PackageManager.PERMISSION_GRANTED || phoneState != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    CallActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.callss:
                makeCall();

                break;

        }
    }

    private void makeCall() {
        Intent intent = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel: +919999596967"));
        if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

    }

}
 /* private void verifyStoragePermissions(Call allContentFragment) {

    }*/
  /* private boolean checkRequestPermission() {

       int permissionSendMessage = ContextCompat.checkSelfPermission(this,
               Manifest.permission.READ_PHONE_STATE);
       int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

       List<String> listPermissionsNeeded = new ArrayList<>();
       if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
           listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
       }
       if (locationPermission != PackageManager.PERMISSION_GRANTED) {
           listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
       }

       if (!listPermissionsNeeded.isEmpty()) {
           ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MY_PERMISSIONS_REQUEST_READ_CONTACTS);
           return false;
       }
       return true;

   }
    private void takePermission() {

        int currentapiversion = Build.VERSION.SDK_INT;
        if (currentapiversion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                //   Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();
            } else {
                requestPermission();
            }}
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
    }


    private boolean checkPermission() {

        return (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED);

    }
   */