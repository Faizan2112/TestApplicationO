package com.example.root.testapplicationo.anewhome;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Spinner;
import com.example.root.testapplicationo.custom_text_field.Length;
import com.example.root.testapplicationo.custom_text_field.LengthAdapter;
import com.example.root.testapplicationo.retofit_test.model.repository.UserAuthenticationRepository;
import com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate.UserAuthenticationState;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivityViewModel extends ViewModel {
    Context mContext;
    ArrayList<Length> lengths;
    UserAuthenticationRepository mUserAuthenticationRepository = new UserAuthenticationRepository();
    ;
    private ProductResponseModel mProductResponseModel = new ProductResponseModel();
    private MutableLiveData<UserAuthenticationState<ArrayList<ProductResponseModel>>> mResultListMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserAuthenticationState<ArrayList<ProductResponseModel>>> subcribeForCategorySpinnerData() {
        return mResultListMutableLiveData;
    }

    private MutableLiveData<UserAuthenticationState> mUserAuthenticationState = new MutableLiveData<>();

    public MutableLiveData<UserAuthenticationState> subcribeForCategorySpinner() {
        return mUserAuthenticationState;
    }

    public MutableLiveData<UserAuthenticationState> subcribeForSubCategorySpinner() {
        return mUserAuthenticationState;
    }

    public MutableLiveData<UserAuthenticationState> subcribeForProductCategorySpinner() {
        return mUserAuthenticationState;
    }

    public MutableLiveData<UserAuthenticationState> subcribeForLxWxH() {
        return mUserAuthenticationState;
    }

    public MutableLiveData<UserAuthenticationState> subcribeForColor() {
        return mUserAuthenticationState;
    }

    public  void fetchSpinnerData()
    {
     mResultListMutableLiveData.postValue(UserAuthenticationState.loading(null));

     mUserAuthenticationRepository.setCatProSpin(new Callback<ProductResponseModel>() {
         @Override
         public void onResponse(Call<ProductResponseModel> call, Response<ProductResponseModel> response) {
             mResultListMutableLiveData.postValue(UserAuthenticationState.success(response.body()));
         }

         @Override
         public void onFailure(Call<ProductResponseModel> call, Throwable t) {

         }
     });

    }

   /* public void setCategorySpinner(final Spinner homeCategorySpinner, final Context mContext) {
        lengths = new ArrayList<>();
        {
            mUserAuthenticationState.postValue(UserAuthenticationState.loading(mProductResponseModel));
            mUserAuthenticationRepository.setCatProSpin(new Callback<ProductResponseModel>() {

                public void onResponse(Call<ProductResponseModel> call, Response<ProductResponseModel> response) {
                    mUserAuthenticationState.postValue(UserAuthenticationState.success(response.body()));
                    //   String val = response.body().getSuccess().toString();
                    int len = response.body().getResultData().size();
                    for (int i = 0; i < len; i++) {
                        ResultCategoryData resultCategoryData = response.body().getResultData().get(i);
                        String catCode = resultCategoryData.getCatId();
                        String catValue = resultCategoryData.getCatName();
                        Length length = new Length(catCode, catValue);
                        lengths.add(length);

                    }
                    LengthAdapter lengthAdapters = new LengthAdapter(mContext,  lengths);
                    homeCategorySpinner.setAdapter(lengthAdapters);

                    // Log.i("RESPONSE", "" + response.body().toString());
                }


                public void onFailure(Call<ProductResponseModel> call, Throwable t) {
                    mUserAuthenticationState.postValue(UserAuthenticationState.error(new Exception(t)));
                    Log.i("RESPONSE", "" + t.toString());
                }
            });
        }

    }
*/
    public void setSubCategorySpinner(String val) {


    }

    public void setProductCategorySpinner(String val) {


    }

    public void setLXWXH(String val) {


    }

    public void setPriceAndQuantity(String val) {


    }


}
