package com.obpoo.gfsfabricsoftware.vendors.mvp;


import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.ViewVendorsRequest;

public interface VendorsInteracter {
    interface VendorsListener {
        void onSuccess(VendorsResponse response);

        void onError(String message);
    }

    void  viewList(ViewVendorsRequest request, VendorsInteracter.VendorsListener listener);




}
