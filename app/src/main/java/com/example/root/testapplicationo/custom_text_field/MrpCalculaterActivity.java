package com.example.root.testapplicationo.custom_text_field;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.autodropdown.SimpleAutoCompleteTextView;
import com.example.root.testapplicationo.autodropdown.SupplierSuggestionAdapter;
import com.example.root.testapplicationo.newautodropdown.CustomAutoCompleteTextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MrpCalculaterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnTouchListener {
    Spinner mCategorySpinner, mSubCategorySpinner, mCatProductSpinner, mLength, mWidth, mHeight, mColor;
    // AutoCompleteTextView mLenTv,mHeiTv,mWidTv;
    private String lent, widt, hei, color;
    private String lentSize, widtSize, heiSize, colorSize;
    private boolean isHeightSpinnerTouched = false;
    Button mAdd;
    TextView mPrice;
    EditText mQuantity;
    private Toolbar mToolbar;
    private CustomAutoCompleteTextViews mLenTv, mHeiTv, mWidTv;
    ;

    ArrayList<CategoryModel> mCategoryModels;
    ArrayList<SubCategoryModel> mSubCategoryModels;
    ArrayList<ProductModel> mProductModels;
    ArrayList<Length> mLengths;
    ArrayList<Width> mWidths;
    ArrayList<Height> mHeights;
    ArrayList<ColorModel> mColors;
    ArrayList<HashMap<String, Length>> mHLengths;
    ArrayList<HashMap<String, Width>> mHWidths;
    ArrayList<HashMap<String, Height>> mHHeights;
    ArrayList<HashMap<String, ColorModel>> mHColors;

    List<PoductSizeModel> mPoductSizeModels;
    CategoryModel mCategoryModel;
    SubCategoryModel mSubCategoryModel;
    ProductModel mProductModel;
    private String productSpinnerValue;
    private String userId;
    private String catProductSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrp_calculater);

        initializeView();
        getPrefr();
        fillCategorySpinner();
    }

    private void getPrefr() {
        //  sharedPreferen = getSharedPreferences("logindetails",MODE_PRIVATE);
        //  userId = sharedPreferen.getString("userId","");
    }

    private void fillCategorySpinner() {
        final StringRequest categoryRequest = new StringRequest(Request.Method.POST, UrlConstants.FRESH_UP_SPINNER_CATEGORY, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                // Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                parseCategoryDetails(response);

                //      mCustomProgressBar.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();

                //  mCustomProgressBar.show();
            }
        });
        RequestQueue startCategoryRequest = Volley.newRequestQueue(this);
        categoryRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        startCategoryRequest.add(categoryRequest);

    }

    private void parseCategoryDetails(String response) {
        mCategoryModels = new ArrayList<>();
        try {
            JSONObject categoryObject = new JSONObject(response);
            if (categoryObject.optInt(Constants.SUCCESS_KEY) == 1) {
                JSONArray categaryArray = categoryObject.getJSONArray(Constants.RESULT_DATA_KEY);

                for (int i = 0; i < categaryArray.length(); i++) {
                    JSONObject jsonSub = categaryArray.getJSONObject(i);
                    String cat_id = jsonSub.getString(Constants.CAT_IDS);
                    String cat_name = jsonSub.getString(Constants.CAT_NAME);
                    mCategoryModel = new CategoryModel(cat_id, cat_name);

                    mCategoryModels.add(mCategoryModel);
                }
                CategoryAdapter categoryAdapter = new CategoryAdapter(getApplicationContext(), mCategoryModels);
                mCategorySpinner.setAdapter(categoryAdapter);
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
        }

    }


    private void initializeView() {

        mLenTv = findViewById(R.id.mrp_lenth_textview);
        mHeiTv = findViewById(R.id.mrp_height_textview);
        mWidTv = findViewById(R.id.mrp_breadth_textview);
        mLenTv.setOnTouchListener(this);
        mCategorySpinner = (Spinner) findViewById(R.id.home_category_spinner);
        mSubCategorySpinner = (Spinner) findViewById(R.id.home_sub_category_spinner);
        mCatProductSpinner = (Spinner) findViewById(R.id.home_cat_product);
        mColor = (Spinner) findViewById(R.id.home_mat_color);
        mPrice = (TextView) findViewById(R.id.home_mat_price);
        mLenTv.setOnItemSelectedListener(this);
        mWidTv.setOnItemSelectedListener(this);
        mHeiTv.setOnItemSelectedListener(this);
        mColor.setOnItemSelectedListener(this);
        mCategorySpinner.setOnItemSelectedListener(this);
        mSubCategorySpinner.setOnItemSelectedListener(this);
        mCatProductSpinner.setOnItemSelectedListener(this);

        mLenTv.setOnTouchListener(this);
        mHeiTv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isHeightSpinnerTouched = true;
                return false;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        int ids = adapterView.getId();

        switch (ids) {
            case R.id.home_category_spinner:
                String categorySpinnerValue = mCategoryModels.get(position).getmCategoryId();
                if (mSubCategoryModels != null) {
                    mSubCategoryModels.clear();


                    //   Toast.makeText(getApplicationContext(), categorySpinnerValue, Toast.LENGTH_LONG).show();
                    openSubCategorySpinner(categorySpinnerValue);
                } else {
                    openSubCategorySpinner(categorySpinnerValue);

                }
                break;
            case R.id.home_sub_category_spinner:
                productSpinnerValue = mSubCategoryModels.get(position).getmCategoryId();

                // Toast.makeText(getApplicationContext(), productSpinnerValue, Toast.LENGTH_LONG).show();
                if (mProductModels != null) {
                    mProductModels.clear();
                    //Toast.makeText(getApplicationContext(), productSpinnerValue, Toast.LENGTH_LONG).show();
                    openProductCategorySpinner(productSpinnerValue);
                } else {
                    openProductCategorySpinner(productSpinnerValue);

                }
                break;
            case R.id.home_cat_product:
                catProductSpinnerValue = mProductModels.get(position).getmCategoryId();
                fillDimentionSpinners(catProductSpinnerValue);

                break;
            case R.id.home_mat_color:
                if (mColors != null) {
                    color = mColors.get(position).getValue().toString();
                    colorSize = mColors.get(position).getLabel().toString();

                }
            case R.id.mrp_lenth_textview:
                if (mLength != null) {
                    lent = mHLengths.get(position).get("name").getLabel().toString();
                    //lentSize = mLengths.get(position).getLabel().toString();
                    mLenTv.setText(lent);

                }

                break;
            case R.id.mrp_height_textview:
                if (mLengths != null && mWidths != null && isHeightSpinnerTouched == true) {

                    hei = mHeights.get(position).getValue().toString();
                    heiSize = mHeights.get(position).getLabel().toString();
                    fetchColorAndPrice(lent, widt, hei);
                }
                break;
            case R.id.mrp_breadth_textview:
                if (mLength != null) {
                    widt = mWidths.get(position).getValue().toString();
                    widtSize = mWidths.get(position).getLabel().toString();

                }

        }

    }

    private void fillDimentionSpinners(final String fetchDimentionByValue) {
        final StringRequest fetchMatDimention = new StringRequest(Request.Method.POST, UrlConstants.FRESH_UP_SPINNER_LXWXH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    parseDimentionDetails(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputProductCategory = new HashMap<>();
                inputProductCategory.put(Constants.SEND_CAT_IDS, fetchDimentionByValue);

                return inputProductCategory;
            }
        };

        RequestQueue sendCatProductValue = Volley.newRequestQueue(this);
        fetchMatDimention.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendCatProductValue.add(fetchMatDimention);

    }

    private void parseDimentionDetails(String dimentionResponse) throws JSONException {
        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        Length length = null;
        mLengths = new ArrayList<>();
        mHLengths = new ArrayList<HashMap<String, Length>>();
        HashMap<String, Length> stringLengthHashMap = new HashMap<>();
        mWidths = new ArrayList<>();
        mHeights = new ArrayList<>();
        JSONObject categoryObject = null;

        categoryObject = new JSONObject(dimentionResponse);
        if (categoryObject.optInt(Constants.SUCCESS_KEY) == 1) {
            if (categoryObject.has(Constants.FRESH_UP_MAT_DIMENTION_LENGTH)) {


                JSONArray categaryArray = categoryObject.getJSONArray(Constants.FRESH_UP_MAT_DIMENTION_LENGTH);

                for (int i = 0; i < categaryArray.length(); i++) {
                    JSONObject jsonSub = categaryArray.getJSONObject(i);
                    String value = jsonSub.getString(Constants.MAT_VALUE);
                    String label = jsonSub.getString(Constants.MAT_LABEL);
                   length = new Length(value, label);
                    //  mLengths.add(length);

                    stringLengthHashMap.put(""+i, length);
                    mHLengths.add(stringLengthHashMap);
                }


               // LengthAdapter lengthAdapter = new LengthAdapter(getApplicationContext(), mLengths);
             //   SupplierSuggestionAdapter supplierSuggestionAdapter = new SupplierSuggestionAdapter(MrpCalculaterActivity.this, R.layout.row_dog, mHLengths);
              HashLenthAdapter hashLenthAdapter = new HashLenthAdapter(getApplicationContext(),layoutItemId,mHLengths);
             mLenTv.setAdapter(hashLenthAdapter);
                //   mLenTv.setThreshold(1);
             //   mLenTv.setAdapter(lengthAdapter);
            }
            if (categoryObject.has(Constants.FRESH_UP_MAT_DIMENTION_WIDTH)) {
                JSONArray categaryArray = categoryObject.getJSONArray(Constants.FRESH_UP_MAT_DIMENTION_WIDTH);

                for (int i = 0; i < categaryArray.length(); i++) {
                    JSONObject jsonSub = categaryArray.getJSONObject(i);
                    String value = jsonSub.getString(Constants.MAT_VALUE);
                    String label = jsonSub.getString(Constants.MAT_LABEL);
                    Width width = new Width(value, label);
                    mWidths.add(width);
                }
                WidthAdapter widthAdapter = new WidthAdapter(getApplicationContext(), mWidths);
                mWidTv.setThreshold(1);
                mWidTv.setAdapter(widthAdapter);


            }
            if (categoryObject.has(Constants.FRESH_UP_MAT_DIMENTION_HEIGHT)) {
                JSONArray categaryArray = categoryObject.getJSONArray(Constants.FRESH_UP_MAT_DIMENTION_HEIGHT);

                for (int i = 0; i < categaryArray.length(); i++) {
                    JSONObject jsonSub = categaryArray.getJSONObject(i);
                    String value = jsonSub.getString(Constants.MAT_VALUE);
                    String label = jsonSub.getString(Constants.MAT_LABEL);
                    Height height = new Height(value, label);
                    mHeights.add(height);
                }
                HeightAdapter heightAdapter = new HeightAdapter(getApplicationContext(), mHeights);
                mHeiTv.setThreshold(1);
                mHeiTv.setAdapter(heightAdapter);

            }

        }
    }

    private void openProductCategorySpinner(final String subCategorySpinnerValue) {
        final StringRequest fetchProductCategory = new StringRequest(Request.Method.POST, UrlConstants.FRESH_UP_SPINNER_PRODUCT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //   Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                parseProductCategoryDetails(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputProductCategory = new HashMap<>();
                inputProductCategory.put(Constants.SENDS_CAT_IDS, subCategorySpinnerValue);

                return inputProductCategory;
            }
        };

        RequestQueue sendSubCatData = Volley.newRequestQueue(this);
        fetchProductCategory.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendSubCatData.add(fetchProductCategory);


    }

    private void parseProductCategoryDetails(String response) {
        mProductModels = new ArrayList<>();
        try {
            JSONObject categoryObject = new JSONObject(response);
            if (categoryObject.optInt(Constants.SUCCESS_KEY) == 1) {
                JSONArray categaryArray = categoryObject.getJSONArray(Constants.RESULT_DATA_KEY);

                for (int i = 0; i < categaryArray.length(); i++) {
                    JSONObject jsonSub = categaryArray.getJSONObject(i);
                    String cat_id = jsonSub.getString("pro_id");
                    String cat_name = jsonSub.getString("pro_name");
                    mProductModel = new ProductModel(cat_id, cat_name);
                    mProductModels.add(mProductModel);
                }

                ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(), mProductModels);
                mCatProductSpinner.setAdapter(productAdapter);
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
        }

    }

    private void fetchColorAndPrice(final String lent, final String widt, final String hei) {
        final StringRequest fetchMatColorAndPrice = new StringRequest(Request.Method.POST, UrlConstants.FRESH_UP_FETCH_COLOR_AND_PRICE, new Response.Listener<String>() {
            ;

            @Override
            public void onResponse(String response) {
                //    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    parseColorAndPrice(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //    mCustomProgressBar.hide();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputMatDimention = new HashMap<>();
                inputMatDimention.put(Constants.SEND_PRO_ID, catProductSpinnerValue);
                inputMatDimention.put(Constants.SEND_USER_TO, userId);
                inputMatDimention.put(Constants.SEND_LENGTH_ID, lent);
                inputMatDimention.put(Constants.SEND_WIDTH_ID, widt);
                inputMatDimention.put(Constants.SEND_HEIGHT_ID, hei);


                return inputMatDimention;
            }
        };

        RequestQueue sendColorPriceValue = Volley.newRequestQueue(this);
        fetchMatColorAndPrice.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendColorPriceValue.add(fetchMatColorAndPrice);


    }

    private void parseColorAndPrice(String matColorAndPrice) throws JSONException {
        mColors = new ArrayList<>();
        JSONObject categoryObject = null;

        categoryObject = new JSONObject(matColorAndPrice);
        if (categoryObject.optString(Constants.RESPOSNE).equals("success")) {

            String itemPrice = categoryObject.getString(Constants.PRICE);
            JSONArray categaryArray = categoryObject.getJSONArray(Constants.FRESH_UP_MAT_COLOUR_LIST);

            for (int i = 0; i < categaryArray.length(); i++) {
                JSONObject jsonSub = categaryArray.getJSONObject(i);
                String value = jsonSub.getString(Constants.MAT_VALUE);
                String label = jsonSub.getString(Constants.MAT_LABEL);
                ColorModel colorModel = new ColorModel(value, label);
                mColors.add(colorModel);
                // mLengths.add(length);
            }
            ColorAdapter colorAdapter = new ColorAdapter(getApplicationContext(), mColors);
            mColor.setAdapter(colorAdapter);
            mPrice.setText(itemPrice);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void openSubCategorySpinner(final String categorySpinnerValue) {
        final String posVal = categorySpinnerValue;

        final StringRequest fetchSubCategory = new StringRequest(Request.Method.POST, UrlConstants.FRESH_UP_SPINNER_SUB_CATEGORY, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                parseSubCategoryDetails(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> inputSubCategory = new HashMap<>();
                inputSubCategory.put(Constants.SENDS_CAT_IDS, posVal);

                return inputSubCategory;
            }
        };

        RequestQueue sendCatData = Volley.newRequestQueue(this);
        fetchSubCategory.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        sendCatData.add(fetchSubCategory);


    }

    private void parseSubCategoryDetails(String response) {
        mSubCategoryModels = new ArrayList<SubCategoryModel>();
        try {
            JSONObject subCategoryObject = new JSONObject(response);
            if (subCategoryObject.optInt(Constants.SUCCESS_KEY) == 1) {
                JSONArray subCategaryArray = subCategoryObject.getJSONArray(Constants.RESULT_DATA_KEY);
                for (int i = 0; i < subCategaryArray.length(); i++) {
                    JSONObject jsonSub = subCategaryArray.getJSONObject(i);
                    String cat_id = jsonSub.getString(Constants.CAT_IDS);
                    String cat_name = jsonSub.getString(Constants.CAT_NAME);

                    mSubCategoryModel = new SubCategoryModel(cat_id, cat_name);
                    mSubCategoryModels.add(mSubCategoryModel);
                  /*  if (subCat == null) {
                        subCat.add(sds);
                    } else {
                        subCat.add(sds);
                    }*/


                }
                SubCategaryAdapter subCategaryAdapter = new SubCategaryAdapter(getApplicationContext(), mSubCategoryModels);
                mSubCategorySpinner.setAdapter(subCategaryAdapter);
                subCategaryAdapter.notifyDataSetChanged();


            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.mrp_lenth_textview:
                mLenTv.setThreshold(0);
                mLenTv.showDropDown();
                break;
            case R.id.mrp_height_textview:
                mHeiTv.setThreshold(0);
                mHeiTv.showDropDown();
                break;
            case R.id.mrp_breadth_textview:
                mWidTv.setThreshold(0);
                mWidTv.showDropDown();
                break;

        }


        return false;
    }


}
