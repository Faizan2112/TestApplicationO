package com.example.root.testapplicationo.custom_text_field;

/**
 * Created by root on 2/26/18.
 */

public class SubCategoryModel {
    private String mCategoryId ;
    private String mCategoryName ;

    public SubCategoryModel(String mCategoryId, String mCategoryName) {
        this.mCategoryId = mCategoryId;
        this.mCategoryName = mCategoryName;
    }


    public String getmCategoryId() {
        return mCategoryId;
    }

    public void setmCategoryId(String mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public void setmCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }
}
