package com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel;

/**
 * Created by PHD on 1/5/2019.
 */

public class AssignPgRequest {
    String method,pg_user_id,oid;

    public AssignPgRequest(String method, String pg_user_id, String oid) {
        this.method = method;
        this.pg_user_id = pg_user_id;
        this.oid = oid;
    }
}
