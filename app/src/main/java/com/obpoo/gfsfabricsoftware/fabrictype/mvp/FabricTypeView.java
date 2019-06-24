package com.obpoo.gfsfabricsoftware.fabrictype.mvp;

import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface FabricTypeView extends BaseView {
    void onValidationFail(int type);

    void onLoad(FabricTypeResponse response);
}
