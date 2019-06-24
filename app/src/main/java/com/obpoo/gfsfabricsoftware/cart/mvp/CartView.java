package com.obpoo.gfsfabricsoftware.cart.mvp;


import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;


public interface CartView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(CartResponse response);
}
