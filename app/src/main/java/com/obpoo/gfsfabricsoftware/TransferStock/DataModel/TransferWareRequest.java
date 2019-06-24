package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;

import java.util.ArrayList;

/**
 * Created by PHD on 2/11/2019.
 */

public class TransferWareRequest {
    String warehouse,method;
    ArrayList<String> all_id;

    public TransferWareRequest( ArrayList<String> all_id,String warehouse, String method) {
        this.warehouse = warehouse;
        this.method = method;
        this.all_id = all_id;
    }
}
