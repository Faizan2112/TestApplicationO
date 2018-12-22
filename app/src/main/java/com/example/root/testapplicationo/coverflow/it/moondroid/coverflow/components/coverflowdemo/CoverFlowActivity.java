package com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.coverflowdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.R;

import com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import com.example.root.testapplicationo.crouselview.sample.screens.MainActivity;
import com.example.root.testapplicationo.custom_text_field.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CoverFlowActivity extends AppCompatActivity {

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;
    private boolean tst;
    ArrayList<RecentUpdateResponseModal.RecentUpdateResponseModalResult> recentUpdateResponseModalResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRecentDatas();
        setContentView(R.layout.activity_coverflow);

   //     mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
    //    mData.add(new GameEntity(R.drawable.image_2, R.string.title2));
   //     mData.add(new GameEntity(R.drawable.image_3, R.string.title3));
    /*
          mData.add(new GameEntity(R.drawable.image_4, R.string.title4));
          mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
    */
        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = findViewById(R.id.coverflow);

        //  mCoverFlow.setShouldRepeat(false);
        mCoverFlow.setCoverHeight(500);
        mCoverFlow.setCoverWidth(500);
        // mCoverFlow.setFirstItemOffset(0);
        mCoverFlow.setAdapter(mAdapter);
        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position > mData.size())
                {
                    Toast.makeText(CoverFlowActivity.this,
                            "Invalid position",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Toast.makeText(CoverFlowActivity.this,
                            getResources().getString(mData.get(position).titleResId),
                            Toast.LENGTH_SHORT).show();
                    tst =    getResources().getString(mData.get(position).titleResId).toString().equals("");

                    if(!tst)
                        startActivity(new Intent(CoverFlowActivity.this, MainActivity.class));
                    else
                        Toast.makeText(CoverFlowActivity.this,
                                "Invalid position",
                                Toast.LENGTH_SHORT).show();
                }catch (Exception e){e.printStackTrace();


                }

            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });

    }
    private void loadRecentDatas() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://webworldindia.com/freshup_oms/api/get_recent_update", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

             //   AppUtility.dismissCustomProgress(mCustomProgressDialog);
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
            if (jsonObject.optString(Constants.RESPOSNE).equals("fail")) {
               // ToastMessage.getInstance(this).showFancyErrorTextMessage("No data");
                return;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonObject.optString(Constants.RESPOSNE).equals(Constants.SUCCESS_KEY)) {

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
                mCoverFlow = findViewById(R.id.coverflow);
                mCoverFlow.setCoverHeight(400);
                mCoverFlow.setCoverWidth(400);
                mCoverFlow.setFirstItemOffset(0);
                HomeAdapter homeAdapter = new HomeAdapter(this,recentUpdateResponseModalResults);
                // homeAdapter.setData(recentUpdateResponseModalResults);
                mCoverFlow.setAdapter(homeAdapter);
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   MainApplication.getRefWatcher(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coverflow_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


/*extends AppCompatActivity {

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;
    private boolean tst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverflow);

        mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
        mData.add(new GameEntity(R.drawable.image_2, R.string.title2));
        mData.add(new GameEntity(R.drawable.image_3, R.string.title3));
    *//*
          mData.add(new GameEntity(R.drawable.image_4, R.string.title4));
          mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
    *//*
        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = findViewById(R.id.coverflow);

      //  mCoverFlow.setShouldRepeat(false);
        mCoverFlow.setCoverHeight(500);
        mCoverFlow.setCoverWidth(500);
       // mCoverFlow.setFirstItemOffset(0);
        mCoverFlow.setAdapter(mAdapter);
        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if(position > mData.size())
              {
                  Toast.makeText(CoverFlowActivity.this,
                          "Invalid position",
                          Toast.LENGTH_SHORT).show();
                  return;
              }
               try {
                   Toast.makeText(CoverFlowActivity.this,
                           getResources().getString(mData.get(position).titleResId),
                           Toast.LENGTH_SHORT).show();
                 tst =    getResources().getString(mData.get(position).titleResId).toString().equals("");

                   if(!tst)
                       startActivity(new Intent(CoverFlowActivity.this, MainActivity.class));
                   else
                       Toast.makeText(CoverFlowActivity.this,
                               "Invalid position",
                               Toast.LENGTH_SHORT).show();
               }catch (Exception e){e.printStackTrace();


               }

            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
     //   MainApplication.getRefWatcher(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coverflow_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/