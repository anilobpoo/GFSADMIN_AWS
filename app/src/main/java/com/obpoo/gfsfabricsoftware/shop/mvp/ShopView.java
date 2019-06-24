package com.obpoo.gfsfabricsoftware.shop.mvp;

import com.obpoo.gfsfabricsoftware.utilities.BaseView;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;

public interface ShopView extends BaseView {
    void onValidationFail(int type);


    void onLoad(ShopResponse response);
}
