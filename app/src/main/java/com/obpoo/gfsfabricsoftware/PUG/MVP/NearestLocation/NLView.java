package com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation;

import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 12/7/2018.
 */

public interface NLView extends BaseView {
    void onGetNLResponse(NLData response);
}
