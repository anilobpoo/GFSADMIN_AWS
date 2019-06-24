package com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels;

public class ShelfBarcodeRequest {


    String method;
    String scan_code;

    public ShelfBarcodeRequest(String method, String scan_code)
    {
        this.method=method;
        this.scan_code=scan_code;

    }


}
