package com.obpoo.gfsfabricsoftware.bundle.datamodels;

public class BundleRequest {

    String method,unique_id;
    public BundleRequest(String method, String unique_id) {
        this.method = method;
        this.unique_id = unique_id;
    }
}
