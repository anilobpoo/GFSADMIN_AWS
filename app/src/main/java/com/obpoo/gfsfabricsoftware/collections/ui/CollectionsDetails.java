package com.obpoo.gfsfabricsoftware.collections.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsPresenterImpl;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionsDetails extends AppCompatActivity implements CollectionsView {

    @BindView(R.id.col_deliveries)
    RelativeLayout col_deliveries;
    @BindView(R.id.deposite)
    RelativeLayout deposite;
    @BindView(R.id.trans_bg)
    ImageView trans_bg;
    @BindView(R.id.back_PO_cmngrp)
    ImageView back_PO_cmngrp;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    ArrayList<CollectionDatum> data;
    CollectionsPresenterImpl presenter;
    String fromdate, todate;
    String[] previledges = {"Sale Orders", "Purchase Order", "Transfer Stock", "Break Fabric", "Stock", "Master", "Report", "Returns & Deliveries", "Cutter Guy", "Collections", "Associate Tailors"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_view);
        ButterKnife.bind(this);
        presenter = new CollectionsPresenterImpl(this);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        fromdate = dateFormat.format(todate1);

    }

    @OnClick(R.id.col_deliveries)
    public void deliveriesClick() {
        presenter.view(todate, fromdate, "new_pg_collection", previledges);

    }

    @OnClick(R.id.back_PO_cmngrp)
    public void backClick() {
        finish();
    }

    @OnClick(R.id.deposite)
    public void depositeClick() {
        Intent intent = new Intent(CollectionsDetails.this, Deposit.class);
        startActivity(intent);
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CollectionsDResponse response) {
        if (response.getStatus().equals("success")) {
            data = response.getData();
            Intent intent = new Intent(CollectionsDetails.this, CollectionsDeliveries.class);
            intent.putExtra("date", data);
            startActivity(intent);
        }
    }

    @Override
    public void onInvoiceLoad(CollectionInvoiceResponse response) {

    }

    @Override
    public void onDepositeLoad(DepositeResponse response) {

    }

    @Override
    public void showDialog() {
        progressbar.setVisibility(View.VISIBLE);
        trans_bg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressbar.setVisibility(View.GONE);
        trans_bg.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }
}
