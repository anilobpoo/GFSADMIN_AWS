package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

/**
 * Created by PHD on 2/28/2019.
 */

public class TransferStockRequest {
  private   String method,from_date,to_date,page_no,document;

    public TransferStockRequest(String method, String from_date, String to_date, String page_no, String document) {
        this.method = method;
        this.from_date = from_date;
        this.to_date = to_date;
        this.page_no = page_no;
        this.document = document;
    }
}
