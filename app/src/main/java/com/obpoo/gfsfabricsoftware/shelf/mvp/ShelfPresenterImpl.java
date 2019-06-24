package com.obpoo.gfsfabricsoftware.shelf.mvp;

import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfRequest;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;

;

public class ShelfPresenterImpl implements ShelfPresenter, ShelfInteracter.ShelfListener {

    ShelfView view;
    ShelfInteracterImpl interacter;

    public ShelfPresenterImpl(ShelfView view) {
        this.view = view;
        interacter = new ShelfInteracterImpl();
    }



    @Override
    public void onSuccess(ShelfResponse response) {
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
    public void addShelf(String methodname, String warehouse_id, String Shelf_id, String Shelf_no, String no_of_shelf) {
        ShelfRequest request =new ShelfRequest(methodname,warehouse_id,Shelf_id,Shelf_no,no_of_shelf);
        interacter.viewShopList(request,this);
    }

    @Override
    public void viewShelf(String methodname, String Shelf_id) {
        ShelfRequest request =new ShelfRequest(methodname,Shelf_id);
        interacter.viewShopList(request,this);
    }


}
