package com.obpoo.gfsfabricsoftware.collections.datamodel;

public class DepositeRequest {
    String[] view_diposites;
    String method, time;

    public DepositeRequest(String method, String time, String[] view_diposites) {
        this.view_diposites = view_diposites;
        this.method = method;
        this.time = time;
    }
}
