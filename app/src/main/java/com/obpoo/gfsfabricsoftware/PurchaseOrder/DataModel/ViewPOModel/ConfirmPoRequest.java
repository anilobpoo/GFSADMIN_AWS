package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class ConfirmPoRequest {

    String method,id,status;
    public ConfirmPoRequest(String method,String id,String status) {
        this.method = method;
        this.id = id;
        this.status = status;
    }
}
