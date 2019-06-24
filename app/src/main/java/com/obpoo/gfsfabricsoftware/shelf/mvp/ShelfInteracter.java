package com.obpoo.gfsfabricsoftware.shelf.mvp;


import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfRequest;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;

public interface ShelfInteracter {
    interface ShelfListener {
        void onSuccess(ShelfResponse response);

        void onError(String message);
    }

    void  viewShopList(ShelfRequest request, ShelfInteracter.ShelfListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
