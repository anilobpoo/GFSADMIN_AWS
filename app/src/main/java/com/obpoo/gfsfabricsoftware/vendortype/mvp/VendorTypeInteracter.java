package com.obpoo.gfsfabricsoftware.vendortype.mvp;


import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeRequest;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;

public interface VendorTypeInteracter {
    interface VendorTypeListener {
        void onSuccess(VendorTypeResponse response);

        void onError(String message);
    }

    void  viewList(VendorTypeRequest request, VendorTypeInteracter.VendorTypeListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
