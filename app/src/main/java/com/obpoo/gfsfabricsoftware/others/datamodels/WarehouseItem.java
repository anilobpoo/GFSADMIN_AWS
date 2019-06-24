package com.obpoo.gfsfabricsoftware.others.datamodels;

public class WarehouseItem {

    String id;
    String warehouse_name;
    String warehouse_no;
    String shopNo;
    String locality;
    String address;
    String can_sell_part;
    String warebranch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getWarehouse_no() {
        return warehouse_no;
    }

    public void setWarehouse_no(String warehouse_no) {
        this.warehouse_no = warehouse_no;
    }

    public String getShopNo() {
        return shopNo;
    }

    String shopname;

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCan_sell_part() {
        return can_sell_part;
    }

    public void setCan_sell_part(String can_sell_part) {
        this.can_sell_part = can_sell_part;
    }

    public String getWarebranch() {
        return warebranch;
    }

    public void setWarebranch(String warebranch) {
        this.warebranch = warebranch;
    }

    public String getMin_max_cat_id() {
        return min_max_cat_id;
    }

    public void setMin_max_cat_id(String min_max_cat_id) {
        this.min_max_cat_id = min_max_cat_id;
    }

    public String getWaretype() {
        return waretype;
    }

    public void setWaretype(String waretype) {
        this.waretype = waretype;
    }

    public String getUserin() {
        return userin;
    }

    public void setUserin(String userin) {
        this.userin = userin;
    }

    public String getUserout() {
        return userout;
    }

    public void setUserout(String userout) {
        this.userout = userout;
    }

    public String getAvailable_status() {
        return Available_status;
    }

    public void setAvailable_status(String available_status) {
        Available_status = available_status;
    }

    String min_max_cat_id;
    String waretype;
    String userin;
    String userout;
    String Available_status;
}
