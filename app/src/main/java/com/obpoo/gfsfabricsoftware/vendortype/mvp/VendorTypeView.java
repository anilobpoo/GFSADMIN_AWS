package com.obpoo.gfsfabricsoftware.vendortype.mvp;

import com.obpoo.gfsfabricsoftware.utilities.BaseView;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;

public interface VendorTypeView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(CustomerTypeResponse response);
    void onLoad(VendorTypeResponse response);
}
