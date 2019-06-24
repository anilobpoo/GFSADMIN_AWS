package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

public class FabricChangeRequest {
    String method,id,action,store_url;

    public FabricChangeRequest(String method, String id, String action, String store_url) {
        this.method = method;
        this.id = id;
        this.action = action;
        this.store_url = store_url;
    }
}
