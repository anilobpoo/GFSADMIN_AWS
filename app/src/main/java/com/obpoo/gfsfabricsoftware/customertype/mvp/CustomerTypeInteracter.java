package com.obpoo.gfsfabricsoftware.customertype.mvp;


import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeRequest;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;

public interface CustomerTypeInteracter {
    interface CustomerTypeListener {
        void onSuccess(CustomerTypeResponse response);

        void onError(String message);
    }

    void  viewList(CustomerTypeRequest request, CustomerTypeListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
