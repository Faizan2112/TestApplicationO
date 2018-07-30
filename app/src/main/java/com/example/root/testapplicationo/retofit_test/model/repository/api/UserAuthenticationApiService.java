package com.example.root.testapplicationo.retofit_test.model.repository.api;

import com.example.root.testapplicationo.anewhome.ProductResponseModel;
import com.example.root.testapplicationo.retofit_test.model.repository.api.responsemodel.UserLoginApiResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by root on 3/16/18.
 */

public interface UserAuthenticationApiService {

    @FormUrlEncoded
    @POST("/api/login")
    Call<UserLoginApiResponse> setUserLogin(@Field("number") String mobileNumber);

    @FormUrlEncoded
    @POST("/api/login")
    Call<UserLoginApiResponse> setTestUserLogin(@Field("number") String mobileNumber);

// form Url encoded is only used with post

    @GET("/freshup_oms/api/getAllCategory")
    Call<ProductResponseModel> setCatData();


    @FormUrlEncoded
    @POST("/freshup_oms/api/getAllSubCategory")
    Call<ProductResponseModel> setSubCatData(@Field("catid") String value);

}
