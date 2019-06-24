package com.obpoo.gfsfabricsoftware.shelfbarcode.mvp;


import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeRequest;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;

public interface ShelfBarcodeInteracter {
    interface ShelfBarocdeListener {
        void onSuccess(ShelfBarcodeResponse response);

        void onError(String message);
    }

    void  viewShopList(ShelfBarcodeRequest request, ShelfBarcodeInteracter.ShelfBarocdeListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
