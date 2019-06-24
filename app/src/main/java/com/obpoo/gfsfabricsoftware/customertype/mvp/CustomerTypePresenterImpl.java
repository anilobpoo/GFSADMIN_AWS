package com.obpoo.gfsfabricsoftware.customertype.mvp;


import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeRequest;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;

public class CustomerTypePresenterImpl implements CustomerTypePresenter, CustomerTypeInteracter.CustomerTypeListener {

    CustomerTypeView view;
    CustomerTypeInteracterImpl interacter;

    public CustomerTypePresenterImpl(CustomerTypeView view) {
        this.view = view;
        interacter = new CustomerTypeInteracterImpl();
    }



    @Override
    public void onSuccess(CustomerTypeResponse response) {
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


        CustomerTypeRequest request =new CustomerTypeRequest(methodname);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String customer_type) {
        CustomerTypeRequest request =new CustomerTypeRequest(methodname,customer_type);
        interacter.viewList(request,this);
    }

    @Override
    public void delete(String methodname, String id, String del, String dels) {
        CustomerTypeRequest request =new CustomerTypeRequest(methodname,id,del,dels);
        interacter.viewList(request,this);
    }

    @Override
    public void edit(String methodname, String customer_type, String id) {
        CustomerTypeRequest request =new CustomerTypeRequest(methodname,customer_type,id);
        interacter.viewList(request,this);
    }
}
