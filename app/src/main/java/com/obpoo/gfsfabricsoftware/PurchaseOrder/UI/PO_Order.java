package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ConfirmPOAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PO_Order extends BaseActivity implements PoView {


    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

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
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.tranparent_bg)
    ImageView transparent_bg;

    PoPresenterImpl presenter;
    int page_no = 1;
    ConfirmPOAdapter adapter;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String fromdate, todate;
    ArrayList<poDatum> data = new ArrayList<>();
    ArrayList<poDatum> data1 = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po__order);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Received Order");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new PoPresenterImpl(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PO_Order.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        fromdate = dateFormat.format(todate1);

        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));


    }


    @OnClick(R.id.received_ord)
    public void receivedClick() {
        toolbar.setTitle("Received Order");
        data.clear();
        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
        received_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue_100), android.graphics.PorterDuff.Mode.SRC_IN);
        received_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue_100));
        pending_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.iron), android.graphics.PorterDuff.Mode.SRC_IN);
        pending_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.iron));
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
                final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PO_Order.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
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

    @OnClick(R.id.pending_ord)
    public void pendingClick() {
        toolbar.setTitle("Pending Order");
        data.clear();
        presenter.viewPOPendingOrder("pending_orders");
        pending_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue_100), android.graphics.PorterDuff.Mode.SRC_IN);
        pending_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue_100));
        received_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.iron), android.graphics.PorterDuff.Mode.SRC_IN);
        received_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.iron));

    }

    @Override
    public void onShowViewPO(poPOJO response) {

        if (response.getStatus().equals("success")) {
            data1 = response.getData();
            data.addAll(data1);
            adapter = new ConfirmPOAdapter(PO_Order.this, data, "poorder");
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
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void onShowFilter(PoFilterResponse response) {

    }

    @Override
    public void showDialog() {
        progressbar.setVisibility(View.VISIBLE);
        transparent_bg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressbar.setVisibility(View.GONE);
        transparent_bg.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }
}
