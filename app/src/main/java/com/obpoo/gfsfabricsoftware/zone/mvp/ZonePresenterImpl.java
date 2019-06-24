package com.obpoo.gfsfabricsoftware.zone.mvp;


import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneRequest;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;

public class ZonePresenterImpl implements ZonePresenter, ZoneInteracter.ZoneListener {

    ZoneView view;
    ZoneInteracterImpl interacter;

    public ZonePresenterImpl(ZoneView view) {
        this.view = view;
        interacter = new ZoneInteracterImpl();
    }



    @Override
    public void onSuccess(ZoneResponse response) {
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
    public void viewAll(String methodname, String warehouse_id) {
        ZoneRequest request =new ZoneRequest(methodname,warehouse_id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void add(String methodname, String warehouse_id, String no_of_zone) {
        ZoneRequest request =new ZoneRequest(methodname,warehouse_id,no_of_zone);
        interacter.viewShopList(request,this);
    }

    @Override
    public void addShelf(String methodname, String warehouse_id, String zone_id, String zone_no, String no_of_shelf) {
        ZoneRequest request =new ZoneRequest(methodname,warehouse_id,zone_id,zone_no,no_of_shelf);
        interacter.viewShopList(request,this);
    }

    @Override
    public void viewShelf(String methodname, String zone_id, String shelf, String shelfs) {
        ZoneRequest request =new ZoneRequest(methodname,zone_id,shelf,shelfs);
        interacter.viewShopList(request,this);
    }


}
