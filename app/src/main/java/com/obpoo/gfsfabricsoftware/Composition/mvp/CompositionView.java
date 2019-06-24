package com.obpoo.gfsfabricsoftware.Composition.mvp;

import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

public interface CompositionView extends BaseView {
    void onValidationFail(int type);

    void viewCompositionList(CompositionResponse response);


}
