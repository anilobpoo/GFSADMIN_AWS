package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPObyCusData;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.ui.activities.HomeActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PO extends BaseActivity implements PoView {

    @BindView(R.id.request_order)
    RelativeLayout request_order;
    @BindView(R.id.confirm_po)
    RelativeLayout confirm_po;
    @BindView(R.id.po_order)
    RelativeLayout po_order;
    @BindView(R.id.track_po)
    RelativeLayout track_po;
    @BindView(R.id.progress_trackPO)
    ProgressBar progress_trackPO;
    PoPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Purchase Order");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new PoPresenterImpl(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PO.this, HomeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.request_order)
    public void onClick() {
        startActivity(new Intent(PO.this, RequestedOrder.class));
    }

    @OnClick(R.id.confirm_po)
    public void onClickConfirmPo() {
        startActivity(new Intent(PO.this, ConfirmPO.class));
    }

    @OnClick(R.id.po_order)
    public void onClickpo_order() {
        startActivity(new Intent(PO.this, PO_Order.class));
    }

    @OnClick(R.id.track_po)
    public void onTrackPO() {
        String user_id = PreferenceConnector.readString(PO.this, getString(R.string.admin_id), "");
        presenter.onTrackPO(user_id, "view_all");

    }

    @Override
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {
        if (response.getStatus().equals("success")) {
            ArrayList<TrackPObyCusData> trackPObyCusDataArrayList = response.getData();
            PreferenceConnector.saveArraylistofObjects(trackPObyCusDataArrayList, AppConstants.trackPObyCus, PO.this);

            Intent in = new Intent(PO.this, TrackPO.class);
            in.putExtra("POSOTAG","POVAL");
            startActivity(in);
        }
    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @Override
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void onShowFilter(PoFilterResponse response) {

    }

    @Override
    public void showDialog() {
        progress_trackPO.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progress_trackPO.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }
}
