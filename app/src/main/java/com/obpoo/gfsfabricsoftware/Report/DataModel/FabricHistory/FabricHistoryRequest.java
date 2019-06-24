package com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory;

/**
 * Created by PHD on 2/21/2019.
 */

public class FabricHistoryRequest {
    String method;
    String fab_name;

    public FabricHistoryRequest(String method, String fab_name) {
        this.method = method;
        this.fab_name = fab_name;
    }



}
