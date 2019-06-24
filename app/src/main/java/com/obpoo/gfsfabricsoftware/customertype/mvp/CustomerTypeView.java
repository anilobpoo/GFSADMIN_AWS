package com.obpoo.gfsfabricsoftware.customertype.mvp;

import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface CustomerTypeView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(CustomerTypeResponse response);
}
