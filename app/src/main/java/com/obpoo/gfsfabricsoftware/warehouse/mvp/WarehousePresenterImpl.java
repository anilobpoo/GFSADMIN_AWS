package com.obpoo.gfsfabricsoftware.warehouse.mvp;


import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseRequest;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;

public class WarehousePresenterImpl implements WarehousePresenter, WarehouseInteracter.WarehouseListerner {

    WarehouseView view;
    WarehouseInteracterImpl interacter;

    public WarehousePresenterImpl(WarehouseView view) {
        this.view = view;
        interacter = new WarehouseInteracterImpl();
    }



    @Override
    public void onSuccess(WarehouseResponse response) {
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


        WarehouseRequest request =new WarehouseRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String method, String warehouse_name, String warehouse_no, String can_sell_part, String locality, String address, String Available_status, String shopNo) {
        WarehouseRequest request =new WarehouseRequest(method,warehouse_name,warehouse_no,can_sell_part,locality,address,Available_status,shopNo);
        interacter.viewList(request,this);
    }

    @Override
    public void edit(String method, String warehouse_name, String warehouse_no, String can_sell_part, String locality, String address, String Available_status, String shopNo, String id) {
        WarehouseRequest request =new WarehouseRequest(method,warehouse_name,warehouse_no,can_sell_part,locality,address,Available_status,shopNo,id);
        interacter.viewList(request,this);
    }

    @Override
    public void getone(String methodname, String id) {
        WarehouseRequest request =new WarehouseRequest(methodname,id);
        interacter.viewList(request,this);
    }


}
