package com.example.root.testapplicationo.anewhome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponseModel {
    @SerializedName("result_data")
    @Expose
    private List<ResultCategoryData> resultData = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<ResultCategoryData> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultCategoryData> resultData) {
        this.resultData = resultData;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
