package com.obpoo.gfsfabricsoftware.fabrictype.mvp;


import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeRequest;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;

public class FabricTypePresenterImpl implements FabricTypePresenter, FabricTypeInteracter.FabricTypeListener {

    FabricTypeView view;
    FabricTypepInteracterImpl interacter;

    public FabricTypePresenterImpl(FabricTypeView view) {
        this.view = view;
        interacter = new FabricTypepInteracterImpl();
    }



    @Override
    public void onSuccess(FabricTypeResponse response) {
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

        FabricTypeRequest request =new FabricTypeRequest(methodname);
        interacter.viewShopList(request,this);
    }

    @Override
    public void delete(String methodname, String id, String del, String dells) {
        FabricTypeRequest request =new FabricTypeRequest(methodname,id,del,dells);
        interacter.viewShopList(request,this);
    }

    @Override
    public void add(String methodname, String color_code) {
        FabricTypeRequest request =new FabricTypeRequest(methodname,color_code);
        interacter.viewShopList(request,this);
    }

    @Override
    public void update(String methodname, String fabric_type, String id) {
        FabricTypeRequest request =new FabricTypeRequest(methodname,fabric_type,id);
        interacter.viewShopList(request,this);

    }


}
