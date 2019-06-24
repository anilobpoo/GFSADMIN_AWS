package com.obpoo.gfsfabricsoftware.vendors.mvp;


import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.ViewVendorsRequest;

public class VendorsPresenterImpl implements VendorsPresenter, VendorsInteracter.VendorsListener {

    VendorsView view;
    VendorsInteracterImpl interacter;

    public VendorsPresenterImpl(VendorsView view) {
        this.view = view;
        interacter = new VendorsInteracterImpl();
    }



    @Override
    public void onSuccess(VendorsResponse response) {
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


        ViewVendorsRequest request =new ViewVendorsRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void getone(String methodname, String id) {
        ViewVendorsRequest request =new ViewVendorsRequest(methodname,id);
        interacter.viewList(request,this);
    }

    @Override
    public void delete(String methodname, String id, String del) {
        ViewVendorsRequest request =new ViewVendorsRequest(methodname,id,del);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String vendorno, String vendor, String vendortype, String address, String country, String zipcode, String telephone, String fax, String email) {
        ViewVendorsRequest request =new ViewVendorsRequest(methodname,vendorno,vendor,vendortype,address,country,zipcode,telephone,fax,email);
        interacter.viewList(request,this);
    }

    @Override
    public void update(String methodname, String vendorno, String vendor, String vendortype, String address, String country, String zipcode, String telephone, String fax, String email, String id) {
        ViewVendorsRequest request =new ViewVendorsRequest(methodname,vendorno,vendor,vendortype,address,country,zipcode,telephone,fax,email,id);
        interacter.viewList(request,this);
    }
}
