package com.obpoo.gfsfabricsoftware.shelfassignment.datamodels;


import android.util.Log;

import java.util.List;

public class StockInRequest {


    String method;
    String shelf_id;
    List<String> unique_codes;
    String created_by;
    String updated_by;

    public StockInRequest(String shelf_id, String method, List<String>  unique_codes, String created_by, String updated_by) {
        this.shelf_id = shelf_id;
        this.unique_codes = unique_codes;
        Log.e("bundleArray",unique_codes.toString());
        this.created_by = created_by;
        this.method = method;
        this.updated_by = updated_by;

    }

    public StockInRequest(String shelf_id, String method, List<String> unique_codes) {
        this.shelf_id = shelf_id;
        this.unique_codes = unique_codes;
        this.method = method;

    }
    public StockInRequest(String shelf_id, String method) {
        this.shelf_id = shelf_id;
        this.method = method;

    }



}
