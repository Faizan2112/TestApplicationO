package com.example.root.testapplicationo.testcoverflow;

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
import com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.coverflowdemo.RecentUpdateResponseModal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestCoverFlowActivity extends AppCompatActivity {
    ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> recentUpdateResponseModalResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_cover_flow);
        loadRecentDatas();


    }

    private void loadRecentDatas() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://webworldindia.com/freshup_oms/api/get_recent_update", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

              //  AppUtility.dismissCustomProgress(mCustomProgressDialog);
                parseResponse(response);
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
                userIds.put("id", "11");
                return userIds;
            }
        };
        RequestQueue sendOrderData = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendOrderData.add(stringRequest);


    }

    private void parseResponse(String response) {
        recentUpdateResponseModalResults = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            if (jsonObject.optString("resp").equals("fail")) {
             //   ToastMessage.getInstance(this).showFancyErrorTextMessage("No data");
                return;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonObject.optString("resp").equals("success")) {

            JSONArray jsonArray = null;
            try {
                jsonArray = jsonObject.getJSONArray("result");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                RecentUpdateResponseModal.RecentUpdateResponseModalResult recentUpdateResponseModalResult = new RecentUpdateResponseModal.RecentUpdateResponseModalResult();
                JSONObject jsonObject1 = null;
                try {
                    jsonObject1 = jsonArray.getJSONObject(i);
                    recentUpdateResponseModalResult.setImage(jsonObject1.getString("image"));
                    recentUpdateResponseModalResult.setRId(jsonObject1.getString("r_id"));
                    recentUpdateResponseModalResult.setSId(jsonObject1.getString("s_id"));
                    recentUpdateResponseModalResult.setViewType(jsonObject1.getString("view_type"));
                    recentUpdateResponseModalResult.setOrderId(jsonObject1.getString("order_id"));
                    recentUpdateResponseModalResult.setName(jsonObject1.getString("name"));
                    recentUpdateResponseModalResult.setDate(jsonObject1.getString("date"));

                    recentUpdateResponseModalResult.setFromName(jsonObject1.getString("from_name"));
                    recentUpdateResponseModalResults.add(recentUpdateResponseModalResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
              /*  mCoverFlow = findViewById(R.id.coverflow);
                mCoverFlow.setCoverHeight(400);
                mCoverFlow.setCoverWidth(400);
                mCoverFlow.setFirstItemOffset(0);
                HomeAdapter homeAdapter = new HomeAdapter(this,recentUpdateResponseModalResults);
                // homeAdapter.setData(recentUpdateResponseModalResults);
                mCoverFlow.setAdapter(homeAdapter);*/
                //  FeatureCoverFlow f = findViewById(R.id.coverflow);
                //  LinearLayout fl = findViewById(R.id.add_coverFlow);
               /* if(f.getParent() != null) {
                    ((ViewGroup)f.getParent()).removeView(f); // <- fix
                }*/
                //  fl.addView(f);
                // fl.addView(fl);


            }

            //  infiniteAdapter = InfiniteScrollAdapter.wrap(new HomeAdapter(recentUpdateResponseModalResults, this));
            // infiniteAdapter = InfiniteScrollAdapter.wrap(new HomeAdapter(this,recentUpdateResponseModalResults));

            //  itemPicker.setAdapter(infiniteAdapter);
            // itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
            //itemPicker.setItemTransitionTimeMillis(150);
            // itemPicker.setItemTransformer(new ScaleTransformer.Builder()
            //  .setMinScale(0.8f)
            //  .build());
            //itemPicker.addOnItemTouchListener(this);
            // onItemChanged(recentUpdateResponseModalResults.get(0));

        } else {


        }
    }
}
