package com.obpoo.gfsfabricsoftware.Report.MVP;

import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Report_request;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricNameRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.ItemSalesRe.ItemSalesReq;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentReceivedRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PurchaseOrderDetailsrequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 2/18/2019.
 */

public class ReportInteractorImpl implements ReportInteractor {
    @Override
    public void onCallRetroBuildInvoiceReport(String method, String from, String to, final  Build_Invoice_Response_Interface build_invoice_response_interface) {
            Retrofit retrofit = ApiClient.getRetrofit();
            WebApi apis = retrofit.create(WebApi.class);
            Bill_Invoice_Report_request request = new Bill_Invoice_Report_request(method,from,to);
            Call<Bill_Invoice_Response_data> call = apis.billINvoiceAPI(request);
            call.enqueue(new Callback<Bill_Invoice_Response_data>() {
                @Override
                public void onResponse(Call<Bill_Invoice_Response_data> call, Response<Bill_Invoice_Response_data> response) {
                    if (response.isSuccessful()) {
                        build_invoice_response_interface.onBuildInvoiceSuccess(response.body());

                    } else {
                        build_invoice_response_interface.onBuildInvoiceError("Please Try Again.");

                    }
                }

                @Override
                public void onFailure(Call<Bill_Invoice_Response_data> call, Throwable t) {
                    build_invoice_response_interface.onBuildInvoiceError(t.getMessage());

                }
            });
    }

    @Override
    public void onCallRetroCustomerPending(String method, String customer_id, final Customer_Pending_Response_Interface customer_pending_response_interface) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        CustomerPendingRequest request = new CustomerPendingRequest(method,customer_id);
        Call<CustomerPendingResponse> call = apis.customerPendAPI(request);
        call.enqueue(new Callback<CustomerPendingResponse>() {
            @Override
            public void onResponse(Call<CustomerPendingResponse> call, Response<CustomerPendingResponse> response) {
                if (response.isSuccessful()) {
                    customer_pending_response_interface.onCustomerPendingSuccess(response.body());

                } else {
                    customer_pending_response_interface.onCustomerPendingError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CustomerPendingResponse> call, Throwable t) {
                customer_pending_response_interface.onCustomerPendingError(t.getMessage());

            }
        });
    }

    @Override
    public void onCallRetorCutStock(String method, String from, String to, final CutStock_Response_Interface cutStock_response_interface) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Bill_Invoice_Report_request request = new Bill_Invoice_Report_request(method,from,to);
        Call<CutStockResponse> call = apis.cutStockAPI(request);
        call.enqueue(new Callback<CutStockResponse>() {
            @Override
            public void onResponse(Call<CutStockResponse> call, Response<CutStockResponse> response) {
                if (response.isSuccessful()) {
                    cutStock_response_interface.onCutStockSuccess(response.body());

                } else {
                    cutStock_response_interface.onCutStockError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CutStockResponse> call, Throwable t) {
                cutStock_response_interface.onCutStockError(t.getMessage());

            }
        });

    }

    @Override
    public void onCallRetroFabricAnalytics(String method, String from, String to, final FabricAnalytics_Interface fabricAnalytics_interface) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Bill_Invoice_Report_request request = new Bill_Invoice_Report_request(method,from,to);
        Call<FabricAnalyticsResponse> call = apis.fabricAnalyAPI(request);
        call.enqueue(new Callback<FabricAnalyticsResponse>() {
            @Override
            public void onResponse(Call<FabricAnalyticsResponse> call, Response<FabricAnalyticsResponse> response) {
                if (response.isSuccessful()) {
                    fabricAnalytics_interface.onFabricAnalySuccess(response.body());

                } else {
                    fabricAnalytics_interface.onFabricAnalyError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<FabricAnalyticsResponse> call, Throwable t) {
                fabricAnalytics_interface.onFabricAnalyError(t.getMessage());

            }
        });
    }

    @Override
    public void onCallFabricNames(String method, final FabricNames fabricNames) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricNameRequest request = new FabricNameRequest(method);
        Call<FabricHistoryResponse> call = apis.fabricNameAPI(request);
        call.enqueue(new Callback<FabricHistoryResponse>() {
            @Override
            public void onResponse(Call<FabricHistoryResponse> call, Response<FabricHistoryResponse> response) {
                if (response.isSuccessful()) {
                    fabricNames.onFabricNamesSuccess(response.body());

                } else {
                    fabricNames.onFabricNamesError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<FabricHistoryResponse> call, Throwable t) {
                fabricNames.onFabricNamesError(t.getMessage());

            }
        });

    }

    @Override
    public void onCallRetroFabricGraphHistore(String method, String fab_name, final FabricGraphHistory fabricGraphHistory) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricHistoryRequest request = new FabricHistoryRequest(method,fab_name);
        Call<FabricGraphResponse> call = apis.fabricHistoryAPI(request);
        call.enqueue(new Callback<FabricGraphResponse>() {
            @Override
            public void onResponse(Call<FabricGraphResponse> call, Response<FabricGraphResponse> response) {
                if (response.isSuccessful()) {
                    fabricGraphHistory.onFabricHistorySuccess(response.body());

                } else {
                    fabricGraphHistory.onFabricHistoryError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<FabricGraphResponse> call, Throwable t) {
                fabricGraphHistory.onFabricHistoryError(t.getMessage());

            }
        });

    }

    @Override
    public void onCallRetroPaymnetReceived(String method, String from, String to, final PaymentReceived paymentReceived) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PaymentReceivedRequest request = new PaymentReceivedRequest(method,from,to);
        Call<PaymentRecResponse> call = apis.paymentRecAPI(request);
        call.enqueue(new Callback<PaymentRecResponse>() {
            @Override
            public void onResponse(Call<PaymentRecResponse> call, Response<PaymentRecResponse> response) {
                if (response.isSuccessful()) {
                    paymentReceived.onPaymentReceivedSuccess(response.body());

                } else {
                    paymentReceived.onPaymentReceivedError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<PaymentRecResponse> call, Throwable t) {
                paymentReceived.onPaymentReceivedError(t.getMessage());

            }
        });

    }

    @Override
    public void onCallRetroPoDetails(String method, final PoDetails poDetails) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PurchaseOrderDetailsrequest request  = new PurchaseOrderDetailsrequest(method);
        Call<PoDetailsresponse> call = apis.podetApi(request);
        call.enqueue(new Callback<PoDetailsresponse>() {
            @Override
            public void onResponse(Call<PoDetailsresponse> call, Response<PoDetailsresponse> response) {
                if(response.isSuccessful()){
                poDetails.onPoDetailsSuccess(response.body());}
                else{
                    poDetails.onPoDetailsError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<PoDetailsresponse> call, Throwable t) {

                poDetails.onPoDetailsError(t.getMessage());
            }
        });





    }

    @Override
    public void onCallRetroPOFabricList(String method, String from, String to, final PO_FABRIC_LIST po_fabric_list) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Bill_Invoice_Report_request request  = new Bill_Invoice_Report_request(method,from,to);
        Call<PO_Fabric_Response> call = apis.poFabricListAPI(request);
        call.enqueue(new Callback<PO_Fabric_Response>() {
            @Override
            public void onResponse(Call<PO_Fabric_Response> call, Response<PO_Fabric_Response> response) {
                if(response.isSuccessful()){
                    po_fabric_list.onPOFabricListSuccess(response.body());}
                else{
                    po_fabric_list.onPOFabricListError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<PO_Fabric_Response> call, Throwable t) {

                po_fabric_list.onPOFabricListError(t.getMessage());
            }
        });
    }

    @Override
    public void onCallRetroPOLeftOver(String method, String from_date, String to_date, final PO_Left_Over po_left_over) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PaymentReceivedRequest request  = new PaymentReceivedRequest(method,from_date,to_date);
        Call<POleftOverResponse> call = apis.poleftoverAPI(request);
        call.enqueue(new Callback<POleftOverResponse>() {
            @Override
            public void onResponse(Call<POleftOverResponse> call, Response<POleftOverResponse> response) {
                if(response.isSuccessful()){
                    po_left_over.onPOleftOVerSuccess(response.body());}
                else{
                    po_left_over.onPoLeftOVerError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<POleftOverResponse> call, Throwable t) {

                po_left_over.onPoLeftOVerError(t.getMessage());
            }
        });

    }

    @Override
    public void onCallRetroCheckIN(String method, String from_date, String to_date, final PO_Check_IN po_check_in) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PaymentReceivedRequest request  = new PaymentReceivedRequest(method,from_date,to_date);
        Call<CheckInResponse> call = apis.pocheckINAPI(request);
        call.enqueue(new Callback<CheckInResponse>() {
            @Override
            public void onResponse(Call<CheckInResponse> call, Response<CheckInResponse> response) {
                if(response.isSuccessful()){
                    po_check_in.onCheckINSuccess(response.body());}
                else{
                    po_check_in.onCheckINError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CheckInResponse> call, Throwable t) {

                po_check_in.onCheckINError(t.getMessage());
            }
        });

    }

    @Override
    public void onCallRetroCheckOUT(String method, String from_date, String to_date, final PO_Check_OUT poCheckOUt) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PaymentReceivedRequest request  = new PaymentReceivedRequest(method,from_date,to_date);
        Call<CheckOutResponse> call = apis.pocheckIOUTAPI(request);
        call.enqueue(new Callback<CheckOutResponse>() {
            @Override
            public void onResponse(Call<CheckOutResponse> call, Response<CheckOutResponse> response) {
                if(response.isSuccessful()){
                    poCheckOUt.onCheckIOUTSuccess(response.body());}
                else{
                    poCheckOUt.onCheckOUTError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CheckOutResponse> call, Throwable t) {

                poCheckOUt.onCheckOUTError(t.getMessage());
            }
        });

    }

    @Override
    public void onCallRetroSoldFabric(String method, String from, String to, final Sold_Fabric sold_fabric) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Bill_Invoice_Report_request request  = new Bill_Invoice_Report_request(method,from,to);
        Call<SoldFabricsResponse> call = apis.soldFabricAPI(request);
        call.enqueue(new Callback<SoldFabricsResponse>() {
            @Override
            public void onResponse(Call<SoldFabricsResponse> call, Response<SoldFabricsResponse> response) {
                if(response.isSuccessful()){
                    sold_fabric.onSoldFabricSuccess(response.body());}
                else{
                    sold_fabric.onSoldfabricError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<SoldFabricsResponse> call, Throwable t) {

                sold_fabric.onSoldfabricError(t.getMessage());
            }
        });
    }

    @Override
    public void onCallItemSales(String status, String from, String method, String to, String page_no, final Item_SalesI item_salesI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ItemSalesReq request = new ItemSalesReq(status,from,method,to,page_no);
        Call<SoldFabricsResponse> call = apis.itemSalesApi(request);
        call.enqueue(new Callback<SoldFabricsResponse>() {
            @Override
            public void onResponse(Call<SoldFabricsResponse> call, Response<SoldFabricsResponse> response) {
                if(response.isSuccessful()){
                item_salesI.itemSalesSuccess(response.body());}
                else{
                    item_salesI.itemSalesError("Please Try again");
                }


            }

            @Override
            public void onFailure(Call<SoldFabricsResponse> call, Throwable t) {
                item_salesI.itemSalesError(t.getMessage());

            }
        });

    }
}
