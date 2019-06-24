package com.obpoo.gfsfabricsoftware.bundle.mvp;


import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleRequest;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;

public interface BundleInteracter {
    interface BundleListener {
        void onSuccess(BundleResponse response);

        void onError(String message);
    }

    void  viewShopList(BundleRequest request, BundleInteracter.BundleListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
