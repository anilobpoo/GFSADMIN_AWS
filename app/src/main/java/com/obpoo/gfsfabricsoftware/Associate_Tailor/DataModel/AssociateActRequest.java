package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

public class AssociateActRequest {
    String method,ts_id,activity,status;

    public AssociateActRequest(String method, String ts_id, String activity, String status) {
        this.method = method;
        this.ts_id = ts_id;
        this.activity = activity;
        this.status = status;
    }
}
