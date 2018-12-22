package com.example.root.testapplicationo.coverflow.it.moondroid.coverflow.components.coverflowdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecentUpdateResponseModal {
    @SerializedName("resp")
    @Expose
    private String resp;
    @SerializedName("result")
    @Expose
    private List<RecentUpdateResponseModalResult> result = null;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public List<RecentUpdateResponseModalResult> getResult() {
        return result;
    }

    public void setResult(List<RecentUpdateResponseModalResult> result) {
        this.result = result;
    }
    public static class RecentUpdateResponseModalResult {

        public static final int VIEW_TYPE_SCEME =1;
        public static final int VIEW_TYPE_NEWS =2;
        public static final int VIEW_TYPE_RECENT_NOTIFICATION =3;



        @SerializedName("r_id")
        @Expose
        private String rId;
        @SerializedName("s_id")
        @Expose
        private String sId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("from_")
        @Expose
        private String from;
        @SerializedName("to_")
        @Expose
        private String to;
        @SerializedName("from_name")
        @Expose
        private String fromName;
        @SerializedName("to_name")
        @Expose
        private String toName;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("view_type")
        @Expose
        private String viewType;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("status")
        @Expose
        private String status;

        public String getRId() {
            return rId;
        }

        public void setRId(String rId) {
            this.rId = rId;
        }

        public String getSId() {
            return sId;
        }

        public void setSId(String sId) {
            this.sId = sId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public String getToName() {
            return toName;
        }

        public void setToName(String toName) {
            this.toName = toName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getViewType() {
            return viewType;
        }

        public void setViewType(String viewType) {
            this.viewType = viewType;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
