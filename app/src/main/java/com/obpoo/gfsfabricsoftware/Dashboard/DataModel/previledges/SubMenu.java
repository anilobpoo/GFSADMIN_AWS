package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubMenu {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("sub_menu_name")
    @Expose
    private String subMenuName;
    @SerializedName("options")
    @Expose
    private List<String> options = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
