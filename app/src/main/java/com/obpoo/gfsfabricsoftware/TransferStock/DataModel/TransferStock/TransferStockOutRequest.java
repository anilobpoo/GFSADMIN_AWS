package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

import java.util.ArrayList;

/**
 * Created by PHD on 3/1/2019.
 */

public class TransferStockOutRequest {
    String method;
    ArrayList<String> ids;

    public TransferStockOutRequest(String method, ArrayList<String> ids) {
        this.method = method;
        this.ids = ids;
    }
}
