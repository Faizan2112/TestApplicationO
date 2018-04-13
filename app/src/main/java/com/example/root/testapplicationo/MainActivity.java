package com.example.root.testapplicationo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.dependentspinner.CategoryDetail;
import com.example.root.testapplicationo.firebasetest.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayList<String> mCategoryList , mSubCategoryList , mProduct;
    public CategoryDetail categoryDetail ;
    Spinner mCategorySpinner, mSubCategorySpinner, mProductSpinner;
    public static final String FRESH_UP_SPINNER_CATEGORY = "http://webworldindia.com/freshup_oms/api/getAllCategory";
    public static final String FRESH_UP_SPINNER_SUB_CATEGORY="http://webworldindia.com/freshup_oms/api/getAllSubCategory";
    public static final int ADAPTERS_CATEGORY_ID = 0 ;
    public static final int ADAPTERS_SUB_CATEGORY_ID = 1 ;
    public static final int ADAPTERS_PRODUCT = 2 ;
    public boolean mCategoryFilled;
    TextView mSetToken ;
    //SharedPrefManager // = getI  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        fillSpinner();
        String token = SharedPrefManager.getInstance(this).getDeviceToken();
         mSetToken.setText(token);

    }

    private void intiViews() {
        mCategoryList = new ArrayList<String>();
        mSubCategoryList = new ArrayList<String>();
        mProduct = new ArrayList<String>();
         mSetToken = (TextView)findViewById(R.id.set_token);
        mCategorySpinner = (Spinner) findViewById(R.id.home_select_category_spinnner);
        mSubCategorySpinner = (Spinner) findViewById(R.id.home_select_sub_category_spinnner);
        mProductSpinner = (Spinner) findViewById(R.id.home_select_product_spinnner);
        mCategorySpinner.setOnItemSelectedListener(this);
     }

    private void fillSpinner() {
        final StringRequest loginUser = new StringRequest(Request.Method.POST, FRESH_UP_SPINNER_SUB_CATEGORY, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                parseCategoryDetails(response);
              /*  try {
                  //  responseParse(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mPDialog.dismiss();
*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                //  mPDialog.dismiss();
            }
        });

        RequestQueue sendLdata = Volley.newRequestQueue(this);
        loginUser.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendLdata.add(loginUser);


    }

    private void parseSubCategoryDetails(String response) {
        try {
            JSONObject subCategoryObject = new JSONObject(response);
            if (subCategoryObject.optInt("success") == 1) {
                JSONArray subCategaryArray = subCategoryObject.getJSONArray("result_data");
                for (int i = 0; i <= subCategaryArray.length(); i++) {
                    JSONObject jsonSub = subCategaryArray.getJSONObject(i);

                    String cat_id = jsonSub.getString("cat_id");
                    String cat_name = jsonSub.getString("cat_name");

                    // mCategoryList.add(cat_id);
                    mSubCategoryList.add(cat_name);
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSubCategorySpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, mSubCategoryList));
        //  mCategorySpinner.setId(ADAPTERS_CATEGORY_ID);

    }

    private void parseCategoryDetails(String response) {
        List<CategoryDetail> storeTotalMat = new ArrayList<>()  ;
        List<String> storeOneByOneMatString = new ArrayList<>();

        try {
            JSONObject subCategoryObject = new JSONObject(response);
            if (subCategoryObject.optInt("success") == 1) {
                JSONArray subCategaryArray = subCategoryObject.getJSONArray("result_data");
                for (int i = 0; i <= subCategaryArray.length(); i++) {
                    JSONObject jsonSub = subCategaryArray.getJSONObject(i);
                    String cat_id = jsonSub.getString("cat_id");
                    String cat_name = jsonSub.getString("cat_name");
                    storeTotalMat.add(new CategoryDetail(cat_id,cat_name));

                    //for (int j = 0; j < jsonSub.length(); j++) {
                    //    storeOneByOneMatString.add(jsonSub.getString(String.valueOf(j)));


                    }
                   // storeTotalMat.add((CategoryDetail) storeOneByOneMatString);
                //storeTotalMat.add(new CategoryDetail(storeOneByOneMatString));
                  //  mCategoryList.add(cat_id);
                  //  mCategoryList.add(cat_name);

                }


            } catch (JSONException e1) {
            e1.printStackTrace();
        }

        mCategorySpinner.setAdapter(new ArrayAdapter<CategoryDetail>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, storeTotalMat));
      //  mCategorySpinner.setId(ADAPTERS_CATEGORY_ID);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.home_select_category_spinnner)
        {
            String categoryName = mCategorySpinner.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), "" + categoryName, Toast.LENGTH_LONG).show();
           // selectSubCategory(categoryName);
        }
        else if(spinner.getId() == R.id.home_select_sub_category_spinnner)
        {
            String categoryName = mSubCategorySpinner.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), "" + categoryName, Toast.LENGTH_LONG).show();

        }


    }

    private void selectSubCategory(String categoryName) {
        final String cName = categoryName.toString();
        final StringRequest loginUser = new StringRequest(Request.Method.POST, FRESH_UP_SPINNER_CATEGORY, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                parseSubCategoryDetails(response);
              /*  try {
                  //  responseParse(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mPDialog.dismiss();
*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                //  mPDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> sendCategory = new HashMap<>();
                sendCategory.put("catid",cName);
                return sendCategory;
            }
        };

        RequestQueue sendLdata = Volley.newRequestQueue(this);
        loginUser.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendLdata.add(loginUser);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        mCategorySpinner.setPrompt("Category");
    }
}

