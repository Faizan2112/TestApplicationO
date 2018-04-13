package com.example.root.testapplicationo.barcode_scanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.testapplicationo.R;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;


public class BarCodeActivity extends AppCompatActivity implements View.OnClickListener, ZXingScannerView.ResultHandler {
    private Button buttonScan;
    private TextView textViewName, textViewAddress;
    private IntentIntegrator qrScan;
    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mZXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // we will use default layout used by  library


        //   setContentView(R.layout.activity_bar_code);
        mZXingScannerView = new ZXingScannerView(this);
        setContentView(mZXingScannerView);

        int currentapiversion = Build.VERSION.SDK_INT;
        if (currentapiversion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {

                Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();

            } else {
                requestPermission();
            }

        }
    //    buttonScan = (Button) findViewById(R.id.buttonScan);
     //   textViewName = (TextView) findViewById(R.id.textViewName);
      //  textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        qrScan = new IntentIntegrator(this);
        //buttonScan.setOnClickListener(this);
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }


    private boolean checkPermission() {

        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //   super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted) {
                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(BarCodeActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if (mZXingScannerView == null) {
                    mZXingScannerView = new ZXingScannerView(this);
                    setContentView(mZXingScannerView);
                }
                mZXingScannerView.setResultHandler(this);
                mZXingScannerView.startCamera();
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onClick(View view) {

        qrScan.initiateScan();

    }

    @Override
    public void handleResult(Result result) {
        final String results = result.getText();
        Log.d("QRCodeScaneer", result.getText());
        Log.d("", result.getBarcodeFormat().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             mZXingScannerView.resumeCameraPreview(BarCodeActivity.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            //    public void onClick(DialogInterface dialog, int which) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(results));

                    startActivity(browserIntent);
            }
        });
        builder.setMessage(result.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZXingScannerView.stopCamera();
    }
}
