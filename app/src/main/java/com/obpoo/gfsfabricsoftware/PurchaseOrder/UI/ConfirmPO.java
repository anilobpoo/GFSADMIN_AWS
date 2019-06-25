package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ConfirmPOAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmPO extends AppCompatActivity implements poView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.tranparent_bg)
    ImageView tranparent_bg;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    ConfirmPOAdapter adapter;
    poPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_po);
        ButterKnife.bind(this);
        presenter = new poPresenterImpl(this);
        presenter.OnViewPO("view_unconfirmed", "1");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConfirmPO.this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @OnClick(R.id.back_PO_cmngrp)
    public void onClick() {
        Intent intent = new Intent(ConfirmPO.this,PO.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ConfirmPO.this,PO.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onShowViewPO(poPOJO response) {
        ArrayList<poDatum> data = new ArrayList<>();
        data = response.getData();
        adapter = new ConfirmPOAdapter(getApplicationContext(), data);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConfirmPO.this);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @Override
    public void showDialog() {
        tranparent_bg.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        tranparent_bg.setVisibility(View.GONE);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }
}
