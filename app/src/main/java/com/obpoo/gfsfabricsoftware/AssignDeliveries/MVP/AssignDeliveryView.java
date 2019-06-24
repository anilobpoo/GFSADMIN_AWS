package com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 1/3/2019.
 */

public interface AssignDeliveryView extends BaseView{
    void onShowViewDeliveries(DeliveryData response);
    void onShowAllPGList(PGresponse response);
    void onShowAssignPg(AssignPgResponse response);
}
