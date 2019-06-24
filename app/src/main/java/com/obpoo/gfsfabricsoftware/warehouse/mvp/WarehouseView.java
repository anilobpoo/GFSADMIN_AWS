package com.obpoo.gfsfabricsoftware.warehouse.mvp;

import com.obpoo.gfsfabricsoftware.utilities.BaseView;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;

public interface WarehouseView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(CustomersResponse response);
    void onLoad(WarehouseResponse response);
}
