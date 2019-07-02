package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPORequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNoteReq;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyPOReq;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPORequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPoRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ModifyConfirmPoReq;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoOrderRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoPendingOrdRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoSelectFilterRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.SearchPoRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewConfirmPoRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewPgnRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 11/23/2018.
 */

public class PoInteractorImpl implements PoInteractor {
    @Override
    public void callRetroViewPO(String method, String page_no, final ViewPoResponse ViewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewPgnRequest request = new ViewPgnRequest(method, page_no);
        Call<poPOJO> call = apis.viewPOApi(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    ViewPoResponse.onViewSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    ViewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                ViewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });

    }

    @Override
    public void callPoOrder(String method, String from_date, String to_date, String page_no, final ViewPoResponse ViewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PoOrderRequest request = new PoOrderRequest(method, from_date, to_date, page_no);
        Call<poPOJO> call = apis.viewPoOrderAPI(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    ViewPoResponse.onViewSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    ViewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                ViewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callPoPendingOrder(String method, final ViewPoResponse ViewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PoPendingOrdRequest request = new PoPendingOrdRequest(method);
        Call<poPOJO> call = apis.viewPoPendingOrderAPI(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    ViewPoResponse.onViewSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    ViewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                ViewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callSelectFilter(String method, String status, String page_no, final ViewPoResponse viewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PoSelectFilterRequest request = new PoSelectFilterRequest(method,status,page_no);
        Call<poPOJO> call = apis.viewSelectFilterAPI(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    viewPoResponse.onViewSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    viewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                viewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callSearchPo(String method, String po_no, String page_no, final ViewPoResponse viewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        SearchPoRequest request = new SearchPoRequest(method,po_no,page_no);
        Call<poPOJO> call = apis.searchPoAPI(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    viewPoResponse.onViewSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    viewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                viewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callRetroViewConfirmPO(String method, String creatby, final ViewPoResponse viewPoResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewConfirmPoRequest request = new ViewConfirmPoRequest(method, creatby);
        Call<poPOJO> call = apis.viewConfirmPOApi(request);
        call.enqueue(new Callback<poPOJO>() {
            @Override
            public void onResponse(Call<poPOJO> call, Response<poPOJO> response) {
                if (response.isSuccessful()) {
                    viewPoResponse.onViewSuccess(response.body());

                } else {
                    viewPoResponse.onViewError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<poPOJO> call, Throwable t) {
                viewPoResponse.onViewError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callRetroAddPO(String method, String factory_id, String staff_id, String cc_email,
                               String created_by, String updated_by,ArrayList<poItem> items, final AddPOResponse AddPOResponse,String notes) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        AddPORequest request = new AddPORequest(method, factory_id, staff_id, cc_email, created_by, updated_by, items,notes);
        Call<AddPoPojo> call = apis.AddPO(request);
        call.enqueue(new Callback<AddPoPojo>() {
            @Override
            public void onResponse(Call<AddPoPojo> call, Response<AddPoPojo> response) {
                if (response.isSuccessful()) {
                    AddPOResponse.onAddPoSuccess(response.body());

                } else {
                    AddPOResponse.onAddError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AddPoPojo> call, Throwable t) {
                AddPOResponse.onAddError(t.getMessage());

            }
        });
    }

    @Override
    public void callConfirmPO(String method, String id, String status, String tag, final ViewConfirmPOResponse viewConfirmPOResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Call<ConfirmPOResponse> call = null;
        if (tag.equals("0")) {
            ConfirmPoRequest request = new ConfirmPoRequest(method, id, status);
            call = apis.ConfirmPO(request);

        }
        if (tag.equals("1")) {
            ModifyConfirmPoReq request = new ModifyConfirmPoReq(method, id, status);
            call = apis.ConfirmModifyPO(request);
        }
        call.enqueue(new Callback<ConfirmPOResponse>() {
            @Override
            public void onResponse(Call<ConfirmPOResponse> call, Response<ConfirmPOResponse> response) {
                if (response.isSuccessful()) {
                    viewConfirmPOResponse.onConfirmPOSuccess(response.body());

                } else {
                    viewConfirmPOResponse.onConfirmPOError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<ConfirmPOResponse> call, Throwable t) {
                viewConfirmPOResponse.onConfirmPOError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void callRetroTrackPO(String user_id, String method, final TrackPOI trackPOI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        TrackPORequest request = new TrackPORequest(user_id, method);
        Call<TrackPOByCusRes> call = apis.trackPOAPI(request);
        call.enqueue(new Callback<TrackPOByCusRes>() {
            @Override
            public void onResponse(Call<TrackPOByCusRes> call, Response<TrackPOByCusRes> response) {
                if (response.isSuccessful()) {
                    trackPOI.onTrackPOSuccess(response.body());

                } else {
                    trackPOI.onTrackPOError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TrackPOByCusRes> call, Throwable t) {
                trackPOI.onTrackPOError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroTrackPODet(String cid, String method, final TrackPODetI trackPODetI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        TrackPODetRequest request = new TrackPODetRequest(cid, method);
        Call<TrackPODetRes> call = apis.trackPODetApi(request);
        call.enqueue(new Callback<TrackPODetRes>() {
            @Override
            public void onResponse(Call<TrackPODetRes> call, Response<TrackPODetRes> response) {
                if (response.isSuccessful()) {
                    trackPODetI.onTrackPODetSuccess(response.body());

                } else {
                    trackPODetI.onTrackPODetError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TrackPODetRes> call, Throwable t) {
                trackPODetI.onTrackPODetError(t.getMessage());

            }
        });

    }

    @Override
    public void callModifyNotes(String method, String notes, String id, final ModifyNotesI modifyNotesI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        ModifyNoteReq request = new ModifyNoteReq( method,notes,id);
        Call<ModifyNotes> call = apis.modifyNotesApi(request);
        call.enqueue(new Callback<ModifyNotes>() {
            @Override
            public void onResponse(Call<ModifyNotes> call, Response<ModifyNotes> response) {
                if (response.isSuccessful()) {
                    modifyNotesI.onModifyNotesSuccess(response.body());

                } else {
                    modifyNotesI.onModifyNotesError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<ModifyNotes> call, Throwable t) {
                modifyNotesI.onModifyNotesError(t.getMessage());

            }
        });

    }

    @Override
    public void callFilter(String method, final ViewPOFilter viewPOFilter) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        PoFilterRequest request = new PoFilterRequest(method);
        Call<PoFilterResponse> call = apis.poFilterApi(request);
        call.enqueue(new Callback<PoFilterResponse>() {
            @Override
            public void onResponse(Call<PoFilterResponse> call, Response<PoFilterResponse> response) {
                if (response.isSuccessful()) {
                    viewPOFilter.onFilterPoSuccess(response.body());

                } else {
                    viewPOFilter.onFilterPoError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<PoFilterResponse> call, Throwable t) {
                viewPOFilter.onFilterPoError(t.getMessage());

            }
        });
    }

    @Override
    public void callRetroModifyPO(String method, String id, String po_no, String factory_id, String staff_id, String cc_email, String created_by, String updated_by, String notes, ArrayList<poItem> items, final ModifyPOI modifyPOI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);

        ModifyPOReq request = new ModifyPOReq(method,id,po_no,factory_id,staff_id,cc_email,created_by,updated_by,notes,items);
        Call<AddPoPojo> call = apis.modifyPOAPI(request);
        call.enqueue(new Callback<AddPoPojo>() {
            @Override
            public void onResponse(Call<AddPoPojo> call, Response<AddPoPojo> response) {
                if (response.isSuccessful()) {
                    modifyPOI.onModifyPOSuccess(response.body());

                } else {
                    modifyPOI.onModifyError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AddPoPojo> call, Throwable t) {
                modifyPOI.onModifyError(t.getMessage());

            }
        });
    }
}
