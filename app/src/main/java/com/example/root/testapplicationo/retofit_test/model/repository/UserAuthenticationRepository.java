package com.example.root.testapplicationo.retofit_test.model.repository;



import com.example.root.testapplicationo.anewhome.ProductResponseModel;
import com.example.root.testapplicationo.infiniterecyclerview.ResponseModel;
import com.example.root.testapplicationo.retofit_test.model.repository.api.RetrofitAPIController;
import com.example.root.testapplicationo.retofit_test.model.repository.api.UserAuthenticationApiService;
import com.example.root.testapplicationo.retofit_test.model.repository.api.responsemodel.UserLoginApiResponse;


import retrofit2.Call;
import retrofit2.Callback;
/**
 * Created by root on 3/15/18.
 */

public class UserAuthenticationRepository {

    public void setUserLoginByMobileNumber(Callback<UserLoginApiResponse> callback, String mobileNumber)
    {
        UserAuthenticationApiService apiClient = RetrofitAPIController.getRetrofitApiTestClient(UserAuthenticationApiService.class);
        Call<UserLoginApiResponse> call = apiClient.setTestUserLogin(mobileNumber);
        call.enqueue(callback);
    }

    public void setCatProSpin(Callback<ProductResponseModel> callback) {
        UserAuthenticationApiService apiService = RetrofitAPIController.getRetofitApiClient(UserAuthenticationApiService.class);
        Call<ProductResponseModel> productResponseModelCall = apiService.setCatData();
        productResponseModelCall.enqueue(callback);
    }

    public void setSubCatProSpin(Callback<ProductResponseModel> callback ,String val)
    {
        UserAuthenticationApiService apiService = RetrofitAPIController.getRetofitApiClient(UserAuthenticationApiService.class);
        Call<ProductResponseModel> productResponseModelCallback = apiService.setSubCatData(val);
        productResponseModelCallback.enqueue(callback);


    }

    public void getUserAnswer(Callback<ResponseModel> callback , int page ,int pagesize,String site)
    {
        UserAuthenticationApiService apiService = RetrofitAPIController.getRetofitApiClient(UserAuthenticationApiService.class);
        Call<ResponseModel> productResponseModelCallback = apiService.getAnswers(page,pagesize,site);
        productResponseModelCallback.enqueue(callback);


    }

}
