package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 11/23/2018.
 */

public class poPresenterImpl implements poPresenter,poInteractor.ViewPoResponse,poInteractor.AddPOResponse,poInteractor.ViewConfirmPOResponse,poInteractor.TrackPOI,poInteractor.TrackPODetI {
    com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView poView;
    poInteractorImpl interactor;

    public poPresenterImpl(com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView poView) {
        this.poView = poView;
        interactor = new poInteractorImpl();
    }

    @Override
    public void OnViewPO(String method,String page_no) {
        if(poView!=null){
        poView.showDialog();
        interactor.callRetroViewPO(method,page_no,this);
        }
    }

    @Override
    public void OnAddPO(String method, String factory_id, String staff_id, String cc_email, String brand_name,
                        String created_by, String updated_by,  ArrayList<HashMap<String,String>> items) {
        if(poView!=null){
            if(cc_email.length()==0){
                poView.onValidationfail(1);
            }

            else {

                poView.showDialog();
                interactor.callRetroAddPO(method, factory_id, staff_id, cc_email, created_by, updated_by, items, this);
            } }
    }

    @Override
    public void OnConfirmPO(String method, String id, String status,String tag) {

            interactor.callConfirmPO(method,id,status,tag,this);



        if(poView!=null){
            poView.showDialog();
        }
    }

    @Override
    public void viewPOOrder(String method, String from_date, String to_date, String page_no) {
        if(poView!=null){
            poView.showDialog();
            interactor.callPoOrder(method,from_date,to_date,page_no,this);
        }
    }

    @Override
    public void viewPOPendingOrder(String method) {
        if(poView!=null){
            poView.showDialog();
            interactor.callPoPendingOrder(method,this);
        }
    }

    @Override
    public void onViewSuccess(com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO response) {
        if(poView!=null){

            poView.hideDialog();
            poView.onShowViewPO(response);
        }

    }

    @Override
    public void onConfirmPOSuccess(ConfirmPOResponse response) {
        if(poView!=null) {
            poView.hideDialog();
            poView.onConfirmPO(response);
        }
    }

    @Override
    public void onConfirmPOError(String message) {

    }

    @Override
    public void onViewError(String message) {

    }


    @Override
    public void onAddPoSuccess(AddPoPojo response) {
        if(poView!=null){
            poView.hideDialog();
            poView.onShowAddPO(response);
        }

    }

    @Override
    public void onAddError(String message) {

    }

    @Override
    public void onTrackPOSuccess(TrackPOByCusRes response) {
        poView.hideDialog();
        poView.onTrackPObyCustomer(response);

    }

    @Override
    public void onTrackPOError(String message) {

    }

    @Override
    public void onTrackPODetSuccess(TrackPODetRes response) {
        poView.hideDialog();
        poView.onTrackPOdetails(response);

    }

    @Override
    public void onTrackPODetError(String message) {

    }

    @Override
    public void onTrackPO(String user_id, String method) {
        poView.showDialog();
        interactor.callRetroTrackPO(user_id,method,this);

    }

    @Override
    public void onTrackPODet(String cid, String method) {
        poView.showDialog();
        interactor.callRetroTrackPODet(cid,method,this);

    }
}
