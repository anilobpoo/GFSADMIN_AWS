package com.obpoo.gfsfabricsoftware.customers.mvp;

import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface CustomersView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(CustomersResponse response);
}
