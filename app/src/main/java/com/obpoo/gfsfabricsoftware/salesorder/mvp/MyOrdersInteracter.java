package com.obpoo.gfsfabricsoftware.salesorder.mvp;


import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersRequest;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;


public interface MyOrdersInteracter {
    interface MyOrdersListener {
        void onSuccess(MyOrdersResponse response);

        void onError(String message);
    }

    void  viewList(MyOrdersRequest request, MyOrdersListener listener);

    interface AllORderSoI{
        void onAllORdeSuccess(AllOrderRes response);
        void onAllORderError(String message);
    }
    void allOrderCall(String method,String page_no,AllORderSoI response);
    void allOrderSoDateFilterCall(String method,String from,String to,String page_no,AllORderSoI response);
    void allOrderSoSelectedStatusI(String method,String status,AllORderSoI response);

    interface  AllOrderSoStatusI{
        void onAllOrderStatusSuccess(AllOrderStatusRes response);
        void onALlORderStatusSOError(String Message);
    }
    void allORderStatusCall(String method,AllOrderSoStatusI response);




}
