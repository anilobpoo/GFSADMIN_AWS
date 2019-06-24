package com.obpoo.gfsfabricsoftware.zone.mvp;

import com.obpoo.gfsfabricsoftware.utilities.BaseView;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;

public interface ZoneView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(ZoneResponse response);
}
