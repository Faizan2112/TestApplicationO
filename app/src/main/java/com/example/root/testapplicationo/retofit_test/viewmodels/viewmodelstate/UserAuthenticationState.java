package com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate;

import android.support.annotation.NonNull;

/**
 * Created by root on 3/16/18.
 */

public class UserAuthenticationState<T> {
    public enum Status {SUCCESS, ERROR, LOADING}


    @NonNull
    private Status status;
    private T userData;
    private Exception exception;


    private UserAuthenticationState(@NonNull Status status, T userData, Exception exception) {
        this.status = status;
        this.userData = userData;
        this.exception = exception;
    }

    public static <T> UserAuthenticationState success(T data) {

        return new UserAuthenticationState(Status.SUCCESS, data, null);

    }
    public static UserAuthenticationState error(Exception exception) {
        return new UserAuthenticationState(Status.ERROR, null, exception);
    }

    public static <T> UserAuthenticationState loading(T data) {
        return new UserAuthenticationState(Status.LOADING, data, null);
    }

    public Status getStatus(){return status;}
    public T getUserData() {
        return userData;
    }

    public Exception getException() {
        return exception;
    }

}