package com.example.root.testapplicationo.mvvmtestnew.models.repository.api.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JoinedResponseData {
    @SerializedName("resp")
    @Expose
    private String resp;
    @SerializedName("template")
    @Expose
    private List<SearchResponseTemplateModel> template = null;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public List<SearchResponseTemplateModel> getTemplate() {
        return template;
    }

    public void setTemplate(List<SearchResponseTemplateModel> template) {
        this.template = template;
    }
}
