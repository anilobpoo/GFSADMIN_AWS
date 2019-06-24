package com.obpoo.gfsfabricsoftware.vendors.mvp;

import com.obpoo.gfsfabricsoftware.utilities.BaseView;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;

public interface VendorsView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(CustomersResponse response);
    void onLoad(VendorsResponse response);
}
