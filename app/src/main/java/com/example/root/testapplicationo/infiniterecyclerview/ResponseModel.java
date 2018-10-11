package com.example.root.testapplicationo.infiniterecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel  {
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Integer quotaRemaining;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }



    public class Item {

        @SerializedName("owner")
        @Expose
        private Owner owner;
        @SerializedName("is_accepted")
        @Expose
        private Boolean isAccepted;
        @SerializedName("score")
        @Expose
        private Integer score;
        @SerializedName("last_activity_date")
        @Expose
        private Integer lastActivityDate;
        @SerializedName("creation_date")
        @Expose
        private Integer creationDate;
        @SerializedName("answer_id")
        @Expose
        private Integer answerId;
        @SerializedName("question_id")
        @Expose
        private Integer questionId;
        @SerializedName("last_edit_date")
        @Expose
        private Integer lastEditDate;

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Boolean getIsAccepted() {
            return isAccepted;
        }

        public void setIsAccepted(Boolean isAccepted) {
            this.isAccepted = isAccepted;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public Integer getLastActivityDate() {
            return lastActivityDate;
        }

        public void setLastActivityDate(Integer lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
        }

        public Integer getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Integer creationDate) {
            this.creationDate = creationDate;
        }

        public Integer getAnswerId() {
            return answerId;
        }

        public void setAnswerId(Integer answerId) {
            this.answerId = answerId;
        }

        public Integer getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

        public Integer getLastEditDate() {
            return lastEditDate;
        }

        public void setLastEditDate(Integer lastEditDate) {
            this.lastEditDate = lastEditDate;
        }

    }

        public class Owner {

            @SerializedName("reputation")
            @Expose
            private Integer reputation;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("user_type")
            @Expose
            private String userType;
            @SerializedName("profile_image")
            @Expose
            private String profileImage;
            @SerializedName("display_name")
            @Expose
            private String displayName;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("accept_rate")
            @Expose
            private Integer acceptRate;

            public Integer getReputation() {
                return reputation;
            }

            public void setReputation(Integer reputation) {
                this.reputation = reputation;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getProfileImage() {
                return profileImage;
            }

            public void setProfileImage(String profileImage) {
                this.profileImage = profileImage;
            }

            public String getDisplayName() {
                return displayName;
            }

            public void setDisplayName(String displayName) {
                this.displayName = displayName;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public Integer getAcceptRate() {
                return acceptRate;
            }

            public void setAcceptRate(Integer acceptRate) {
                this.acceptRate = acceptRate;
            }
        }

}





