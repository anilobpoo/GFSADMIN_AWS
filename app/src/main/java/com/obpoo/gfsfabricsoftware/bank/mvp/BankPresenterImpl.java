package com.obpoo.gfsfabricsoftware.bank.mvp;


import com.obpoo.gfsfabricsoftware.bank.datamodels.BankRequest;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;

public class BankPresenterImpl implements BankPresenter, BankInteracter.BankListener {

    BankView view;
    BankInteracterImpl interacter;

    public BankPresenterImpl(BankView view) {
        this.view = view;
        interacter = new BankInteracterImpl();
    }



    @Override
    public void onSuccess(BankResponse response) {
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


        BankRequest request =new BankRequest(methodname);
        interacter.viewShopList(request,this);
    }

    @Override
    public void add(String methodname, String bankname,String add,String adds) {
        BankRequest request =new BankRequest(methodname,bankname,add,adds);
        interacter.viewShopList(request,this);
    }

    @Override
    public void update(String methodname, String bankname, String id) {
        BankRequest request =new BankRequest(methodname,bankname,id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void delete(String methodname, String id) {
        BankRequest request =new BankRequest(methodname,id);
        interacter.viewShopList(request,this);
    }
}
