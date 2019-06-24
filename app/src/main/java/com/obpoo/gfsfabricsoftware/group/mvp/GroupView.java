package com.obpoo.gfsfabricsoftware.group.mvp;

import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface GroupView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(GroupResponse response);
}
