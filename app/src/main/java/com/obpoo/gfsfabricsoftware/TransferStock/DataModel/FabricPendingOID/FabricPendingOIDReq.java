package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID;

/**
 * Created by PHD on 2/7/2019.
 */

public class FabricPendingOIDReq {
    String method,id;

    public FabricPendingOIDReq(String method, String id) {
        this.method = method;
        this.id = id;
    }
}
