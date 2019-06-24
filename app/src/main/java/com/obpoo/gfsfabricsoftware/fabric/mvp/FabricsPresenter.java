package com.obpoo.gfsfabricsoftware.fabric.mvp;

import java.util.List;

public interface FabricsPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void addFabric(String methodname,String fab_img,String thumbnail,String texture,String fab_name,String article_no_id,String width,String colors_id,String cost_pr_mtr,String cost_pr_yrd,String sell_pr_mtr,String sell_pr_yrd,
                  String min_stock_mtr,String min_stock_yrd,String max_stock_mtr,String max_stock_yrd,String description,List color_desc, String min_stock_user_mtr, String min_stock_user_yrd, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs, String price1to9mtrs, String price10plusmtrs);
   void updateFabric(String methodname, String fab_img, String thumbnail, String texture, String fab_name, String article_no_id, String width, String colors_id, String cost_pr_mtr, String cost_pr_yrd, String sell_pr_mtr, String sell_pr_yrd,
                     String min_stock_mtr, String min_stock_yrd, String max_stock_mtr, String max_stock_yrd, String description, List color_desc, String min_stock_user_mtr, String min_stock_user_yrd, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs, String price1to9mtrs, String price10plusmtrs,String id);
   void deletFabric(String methodname,String id);
}
