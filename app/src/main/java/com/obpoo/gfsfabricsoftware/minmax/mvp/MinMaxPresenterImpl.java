package com.obpoo.gfsfabricsoftware.minmax.mvp;


import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxRequest;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;

public class MinMaxPresenterImpl implements MinMaxPresenter, MinMaxInteracter.MinMaxListener {

    MinMaxView view;
    MinMaxInteracterImpl interacter;

    public MinMaxPresenterImpl(MinMaxView view) {
        this.view = view;
        interacter = new MinMaxInteracterImpl();
    }



    @Override
    public void onSuccess(MinMaxResponse response) {
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


        MinMaxRequest request =new MinMaxRequest(methodname);
        interacter.viewShopList(request,this);
    }

    @Override
    public void add(String methodname, String title) {
        MinMaxRequest request =new MinMaxRequest(methodname,title);
        interacter.viewShopList(request,this);
    }

    @Override
    public void del(String methodname, String id, String del, String dels) {
        MinMaxRequest request =new MinMaxRequest(methodname,id,del,dels);
        interacter.viewShopList(request,this);
    }

    @Override
    public void update(String methodname, String title, String id) {
        MinMaxRequest request =new MinMaxRequest(methodname,title,id);
        interacter.viewShopList(request,this);

    }
}
