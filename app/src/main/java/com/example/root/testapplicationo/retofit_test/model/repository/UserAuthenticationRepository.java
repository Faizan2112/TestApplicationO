package com.example.root.testapplicationo.retofit_test.model.repository;



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
}
