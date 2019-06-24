package com.obpoo.gfsfabricsoftware.vendortype.mvp;


import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeRequest;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;

public class VendorTypePresenterImpl implements VendorTypePresenter, VendorTypeInteracter.VendorTypeListener {

    VendorTypeView view;
    VendorTypeInteracterImpl interacter;

    public VendorTypePresenterImpl(VendorTypeView view) {
        this.view = view;
        interacter = new VendorTypeInteracterImpl();
    }



    @Override
    public void onSuccess(VendorTypeResponse response) {
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

        VendorTypeRequest request =new VendorTypeRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String name) {
        VendorTypeRequest request =new VendorTypeRequest(methodname,name);
        interacter.viewList(request,this);
    }

    @Override
    public void delete(String methodname, String id, String del, String dells) {
        VendorTypeRequest request =new VendorTypeRequest(methodname,id,del,dells);
        interacter.viewList(request,this);
    }

    @Override
    public void edit(String methodname, String name, String id) {
        VendorTypeRequest request =new VendorTypeRequest(methodname,name,id);
        interacter.viewList(request,this);
    }
}
