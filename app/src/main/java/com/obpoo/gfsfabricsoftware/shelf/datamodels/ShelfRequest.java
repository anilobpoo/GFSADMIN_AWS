package com.obpoo.gfsfabricsoftware.shelf.datamodels;

public class ShelfRequest {


    String method;

    String id,warehouse_id,no_of_zone,zone_id,zone_no,no_of_shelf;


    public ShelfRequest(String method, String warehouse_id, String zone_id, String zone_no, String no_of_shelf) {
        this.method = method;
        this.warehouse_id = warehouse_id;
        this.zone_id = zone_id;
        this.zone_no = zone_no;
        this.no_of_shelf = no_of_shelf;
    }
    public ShelfRequest(String method, String zone_id) {
        this.method = method;
        this.zone_id = zone_id;
    }

}
