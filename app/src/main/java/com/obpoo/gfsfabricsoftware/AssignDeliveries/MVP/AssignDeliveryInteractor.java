package com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;

/**
 * Created by PHD on 1/3/2019.
 */

public interface AssignDeliveryInteractor {
    interface ViewDeliveryResponse{
        void onDeliverySuccess(DeliveryData response);
        void onDeliveryError(String message);
    }
    void callRetroDelivery(String method,ViewDeliveryResponse response);
    interface viewPgAll{
        void onPgAllSuccess(PGresponse response);
        void onPgError(String message);
    }
    void callRetroPgAll(String method,viewPgAll response);
    interface AssignPg{
        void onAssignPgSuccess(AssignPgResponse response);
        void onAssignPgError(String message);
    }
    void callRetroAssignPg(String method,String pg_user_id,String oid,AssignPg response);

}
