package com.obpoo.gfsfabricsoftware.salesorder.mvp;


import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersRequest;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;

public class MyOrdersPresenterImpl implements MyOrdersPresenter, MyOrdersInteracter.MyOrdersListener,
        MyOrdersInteracter.AllORderSoI,MyOrdersInteracter.AllOrderSoStatusI {

    MyOrdersView view;
    MyOrdersInteracterImpl interacter;

    public MyOrdersPresenterImpl(MyOrdersView view) {
        this.view = view;
        interacter = new MyOrdersInteracterImpl();
    }



    @Override
    public void onSuccess(MyOrdersResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onLoad(response);
        }
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.hideDialog();
            view.showError(message);
        }
    }


    @Override
    public void view(String methodname,int page_no) {
        MyOrdersRequest request =new MyOrdersRequest(methodname,page_no);
        interacter.viewList(request,this);
    }

    @Override
    public void add(String methodname, String customer_id, String discount_type, String canceled_by, String order_by, String order_no, String advance,
                    String leftover, String order_total, String coupon_per, String coupon_discount_price, String group_id, String pg_assign_time,
                    String pg_delivery_time, String delivery_by, String discount, String pickup_time, String Dellivery_address, String pay_mode,
                    String credit_time, String delivery_type, String lattitude, String longitude) {
        MyOrdersRequest request =new MyOrdersRequest(methodname,customer_id,discount_type,canceled_by,order_by,order_no,advance,leftover,order_total,coupon_per,coupon_discount_price,group_id,pg_assign_time,pg_delivery_time,delivery_by,discount,pickup_time,Dellivery_address,pay_mode,credit_time,delivery_type,lattitude,longitude);
        interacter.viewList(request,this);

    }

    @Override
    public void update(String methodname, String advance, String leftover, String order_total, String coupon_per, String coupon_discount_price, String Dellivery_address, String pay_mode, String credit_time, String delivery_type, String lattitude, String longitude, String id,String complete_status) {
        MyOrdersRequest request =new MyOrdersRequest(methodname,advance,leftover,order_total,coupon_per,coupon_discount_price,Dellivery_address,pay_mode,credit_time,delivery_type,lattitude,longitude,id,complete_status);
        interacter.viewList(request,this);
    }



    @Override
    public void delete(String methodname, String id, String status) {
        MyOrdersRequest request =new MyOrdersRequest(methodname,id,status);
        interacter.viewList(request,this);
    }

    @Override
    public void onPassAllORderSo(String method, String page_no) {
        view.showDialog();
        interacter.allOrderCall(method,page_no,this);

    }

    @Override
    public void onPassAllSOorderdateFilter(String method, String from, String to, String page_no) {
        interacter.allOrderSoDateFilterCall(method,from,to,page_no,this);

    }

    @Override
    public void onPassAllOrderSoStatus(String method) {
        view.showDialog();
        interacter.allORderStatusCall(method,this);

    }

    @Override
    public void onPassAllOrderselectedStatus(String method, String status) {
        interacter.allOrderSoSelectedStatusI(method,status,this);

    }

    @Override
    public void onAllORdeSuccess(AllOrderRes response) {
        view.hideDialog();
        view.onAllSO(response);


    }

    @Override
    public void onAllORderError(String message) {

    }

    @Override
    public void onAllOrderStatusSuccess(AllOrderStatusRes response) {
        view.hideDialog();
        view.onAllSoStatus(response);

    }

    @Override
    public void onALlORderStatusSOError(String Message) {

    }
}
