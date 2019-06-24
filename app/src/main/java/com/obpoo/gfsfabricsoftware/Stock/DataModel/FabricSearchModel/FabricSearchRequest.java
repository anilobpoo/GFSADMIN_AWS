package com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel;

/**
 * Created by PHD on 2/4/2019.
 */

public class FabricSearchRequest {
    String method,fab_name;

    public FabricSearchRequest(String method, String fab_name) {
        this.method = method;
        this.fab_name = fab_name;
    }
}
