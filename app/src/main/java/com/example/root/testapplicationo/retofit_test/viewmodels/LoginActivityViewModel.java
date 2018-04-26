package com.example.root.testapplicationo.retofit_test.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.root.testapplicationo.retofit_test.model.repository.UserAuthenticationRepository;
import com.example.root.testapplicationo.retofit_test.model.repository.api.responsemodel.UserLoginApiResponse;
import com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate.UserAuthenticationState;


import retrofit2.Callback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by root on 3/15/18.
 */

public class LoginActivityViewModel extends ViewModel {
    private UserAuthenticationRepository mUserAuthenticationRepository = new UserAuthenticationRepository();
    private UserLoginApiResponse mUserLoginApiResponse = new UserLoginApiResponse();
    private MutableLiveData<UserAuthenticationState> mUserAuthenticationState = new MutableLiveData<>();
    public MutableLiveData<UserAuthenticationState> subscribeForUserLoginByNumber() {
        return mUserAuthenticationState;
    }

    public void setUserLoginByMobileNumber(String mobileNumber )
    {
        mUserAuthenticationState.postValue(UserAuthenticationState.loading(mUserLoginApiResponse));
         mUserAuthenticationRepository.setUserLoginByMobileNumber(new Callback<UserLoginApiResponse>() {

             public void onResponse(Call<UserLoginApiResponse> call, Response<UserLoginApiResponse> response) {
                 mUserAuthenticationState.postValue(UserAuthenticationState.success(response.body()));
                 Log.i("RESPONSE", "" + response.body().toString());
             }


             public void onFailure(Call<UserLoginApiResponse> call, Throwable t) {
                 mUserAuthenticationState.postValue(UserAuthenticationState.error(new Exception(t)));
                 Log.i("RESPONSE", "" + t.toString());
             }
         }, mobileNumber);
    }
    }

