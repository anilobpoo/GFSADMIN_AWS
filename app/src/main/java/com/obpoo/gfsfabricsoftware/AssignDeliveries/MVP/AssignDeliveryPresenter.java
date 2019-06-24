package com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP;

/**
 * Created by PHD on 1/3/2019.
 */

public interface AssignDeliveryPresenter {
    void onViewDeliveries(String method);
    void onViewAllPg(String method);
    void onAssignPg(String method,String pg_user_id,String oid);

}