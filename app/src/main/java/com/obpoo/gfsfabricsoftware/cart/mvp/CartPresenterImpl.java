package com.obpoo.gfsfabricsoftware.cart.mvp;

import com.obpoo.gfsfabricsoftware.cart.datamodels.CartRequest;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;

public class CartPresenterImpl implements CartPresenter, CartInteracter.CartListener {

    CartView view;
    CartInteracterImpl interacter;

    public CartPresenterImpl(CartView view) {
        this.view = view;
        interacter = new CartInteracterImpl();
    }



    @Override
    public void onSuccess(CartResponse response) {
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
    public void view(String methodname,String orderid) {
        CartRequest request =new CartRequest(methodname,orderid);
        interacter.viewList(request,this);
    }

    @Override
    public void delete(String method, String id, String del) {
        CartRequest request =new CartRequest(method,id,del);
        interacter.viewList(request,this);
    }

    @Override
    public void changestatus(String method, String id, String status, String changestatus) {
        CartRequest request =new CartRequest(method,id,status,changestatus);
        interacter.viewList(request,this);
    }

    @Override
    public void editItem(String method, String id, String quantity, String actual_price, String subtotal) {
        CartRequest request =new CartRequest(method,id,quantity,actual_price,subtotal);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String method, String orderid, String item_id, String quantity, String actual_price, String discount_for_user, String subtotal, String stock_id_qty, String qc_description) {
        CartRequest request =new CartRequest(method,orderid,item_id,quantity,actual_price,discount_for_user,subtotal,stock_id_qty,qc_description);
        interacter.viewList(request,this);
    }


}
