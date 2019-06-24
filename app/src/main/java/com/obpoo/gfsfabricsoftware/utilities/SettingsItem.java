package com.obpoo.gfsfabricsoftware.utilities;

/**
 * Created by someo on 16-05-2018.
 */

public class SettingsItem {
    private String name;
    private int thumbnail;

    public SettingsItem() {
    }

    public SettingsItem(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}