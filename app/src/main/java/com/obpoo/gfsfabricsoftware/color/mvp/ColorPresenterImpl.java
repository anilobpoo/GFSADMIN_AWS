package com.obpoo.gfsfabricsoftware.color.mvp;


import com.obpoo.gfsfabricsoftware.color.datamodels.ColorRequest;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;

public class ColorPresenterImpl implements ColorPresenter, ColorInteracter.ColorListener {

    ColorView view;
    ColorInteracterImpl interacter;

    public ColorPresenterImpl(ColorView view) {
        this.view = view;
        interacter = new ColorInteracterImpl();
    }



    @Override
    public void onSuccess(ColorResponse response) {
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

        ColorRequest request =new ColorRequest(methodname);
        interacter.viewShopList(request,this);
    }

    @Override
    public void delete(String methodname, String id) {
        ColorRequest request =new ColorRequest(methodname,id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void add(String methodname, String color_code, String add) {
        ColorRequest request =new ColorRequest(methodname,color_code,add);
        interacter.viewShopList(request,this);
    }

    @Override
    public void update(String methodname, String color_code, String id, String update) {
        ColorRequest request =new ColorRequest(methodname,color_code,id,update);
        interacter.viewShopList(request,this);

    }


}
