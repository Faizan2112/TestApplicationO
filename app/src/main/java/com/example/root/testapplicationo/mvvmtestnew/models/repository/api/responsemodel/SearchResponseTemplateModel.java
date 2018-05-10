package com.example.root.testapplicationo.mvvmtestnew.models.repository.api.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponseTemplateModel {
    @SerializedName("m_id")
    @Expose
    private String mId;
    @SerializedName("institute")
    @Expose
    private String institute;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("stream")
    @Expose
    private String stream;
    @SerializedName("enroll_no")
    @Expose
    private String enrollNo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("t_address")
    @Expose
    private String tAddress;
    @SerializedName("p_address")
    @Expose
    private String pAddress;
    @SerializedName("image_then")
    @Expose
    private String imageThen;
    @SerializedName("image_now")
    @Expose
    private String imageNow;
    @SerializedName("pin_code")
    @Expose
    private String pinCode;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(String enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTAddress() {
        return tAddress;
    }

    public void setTAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String getPAddress() {
        return pAddress;
    }

    public void setPAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getImageThen() {
        return imageThen;
    }

    public void setImageThen(String imageThen) {
        this.imageThen = imageThen;
    }

    public String getImageNow() {
        return imageNow;
    }

    public void setImageNow(String imageNow) {
        this.imageNow = imageNow;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
