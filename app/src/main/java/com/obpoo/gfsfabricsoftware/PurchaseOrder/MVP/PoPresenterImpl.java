package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;

import java.util.ArrayList;

/**
 * Created by PHD on 11/23/2018.
 */

public class PoPresenterImpl implements PoPresenter, PoInteractor.ViewPoResponse, PoInteractor.AddPOResponse,
        PoInteractor.ViewConfirmPOResponse, PoInteractor.TrackPOI, PoInteractor.TrackPODetI, PoInteractor.ModifyNotesI, PoInteractor.ViewPOFilter {
    PoView poView;
    PoInteractorImpl interactor;

    public PoPresenterImpl(PoView poView) {
        this.poView = poView;
        interactor = new PoInteractorImpl();
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
                        String created_by, String updated_by,  ArrayList<poItem> items,String notes) {
        if(poView!=null){
            if(cc_email.length()==0){
                poView.onValidationfail(1);
            }

            else {

                poView.showDialog();
                interactor.callRetroAddPO(method, factory_id, staff_id, cc_email, created_by, updated_by, items, this,notes);
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

    @Override
    public void onPassModifyNotes(String method, String notes, String id) {
        poView.showDialog();
        interactor.callModifyNotes(method,notes,id,this);

    }

    @Override
    public void onVIewFilter(String method) {
        poView.showDialog();
        interactor.callFilter(method,this);
    }

    @Override
    public void onVIewSelectFilter(String method, String status, String page_no) {
        poView.showDialog();
        interactor.callSelectFilter(method,status,page_no,this);
    }

    @Override
    public void onSearchPo(String method, String po_no, String page_no) {
        poView.showDialog();
        interactor.callSearchPo(method,po_no,page_no,this);
    }

    @Override
    public void onModifyNotesSuccess(ModifyNotes response) {
        poView.onModifyNotes(response);

    }

    @Override
    public void onModifyNotesError(String message) {

    }

    @Override
    public void onFilterPoSuccess(PoFilterResponse response) {
        poView.hideDialog();
        poView.onShowFilter(response);
    }

    @Override
    public void onFilterPoError(String message) {

    }
}
