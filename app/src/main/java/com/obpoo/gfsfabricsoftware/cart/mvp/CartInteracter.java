package com.obpoo.gfsfabricsoftware.cart.mvp;


import com.obpoo.gfsfabricsoftware.cart.datamodels.CartRequest;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;

public interface CartInteracter {
    interface CartListener {
        void onSuccess(CartResponse response);

        void onError(String message);
    }

    void  viewList(CartRequest request, CartListener listener);




}
