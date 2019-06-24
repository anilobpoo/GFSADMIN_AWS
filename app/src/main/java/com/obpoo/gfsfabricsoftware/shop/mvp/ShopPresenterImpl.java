package com.obpoo.gfsfabricsoftware.shop.mvp;


import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ViewShopRequest;

public class ShopPresenterImpl implements ShopPresenter, ShopInteracter.ShopListener {

    ShopView view;
    ShopInteracterImpl interacter;

    public ShopPresenterImpl(ShopView view) {
        this.view = view;
        interacter = new ShopInteracterImpl();
    }



    @Override
    public void onSuccess(ShopResponse response) {
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


        ViewShopRequest request =new ViewShopRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String name, String location, String address, String min_max_type) {
        ViewShopRequest request =new ViewShopRequest(methodname,name,location,address,min_max_type);
        interacter.viewList(request,this);
    }

    @Override
    public void delete(String methodname, String id) {
        ViewShopRequest request =new ViewShopRequest(methodname,id);
        interacter.viewList(request,this);
    }

    @Override
    public void edit(String methodname, String name, String location, String address, String min_max_type, String id) {
        ViewShopRequest request =new ViewShopRequest(methodname,name,location,address,min_max_type,id);
        interacter.viewList(request,this);
    }

    @Override
    public void getone(String methodname, String id, String getone) {
        ViewShopRequest request =new ViewShopRequest(methodname,id,getone);
        interacter.viewList(request,this);
    }
}
