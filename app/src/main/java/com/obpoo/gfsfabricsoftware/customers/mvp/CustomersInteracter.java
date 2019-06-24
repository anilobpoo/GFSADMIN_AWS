package com.obpoo.gfsfabricsoftware.customers.mvp;


import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersRequest;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;

public interface CustomersInteracter {
    interface CustomersListener {
        void onSuccess(CustomersResponse response);

        void onError(String message);
    }

    void  viewList(CustomersRequest request, CustomersListener listener);




}
