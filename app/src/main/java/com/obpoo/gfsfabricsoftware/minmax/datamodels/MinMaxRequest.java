package com.obpoo.gfsfabricsoftware.minmax.datamodels;

public class MinMaxRequest {


    String method;
    String id,title;

    public MinMaxRequest(String method) {
        this.method = method;
    }
    public MinMaxRequest(String method,String title) {
        this.method = method;
        this.title = title;
    }
    public MinMaxRequest(String method,String title,String id) {
        this.method = method;
        this.title = title;
        this.id = id;
    }
    public  MinMaxRequest(String method,String id,String del,String dells) {
        this.method = method;
        this.id = id;
    }
}
