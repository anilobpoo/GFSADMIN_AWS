package com.obpoo.gfsfabricsoftware.others.datamodels.master;

public class ShopItem {

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    String address;
    String location;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMin_max_type() {
        return min_max_type;
    }

    public void setMin_max_type(String min_max_type) {
        this.min_max_type = min_max_type;
    }

    String min_max_type;
}
