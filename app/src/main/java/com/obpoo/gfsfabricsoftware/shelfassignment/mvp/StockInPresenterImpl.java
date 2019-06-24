package com.obpoo.gfsfabricsoftware.shelfassignment.mvp;


import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInRequest;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;

import java.util.List;

public class StockInPresenterImpl implements StockInPresenter, StockInInteracter.StockInListener {

    StockInView view;
    StockInInteracterImpl interacter;

    public StockInPresenterImpl(StockInView view) {
        this.view = view;
        interacter = new StockInInteracterImpl();
    }

    @Override
    public void onSuccess(StockInResponse response) {
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
    public void add(String shelf_id, String method, List<String> unique_codes, String created_by, String updated_by) {
        StockInRequest request =new StockInRequest(shelf_id,method,unique_codes,created_by,updated_by);
        interacter.StockInMove(request,this);
    }

    @Override
    public void view(String shelf_id, String method) {
        StockInRequest request =new StockInRequest(shelf_id,method);
        interacter.StockInMove(request,this);
    }

    @Override
    public void move(String user_id, String method, List<String> unique_codes) {
        StockInRequest request =new StockInRequest(user_id,method,unique_codes);
        interacter.StockInMove(request,this);
    }
}
