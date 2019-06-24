package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField;

/**
 * Created by PHD on 11/24/2018.
 */

public class dynamicField {
    String article_bean,color_bean,qty_bean,fab_name,fab_image,brandname;

    public dynamicField(String article_bean, String color_bean, String qty_bean, String fab_name, String fab_image,String brandname) {
        this.article_bean = article_bean;
        this.color_bean = color_bean;
        this.qty_bean = qty_bean;
        this.fab_name = fab_name;
        this.fab_image = fab_image;
        this.brandname = brandname;
    }

    public String getArticle_bean() {
        return article_bean;
    }

    public String getColor_bean() {
        return color_bean;
    }

    public String getQty_bean() {
        return qty_bean;
    }

    public String getFab_name() {
        return fab_name;
    }

    public String getFab_image() {
        return fab_image;
    }


    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
