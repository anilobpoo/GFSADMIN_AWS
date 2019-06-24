package com.obpoo.gfsfabricsoftware.fabric.datamodels;

import java.util.List;

public class FabricsRequest {


    String method,id;
    String methodname; String fab_img; String fab_name; String article_no_id; String width; String colors_id;
    String composition_code_id; String cost_pr_mtr; String cost_pr_yrd;
    String sell_pr_mtr; String sell_pr_yrd;
    String min_stock_mtr; String min_stock_yrd; String max_stock_mtr; String max_stock_yrd; String description;
    String texture,thumbnail;
    List color_desc;
    String min_stock_user_mtr,min_stock_user_yrd,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price10plusmtrs,price1to9mtrs;

    public FabricsRequest(String method) {
        this.method = method;
    }
    public FabricsRequest(String method,String id) {
        this.method = method;
        this.id = id;
    }


    public FabricsRequest(String methodname, String fab_img,String thumbnail,String texture, String fab_name, String article_no_id, String width, String colors_id, String cost_pr_mtr, String cost_pr_yrd, String sell_pr_mtr, String sell_pr_yrd,
                          String min_stock_mtr, String min_stock_yrd, String max_stock_mtr, String max_stock_yrd, String description,
                          List color_desc,String min_stock_user_mtr,String min_stock_user_yrd,String pricefullroll,String price1to9,String price10plus,String pricefullrollmtrs,String price1to9mtrs,String price10plusmtrs) {
        this.method = methodname;
        this.fab_img = fab_img;
        this.fab_name = fab_name;
        this.article_no_id = article_no_id;
        this.width = width;
        this.colors_id = colors_id;
        this.cost_pr_mtr = cost_pr_mtr;
        this.cost_pr_yrd = cost_pr_yrd;
        this.sell_pr_mtr = sell_pr_mtr;
        this.sell_pr_yrd = sell_pr_yrd;
        this.min_stock_mtr = min_stock_mtr;
        this.min_stock_yrd = min_stock_yrd;
        this.max_stock_mtr = max_stock_mtr;
        this.max_stock_yrd = max_stock_yrd;
        this.description = description;
        this.thumbnail = thumbnail;
        this.texture = texture;
        this.color_desc = color_desc;
        this.min_stock_user_yrd = min_stock_user_yrd;
        this.min_stock_user_mtr = min_stock_user_mtr;
        this.pricefullroll = pricefullroll;
        this.price1to9 = price1to9;
        this.price10plus = price10plus;
        this.pricefullrollmtrs = pricefullrollmtrs;
        this.price10plusmtrs = price10plusmtrs;
        this.price1to9mtrs = price1to9mtrs;

    }





    public FabricsRequest(String methodname, String fab_img,String thumbnail,String texture, String fab_name, String article_no_id, String width, String colors_id, String cost_pr_mtr, String cost_pr_yrd, String sell_pr_mtr, String sell_pr_yrd,
                          String min_stock_mtr, String min_stock_yrd, String max_stock_mtr, String max_stock_yrd, String description,
                          List color_desc,String min_stock_user_mtr,String min_stock_user_yrd,String pricefullroll,String price1to9,String price10plus,String pricefullrollmtrs,String price1to9mtrs,String price10plusmtrs,String id) {
        this.method = methodname;
        this.fab_img = fab_img;
        this.fab_name = fab_name;
        this.article_no_id = article_no_id;
        this.width = width;
        this.colors_id = colors_id;
        this.cost_pr_mtr = cost_pr_mtr;
        this.cost_pr_yrd = cost_pr_yrd;
        this.sell_pr_mtr = sell_pr_mtr;
        this.sell_pr_yrd = sell_pr_yrd;
        this.min_stock_mtr = min_stock_mtr;
        this.min_stock_yrd = min_stock_yrd;
        this.max_stock_mtr = max_stock_mtr;
        this.max_stock_yrd = max_stock_yrd;
        this.description = description;
        this.thumbnail = thumbnail;
        this.texture = texture;
        this.color_desc = color_desc;
        this.min_stock_user_yrd = min_stock_user_yrd;
        this.min_stock_user_mtr = min_stock_user_mtr;
        this.pricefullroll = pricefullroll;
        this.price1to9 = price1to9;
        this.price10plus = price10plus;
        this.pricefullrollmtrs = pricefullrollmtrs;
        this.price10plusmtrs = price10plusmtrs;
        this.price1to9mtrs = price1to9mtrs;
        this.id = id;

    }



}
