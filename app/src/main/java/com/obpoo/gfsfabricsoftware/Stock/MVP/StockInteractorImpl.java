package com.obpoo.gfsfabricsoftware.Stock.MVP;

import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLogRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveCustomerRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResReq;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabricSearchRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.RequestObjectCustomerAddReserve;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockShelvRequest;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockZoneRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 1/29/2019.
 */

public class StockInteractorImpl implements StockInteractor {
    @Override
    public void callRetroViewStock(String method, String filterId, String IdType, final ViewStockResponse ViewStockResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        ViewStockRequest request = new ViewStockRequest(method, filterId);
        Call<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse> call = apis.viewStockWAPI(request);
        switch (IdType) {
            case AppConstants.select_ware:
                ViewStockRequest requestW = new ViewStockRequest(method, filterId);
                call = apis.viewStockWAPI(requestW);
                break;
            case AppConstants.select_zone:
                ViewStockZoneRequest requestZ = new ViewStockZoneRequest(method, filterId);
                call = apis.viewStockZAPI(requestZ);
                break;

        }

        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse> call, Response<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse> response) {
                if (response.isSuccessful()) {
                    ViewStockResponse.onStockSuccess(response.body());

                } else {
                    ViewStockResponse.onStockError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse> call, Throwable t) {
                ViewStockResponse.onStockError(t.getMessage());

            }
        });
    }

    @Override
    public void callRetroViewNewStock(String method, String filterId, String page_no, final ViewNewStockResponse viewStockNewResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        ViewStockShelvRequest requestS = new ViewStockShelvRequest(method, filterId, page_no);

        Call<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse> call = apis.viewStockSAPI(requestS);

        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse>() {

            @Override
            public void onResponse(Call<ViewStockNewResponse> call, Response<ViewStockNewResponse> response) {
                if (response.isSuccessful()) {
                    viewStockNewResponse.onStockNewSuccess(response.body());

                } else {
                    viewStockNewResponse.onStockNewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse> call, Throwable t) {
                viewStockNewResponse.onStockNewError(t.getMessage());

            }
        });
    }


    @Override
    public void callRetroAL(String method, final ViewActivityLog ViewActivityLog) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ActivityLogRequest request = new ActivityLogRequest(method);
        Call<ActivityLogResponse> call = apis.viewALAPI(request);
        call.enqueue(new Callback<ActivityLogResponse>() {
            @Override
            public void onResponse(Call<ActivityLogResponse> call, Response<ActivityLogResponse> response) {
                if (response.isSuccessful()) {
                    ViewActivityLog.onALSuccess(response.body());

                } else {
                    ViewActivityLog.onALerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<ActivityLogResponse> call, Throwable t) {
                ViewActivityLog.onALerror(t.getMessage());

            }
        });
    }

    @Override
    public void callRetroFS(String method, String fab_name, final ViewFabricSearch viewFabricSearch) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricSearchRequest request = new FabricSearchRequest(method, fab_name);
        Call<FabSearchRes> call = apis.viewFSAPI(request);
        call.enqueue(new Callback<FabSearchRes>() {
            @Override
            public void onResponse(Call<FabSearchRes> call, Response<FabSearchRes> response) {
                if (response.isSuccessful()) {
                    viewFabricSearch.onFSsuccess(response.body());

                } else {
                    viewFabricSearch.onFSfailure("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<FabSearchRes> call, Throwable t) {
                viewFabricSearch.onFSfailure(t.getMessage());

            }
        });
    }

    @Override
    public void callRetroCR(String method, final CustomerReseeveI customerReseeveI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        CustomerResReq request = new CustomerResReq(method);
        Call<CustomerResResp> call = apis.customerResAPI(request);
        call.enqueue(new Callback<CustomerResResp>() {
            @Override
            public void onResponse(Call<CustomerResResp> call, Response<CustomerResResp> response) {
                if (response.isSuccessful()) {
                    customerReseeveI.onCRsuccess(response.body());

                } else {
                    customerReseeveI.onCRerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CustomerResResp> call, Throwable t) {
                customerReseeveI.onCRerror(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroAddReserve(String method, String search, final AddReserveI addReserveI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AddReserveRequest request = new AddReserveRequest(method, search);
        Call<AddReserveRes> call = apis.addReserveapi(request);
        call.enqueue(new Callback<AddReserveRes>() {
            @Override
            public void onResponse(Call<AddReserveRes> call, Response<AddReserveRes> response) {
                if (response.isSuccessful()) {
                    addReserveI.onAddResSuccess(response.body());

                } else {
                    addReserveI.onAdResError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AddReserveRes> call, Throwable t) {
                addReserveI.onAdResError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroCustomerAddReserve(String method, RequestObjectCustomerAddReserve alldata, final CustomerAddReserveI customerAddReserveI) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AddReserveCustomerRequest request = new AddReserveCustomerRequest(method, alldata);
        Call<AddCustomerReserveFinal> call = apis.addCustomerReserveapi(request);
        call.enqueue(new Callback<AddCustomerReserveFinal>() {
            @Override
            public void onResponse(Call<AddCustomerReserveFinal> call, Response<AddCustomerReserveFinal> response) {
                if (response.isSuccessful()) {
                    customerAddReserveI.onCustomerAddReserveSuccess(response.body());

                } else {
                    customerAddReserveI.onCustomerAddReserveError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AddCustomerReserveFinal> call, Throwable t) {
                customerAddReserveI.onCustomerAddReserveError(t.getMessage());

            }
        });

    }


}
