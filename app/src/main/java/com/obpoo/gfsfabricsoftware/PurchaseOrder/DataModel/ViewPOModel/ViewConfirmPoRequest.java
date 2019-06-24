package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class ViewConfirmPoRequest {

    String method,created_by;

    public ViewConfirmPoRequest(String method,String created_by) {
        this.method = method;
        this.created_by = created_by;
    }
}
