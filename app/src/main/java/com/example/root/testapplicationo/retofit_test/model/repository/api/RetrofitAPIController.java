package com.example.root.testapplicationo.retofit_test.model.repository.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 3/16/18.
 */

public class RetrofitAPIController {
 //   private static final String BASE_URL = "http://webworldindia.com/" ;
    private static final String TEST_BASE_URL = "http://demo2741469.mockable.io/";
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    public static <T> T getRetofitApiClient(Class<T> classRef)
    {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(classRef);


    }

    public static <T> T getRetrofitApiTestClient(Class<T> classRef)
    {
        return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(classRef);

    }
}
