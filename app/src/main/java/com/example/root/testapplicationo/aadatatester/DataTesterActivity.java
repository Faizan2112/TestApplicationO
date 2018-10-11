package com.example.root.testapplicationo.aadatatester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.R;

import java.util.HashMap;
import java.util.Map;

public class DataTesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_tester);
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadData();

    }

    private void loadData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://webworldindia.com/connectyaar/api/getSingleUserNew\n", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  AppUtility.dismissCustomProgress(mCustomProgressDialog);
                //  parseResponse(response);
                // ToastMessage.getInstance(getApplicationContext()).showFancyDefaultTextMessage(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> userIds = new HashMap<>();
                userIds.put("user_id", "55111815");
               /* userIds.put("userTo", "11");
                userIds.put("lengthid", "78");
                userIds.put("widthid", "73");
                userIds.put("heightid", "6");
               */// mobileNo

                 //       pin

               // mobileDevice


                return userIds;
            }
        };
        RequestQueue sendOrderData = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,          DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendOrderData.add(stringRequest);


    }
}
