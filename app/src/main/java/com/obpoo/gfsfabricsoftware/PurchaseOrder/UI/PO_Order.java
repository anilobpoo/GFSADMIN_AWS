package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PO_Order extends AppCompatActivity implements poView {


    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.back_PO_cmngrp)
    ImageView back;
    @BindView(R.id.received_ord)
    LinearLayout received_ord;
    @BindView(R.id.pending_ord)
    LinearLayout pending_ord;
    @BindView(R.id.received_img)
    ImageView received_img;
    @BindView(R.id.pending_img)
    ImageView pending_img;
    @BindView(R.id.received_text)
    TextView received_text;
    @BindView(R.id.pending_text)
    TextView pending_text;

    poPresenterImpl presenter;
    int page_no = 1;
    ConfirmPOAdapter adapter;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String fromdate,todate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po__order);
        ButterKnife.bind(this);
        presenter = new poPresenterImpl(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PO_Order.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);

        Date date = new Date();
        todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        fromdate = dateFormat.format(todate1);

        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));


        recycler_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = linearLayoutManager.getChildCount();
                totalItems = linearLayoutManager.getItemCount();
                scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                    isScrolling = false;
                    page_no++;
                    presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
                }
            }

        });
    }

    @OnClick(R.id.back_PO_cmngrp)
    public void backClick() {
        finish();
    }
 @OnClick(R.id.received_ord)
    public void receivedClick() {
     presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));

 }

    @Override
    public void onShowViewPO(poPOJO response) {
        if (response.getStatus().equals("success")) {
            ArrayList<poDatum> data = new ArrayList<>();
            data = response.getData();
            adapter = new ConfirmPOAdapter(getApplicationContext(), data, "poorder");
            recycler_view.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
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

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }
}
