package com.obpoo.gfsfabricsoftware.bundle.mvp;


import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface BundleView extends BaseView {
    void onValidationFail(int type);

    void onLoad(BundleResponse response);
}
