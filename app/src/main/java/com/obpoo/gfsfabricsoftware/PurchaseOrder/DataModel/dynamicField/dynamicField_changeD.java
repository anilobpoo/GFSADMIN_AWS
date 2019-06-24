package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField;

import java.io.Serializable;

/**
 * Created by PHD on 1/11/2019.
 */

public class dynamicField_changeD implements Serializable{
    String fabImage,composition,article,customer,qty_mtr,gty_yard,brand;

    public String getBrand() {
        return brand;
    }

    public dynamicField_changeD(String fabImage, String composition, String article, String customer, String qty_mtr, String gty_yard, String brand) {
        this.fabImage = fabImage;
        this.composition = composition;
        this.article = article;
        this.customer = customer;
        this.qty_mtr = qty_mtr;
        this.gty_yard = gty_yard;

        this.brand=brand;
    }

    public String getFabImage() {
        return fabImage;
    }

    public String getComposition() {
        return composition;
    }

    public String getArticle() {
        return article;
    }

    public String getCustomer() {
        return customer;
    }

    public String getQty_mtr() {
        return qty_mtr;
    }

    public String getGty_yard() {
        return gty_yard;
    }
}
