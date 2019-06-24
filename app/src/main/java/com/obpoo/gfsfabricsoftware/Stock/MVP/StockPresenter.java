package com.obpoo.gfsfabricsoftware.Stock.MVP;

import com.obpoo.gfsfabricsoftware.Stock.DataModel.RequestObjectCustomerAddReserve;

/**
 * Created by PHD on 1/29/2019.
 */

public interface StockPresenter {
    void onViewStock(String method,String filterId, String IdType);
    void onViewNewStock(String method,String filterId,String page_no);
    void onViewActivityLog(String method);
    void onViewFabricSearch(String method,String fab_name);
    void onViewCustomerReserve(String method);
    void onViewAddReserve(String method,String search);
    void onViewCustomerAddReserve(String method, RequestObjectCustomerAddReserve alldata);

}
