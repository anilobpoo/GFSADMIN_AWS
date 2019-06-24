package com.obpoo.gfsfabricsoftware.fabric.mvp;


import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;

import java.util.List;

public class FabricsPresenterImpl implements FabricsPresenter, FabricsInteracter.FabricsListener {

    FabricsView view;
    FabricsInteracterImpl interacter;

    public FabricsPresenterImpl(FabricsView view) {
        this.view = view;
        interacter = new FabricsInteracterImpl();
    }



    @Override
    public void onSuccess(FabricsResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onLoad(response);
        }
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.hideDialog();
            view.showError(message);
        }
    }

    @Override
    public void viewAll(String methodname) {


        FabricsRequest request =new FabricsRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void addFabric(String methodname, String fab_img, String thumbnail, String texture, String fab_name, String article_no_id,
                          String width, String colors_id, String cost_pr_mtr, String cost_pr_yrd, String sell_pr_mtr, String sell_pr_yrd,
                          String min_stock_mtr, String min_stock_yrd, String max_stock_mtr, String max_stock_yrd, String description, List color_desc, String min_stock_user_mtr, String min_stock_user_yrd, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs, String price1to9mtrs, String price10plusmtrs) {
        FabricsRequest request =new FabricsRequest(methodname,fab_img,thumbnail,texture,fab_name,
                article_no_id,width,colors_id,cost_pr_mtr,cost_pr_yrd,sell_pr_mtr,sell_pr_yrd,min_stock_mtr,min_stock_yrd,max_stock_mtr,max_stock_yrd,description,color_desc,min_stock_user_mtr,min_stock_user_yrd,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price1to9mtrs,price10plusmtrs);
        interacter.viewList(request,this);
    }

    @Override
    public void updateFabric(String methodname, String fab_img, String thumbnail, String texture, String fab_name, String article_no_id, String width, String colors_id, String cost_pr_mtr, String cost_pr_yrd, String sell_pr_mtr, String sell_pr_yrd, String min_stock_mtr, String min_stock_yrd, String max_stock_mtr, String max_stock_yrd, String description, List color_desc, String min_stock_user_mtr, String min_stock_user_yrd, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs, String price1to9mtrs, String price10plusmtrs, String id) {
        FabricsRequest request =new FabricsRequest(methodname,fab_img,thumbnail,texture,fab_name,
                article_no_id,width,colors_id,cost_pr_mtr,cost_pr_yrd,sell_pr_mtr,sell_pr_yrd,min_stock_mtr,min_stock_yrd,max_stock_mtr,max_stock_yrd,description,color_desc,min_stock_user_mtr,min_stock_user_yrd,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price1to9mtrs,price10plusmtrs,id);
        interacter.viewList(request,this);
    }


    @Override
    public void deletFabric(String methodname, String id) {
        FabricsRequest request =new FabricsRequest(methodname,id);
        interacter.viewList(request,this);
    }


}
