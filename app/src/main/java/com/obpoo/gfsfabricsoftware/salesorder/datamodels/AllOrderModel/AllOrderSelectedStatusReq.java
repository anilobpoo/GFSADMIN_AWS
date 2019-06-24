package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

public class AllOrderSelectedStatusReq {
    String method,status;

    public AllOrderSelectedStatusReq(String method, String status) {
        this.method = method;
        this.status = status;
    }
}
