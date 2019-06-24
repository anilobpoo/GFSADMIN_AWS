package com.obpoo.gfsfabricsoftware.fabrictype.datamodels;

public class FabricTypeRequest {


    String method;
    String id;
    String fabric_type;

    public FabricTypeRequest(String method) {
        this.method = method;
    }

    public FabricTypeRequest(String method,String fabric_type) {
        this.method = method;
        this.fabric_type = fabric_type;
    }
    public FabricTypeRequest(String method,String fabric_type,String id) {
        this.method = method;
        this.fabric_type = fabric_type;
        this.id = id;
    }
    public FabricTypeRequest(String method,String id,String del,String dells) {
        this.method = method;
        this.id = id;
    }
}
