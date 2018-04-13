package com.example.root.testapplicationo.custombarcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.R;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;
import static com.example.root.testapplicationo.MainActivity.FRESH_UP_SPINNER_SUB_CATEGORY;

public class SimpleScannerActivity extends BaseScannerActivity implements ZXingScannerView.ResultHandler, View.OnClickListener {
    private ZXingScannerView mScannerView;
    private IntentIntegrator qrScan;
    private static final int REQUEST_CAMERA = 1;
    private ViewGroup barcodeDetails, contentFrame;
    //  Button mHide;
    FloatingActionButton mFloatingActionButton;
    private View alertLayout;
    TextView mShowBarcode, mFloatText;
    EditText mGetBarcode;
    static List<BarcodeNumber> barcodeNumbers;
    static List barcodeNumber = new ArrayList<>();


    static Set barcodeNumberSet;
    public static SharedPreferences sharedStoreBarcode;
    private static HashSet hashSet;
    private String URL_LOGIN = "http://webworldindia.com/freshup_oms/api/get_product_by_barcode";
    private String URL_LOGIN_SINGLE = "http://webworldindia.com/freshup_oms/api/get_product_by_barcode_single";


    // private ZXingScannerView mZXingScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_simple_scanner);
        setupToolbar();

        contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mFloatingActionButton = findViewById(R.id.scanner_barcode_number);
        mFloatText = findViewById(R.id.scanner_floating_text);
        mFloatingActionButton.setOnClickListener(this);
        barcodeNumbers = new ArrayList<>();
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);

        int currentapiversion = Build.VERSION.SDK_INT;
        if (currentapiversion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();
            } else {
                requestPermission();
            }}
        qrScan = new IntentIntegrator(this);

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
        new android.support.v7.app.AlertDialog.Builder(SimpleScannerActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if (mScannerView == null) {
                    mScannerView = new ZXingScannerView(this);
                    contentFrame.addView(mScannerView);
                }
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            } else {
                requestPermission();
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.scanner_barcode_number:

                try {
                    sendJsonData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;

        }
        //qrScan.initiateScan();
        }

    private void sendJsonData() throws JSONException {

        RequestQueue queue = Volley.newRequestQueue(this);


        //showProgressDialog();


        Map<String, String> postParam = new HashMap<String, String>();
        for (int i = 0; i < barcodeNumber.size(); i++) {
         //    Object j = barcodeNumber.get(i);
            postParam.put(""+i,""+barcodeNumber.get(i));
//            postParam.put("p", "somepasswordhere");


        }


        String postPara = postParam.toString();
        JSONObject js = null;
        js = new JSONObject();
        js.put("0","b1");
        js.put("1","b2");

        //       js = new JSONObject(postPara);


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,URL_LOGIN, js, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getBaseContext(), "Cancel clicked" + response, Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), "Cancel clicked" + error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }


        };

         queue.add(jsonObjReq);

   /*     // Cancelling request
     if (queue!= null) {
    queue.cancelAll(TAG);
    }
*/
    }

    @Override
    public void handleResult(Result result) {
        final String results = result.getText();


        // showAlertDialog(result);
        checkBarcodeOnServer(result);

    }

    private void checkBarcodeOnServer(final Result result) {

        final String posVal = result.getText();
        final StringRequest fetchSubCategory = new StringRequest(Request.Method.POST, URL_LOGIN_SINGLE, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    parseBarcodeDetails(response, result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                //  mPDialog.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputSubCategory = new HashMap<>();
                inputSubCategory.put("barcode", posVal);

                return inputSubCategory;
            }
        };
        RequestQueue sendBarcodeData = Volley.newRequestQueue(this);
        fetchSubCategory.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        sendBarcodeData.add(fetchSubCategory);


    }

    private void parseBarcodeDetails(String response, Result result) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("resp").equals("success")) {
            showAlertDialog(result);
            mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
        } else {
            showGetAlertDialog(result);
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
            mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
        }

    }

    private void showGetAlertDialog(Result result) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        alertLayout = inflater.inflate(R.layout.pop_up_edit_text, null);
        alert.setTitle("Info");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        mGetBarcode = alertLayout.findViewById(R.id.manuall_barcode);



        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Store & Scan", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String getEdtBarcode = mGetBarcode.getText().toString();

                checkManuall(getEdtBarcode);
               /* String val = String.valueOf(barcodeNumber.size());
                mFloatText.setText(val);
*/
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();


    }

    private void checkManuall(final String getEdtBarcode) {
       // final String posVal = result.getText();
        final StringRequest fetchSubCategory = new StringRequest(Request.Method.POST, URL_LOGIN_SINGLE, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    parseBarcodesDetails(response, getEdtBarcode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                //  mPDialog.dismiss();
            }
        }) /*{
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputSubCategory = new HashMap<>();
                inputSubCategory.put("barcode", getEdtBarcode);

                return inputSubCategory;
            }
        }*/;
        RequestQueue sendBarcodeData = Volley.newRequestQueue(this);
        fetchSubCategory.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        sendBarcodeData.add(fetchSubCategory);


    }

    private void parseBarcodesDetails(String response, String getEdtBarcode) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("resp").equals("success")) {
            barcodeNumber.add(getEdtBarcode);
            mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
        } else {
            //showGetAlertDialog(result);
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
            mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
        }

    }


    private void showAlertDialog(Result results) {

        // barcodeNumberSet = new HashSet();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        alertLayout = inflater.inflate(R.layout.pop_up_window, null);
        alert.setTitle("Info");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        mShowBarcode = alertLayout.findViewById(R.id.barcode_num);
        //mGetBarcode = alertLayout.findViewById(R.id.manuall_barcode);

        //  mShowBarcode.setText(results.getBarcodeFormat().toString());
        mShowBarcode.setText(results.getText());
        final String barNum = mShowBarcode.getText().toString();
        // final String getEdtBarcode = mGetBarcode.getText().toString();

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Store & Scan", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                performClick(barNum);
                String val = String.valueOf(barcodeNumber.size());
                mFloatText.setText(val);

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();


    }

    private void performClick(String barNum) {

        if (!barNum.isEmpty()) {
            // BarcodeNumber barcodeNumber = new BarcodeNumber();

            store(barNum);

        }
        mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
    }


    private void store(String getEdtBarcode) {
        barcodeNumber.add(getEdtBarcode);
    }


    private void store(String barNum, String getEdtBarcode) {

        barcodeNumber.add(barNum);
        barcodeNumber.size();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }
}

        /*  if(barcodeDetails.getVisibility()==View.GONE)
        {
            barcodeDetails.setVisibility(View.VISIBLE);
            mScannerView.stopCamera();

        }*/
        /*   public void onButtonShowPopupWindowClick() {

        // get a reference to the already created main layout
        LinearLayout mainLayout = (LinearLayout)
                findViewById(R.id.activity_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }*/
         /* Log.d("QRCodeScaneer", result.getText());
        Log.d("", result.getBarcodeFormat().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
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
        alert1.show();*/
          /* private void performClick(String barNum, String getEdtBarcode) {
        final String s = " ";

        if (!barNum.isEmpty() && !getEdtBarcode.isEmpty()) {
            // BarcodeNumber barcodeNumber = new BarcodeNumber();

            store(getEdtBarcode);

        } else if (!barNum.isEmpty() && getEdtBarcode.isEmpty()) {
            Toast.makeText(getApplicationContext(), "scanned code" + mGetBarcode.getText(), Toast.LENGTH_SHORT).show();
            //   barcodeNumberSet.add(mGetBarcode.getText().toString());
            store(barNum, getEdtBarcode);

        } else {

            Toast.makeText(getApplicationContext(), "scan again", Toast.LENGTH_SHORT).show();


        }
       *//* Set<String> demo = new HashSet<>();
        Set<String> barDataLen = sharedStoreBarcode.getStringSet("data", demo);
        barDataLen.size();
        Toast.makeText(getApplicationContext(), "scan again" + barDataLen.size(), Toast.LENGTH_SHORT).show();
*//*
        mScannerView.resumeCameraPreview(SimpleScannerActivity.this);

    }*/
  /* hashSet = new HashSet();
        sharedStoreBarcode = this.getSharedPreferences("StoreBarcode", MODE_PRIVATE);
        sharedStoreBarcode.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                //  Log.d(TAG, "The key '" + key + "' is changed");
            }
        });
        SharedPreferences.Editor editor = sharedStoreBarcode.edit();
        hashSet.add(barNum);
        editor.putStringSet("data", hashSet);
        editor.commit();

        // barcodeNumbers.add(new BarcodeNumber(getEdtBarcode));
        Toast.makeText(getApplicationContext(), "scanned code", Toast.LENGTH_SHORT).show();

*/
  /*   RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // your response

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError {


                String your_string_json ="{\n" +
                        "    \"1_aID\": \"5\",\n" +
                        "    \"2_aID\": \"5\",\n" +
                        "    \"3_aID\": \"5\",\n" +
                        "    \"4_aID\": \"5\"\n" +
                        "  }" ; // put your json
                return your_string_json.getBytes();
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        queue.start();
*/