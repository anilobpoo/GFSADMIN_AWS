package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PHD on 11/19/2018.
 */

public class cmnArticelPOJOdata {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("simillar_article_no")
    @Expose
    private List<String> simillarArticleNo = null;
    @SerializedName("Quality_description")
    @Expose
    private String qualityDescription;
    @SerializedName("Quality_name")
    @Expose
    private String qualityName;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getSimillarArticleNo() {
        return simillarArticleNo;
    }

    public void setSimillarArticleNo(List<String> simillarArticleNo) {
        this.simillarArticleNo = simillarArticleNo;
    }

    public String getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(String qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
