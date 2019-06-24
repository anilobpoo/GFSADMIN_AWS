package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

public class TrackPORequest {
    String user_id,method;

    public TrackPORequest(String user_id, String method) {
        this.user_id = user_id;
        this.method = method;
    }
}
