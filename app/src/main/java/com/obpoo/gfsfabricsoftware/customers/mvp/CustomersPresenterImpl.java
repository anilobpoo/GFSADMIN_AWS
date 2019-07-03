package com.obpoo.gfsfabricsoftware.customers.mvp;


import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersRequest;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;

public class CustomersPresenterImpl implements CustomersPresenter, CustomersInteracter.CustomersListener {

    CustomersView view;
    CustomersInteracterImpl interacter;

    public CustomersPresenterImpl(CustomersView view) {
        this.view = view;
        interacter = new CustomersInteracterImpl();
    }



    @Override
    public void onSuccess(CustomersResponse response) {
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
    public void viewAll(String methodname,String userid) {
       view.showDialog();

        CustomersRequest request =new CustomersRequest(methodname,userid);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String user_id, String customer_name, String customer_type_id, String vat_name, String password, String shop_id, String customer_group, String address, String user_name, String country, String zipcode, String phone, String fax, String email) {
        CustomersRequest request =new CustomersRequest(methodname,user_id,customer_name,customer_type_id,vat_name,password,shop_id,customer_group,address,user_name,country,zipcode,phone,fax,email);
        interacter.viewList(request,this);
    }

    @Override
    public void del(String methodname, String id, String del) {
        CustomersRequest request =new CustomersRequest(methodname,id,del);
        interacter.viewList(request,this);
    }

    @Override
    public void upddate(String id, String methodname, String user_id, String customer_name, String customer_type_id, String vat_name, String password, String shop_id, String customer_group, String address, String user_name, String country, String zipcode, String phone, String fax, String email) {
        CustomersRequest request =new CustomersRequest(id,methodname,user_id,customer_name,customer_type_id,vat_name,password,shop_id,customer_group,address,user_name,country,zipcode,phone,fax,email);
        interacter.viewList(request,this);
    }

    @Override
    public void getone(String methodname, String id, String del,String getone) {
        CustomersRequest request =new CustomersRequest(methodname,id,del,getone);
        interacter.viewList(request,this);
    }


}
