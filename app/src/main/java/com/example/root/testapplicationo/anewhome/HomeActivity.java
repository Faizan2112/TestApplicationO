package com.example.root.testapplicationo.anewhome;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.databinding.ActivityHomeBinding;
import com.example.root.testapplicationo.retofit_test.viewmodels.LoginActivityViewModel;
import com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate.UserAuthenticationState;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    Context mContext;
    ActivityHomeBinding mActivityHomeBinding;
    HomeActivityViewModel mHomeActivityViewModel;
    ArrayList<ProductResponseModel> resultCategoryData = new ArrayList<>();
    RecyclerView mProductRecyclerView;
    SpinnerAdapters mSpinnerAdapters;


    private LoginActivityViewModel mLoginActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mSpinnerAdapters = new SpinnerAdapters(resultCategoryData);

        mHomeActivityViewModel = ViewModelProviders.of(HomeActivity.this).get(HomeActivityViewModel.class);

        initView();

        initRvChatDialog();
        itemClickListners();

        //mHomeActivityViewModel.setCategorySpinner(mActivityHomeBinding.homeCategorySpinner,mContext);
        subscribeFor();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHomeActivityViewModel.fetchSpinnerData();

    }


    private void initRvChatDialog() {
        mProductRecyclerView = findViewById(R.id.test_recycler_view);
        mProductRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProductRecyclerView.setAdapter(mSpinnerAdapters);
    }

    private void subscribeFor() {
        mHomeActivityViewModel.subcribeForCategorySpinnerData().observe(this, new Observer<UserAuthenticationState<ArrayList<ProductResponseModel>>>() {
            @Override
            public void onChanged(@Nullable UserAuthenticationState<ArrayList<ProductResponseModel>> arrayListUserAuthenticationState) {
                switch (arrayListUserAuthenticationState.getStatus()) {
                    case LOADING:
                        Toast.makeText(HomeActivity.this, "Loading In....", Toast.LENGTH_SHORT).show();

                        break ;

                    case SUCCESS:
                        //mSpinnerAdapters = new SpinnerAdapters(m);
                         mSpinnerAdapters.setAdapterItemList(arrayListUserAuthenticationState.getUserData());

                      break ;


                }
            }
        });

       /* mHomeActivityViewModel.subcribeForCategorySpinner().observe(this, new Observer<UserAuthenticationState>() {
            @Override
            public void onChanged(@Nullable UserAuthenticationState userAuthenticationState) {
                if (userAuthenticationState.getStatus() == UserAuthenticationState.Status.SUCCESS) {
                  //  Log.i("Response In View", "" + userAuthenticationState.getUserData().toString());
                    Toast.makeText(getApplicationContext(),"cat spinner toched",Toast.LENGTH_LONG);

                }
            }
        });*/
    }


    private void itemClickListners() {
        //upper spinner cat
        mActivityHomeBinding.homeCategorySpinner.setOnItemSelectedListener(this);
        mActivityHomeBinding.homeCategorySpinner.setOnTouchListener(this);

        //sub category
        mActivityHomeBinding.homeSubCategorySpinner.setOnItemSelectedListener(this);
        mActivityHomeBinding.homeSubCategorySpinner.setOnTouchListener(this);

        //product select
        mActivityHomeBinding.homeCatProduct.setOnItemSelectedListener(this);
        // mActivityHomeBinding.homeCatProduct.setOnItemClickListener(this);

        //autocomplete text view
        // width
        mActivityHomeBinding.mrpBreadthTextview.setOnTouchListener(this);
        mActivityHomeBinding.mrpBreadthTextview.setOnItemSelectedListener(this);
        mActivityHomeBinding.mrpBreadthTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // height
        mActivityHomeBinding.mrpHeightTextview.setOnItemSelectedListener(this);
        mActivityHomeBinding.mrpHeightTextview.setOnTouchListener(this);
        mActivityHomeBinding.mrpHeightTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //length
        mActivityHomeBinding.mrpLenthTextview.setOnTouchListener(this);
        mActivityHomeBinding.mrpLenthTextview.setOnTouchListener(this);
        mActivityHomeBinding.mrpLenthTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initView() {
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.home_category_spinner:
                openSubCategarySpinner(adapterView, view, i, l, 1);

                break;

            case R.id.home_sub_category_spinner:
                openSubCategarySpinner(adapterView, view, i, l, 2);
                break;
        }


    }

    private void openSubCategarySpinner(AdapterView<?> adapterView, View view, int i, long l, int i1) {

        switch (i1) {
            case 1:
                Toast.makeText(getApplicationContext(), "cat spinner toched", Toast.LENGTH_LONG);
                // mHomeActivityViewModel.setCategorySpinner();
                break;

            case 2:

                Toast.makeText(getApplicationContext(), "sub cat spinner toched", Toast.LENGTH_LONG);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
