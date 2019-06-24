package com.obpoo.gfsfabricsoftware.collections.datamodel;

public class CollectionsDRequest {

    String to_date,from_date,method;
    String [] previledges;

    public CollectionsDRequest(String to_date, String from_date, String method, String[] previledges) {
        this.to_date = to_date;
        this.from_date = from_date;
        this.method = method;
        this.previledges = previledges;
    }
}
