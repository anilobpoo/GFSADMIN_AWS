package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;

/**
 * Created by PHD on 2/12/2019.
 */

public class PasswareWareReq {
    String warehouse_to,id,method;

    public PasswareWareReq(String warehouse_to, String id, String method) {
        this.warehouse_to = warehouse_to;
        this.id = id;
        this.method = method;
    }
}
