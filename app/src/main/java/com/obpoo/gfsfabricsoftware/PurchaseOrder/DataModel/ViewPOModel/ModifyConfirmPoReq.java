package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class ModifyConfirmPoReq {

    String method,id,quantity;
    public ModifyConfirmPoReq(String method,String id,String quantity) {
        this.method = method;
        this.id = id;
        this.quantity = quantity;
    }
}
