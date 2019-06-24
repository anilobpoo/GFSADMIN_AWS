package com.obpoo.gfsfabricsoftware.warehouse.datamodels;

public class WarehouseRequest {


    String method,id;
    String warehouse_name,warehouse_no,can_sell_part,locality,address,Available_status,shopNo;

    public WarehouseRequest(String method) {
        this.method = method;
    }
    public WarehouseRequest(String method,String id) {
        this.method = method;
        this.id=id;
    }
    public WarehouseRequest(String method,String warehouse_name,
                            String warehouse_no,String can_sell_part,String locality,String address,String Available_status,String shopNo) {
        this.method = method;
        this.warehouse_name = warehouse_name;
        this.warehouse_no = warehouse_no;
        this.can_sell_part = can_sell_part;
        this.locality = locality;
        this.address = address;
        this.Available_status = Available_status;
        this.shopNo = shopNo;

    }
    public WarehouseRequest(String method,String warehouse_name,
                            String warehouse_no,String can_sell_part,String locality,String address,String Available_status,String shopNo,String id) {
        this.method = method;
        this.warehouse_name = warehouse_name;
        this.warehouse_no = warehouse_no;
        this.can_sell_part = can_sell_part;
        this.locality = locality;
        this.address = address;
        this.Available_status = Available_status;
        this.shopNo = shopNo;
        this.id = id;

    }

}
