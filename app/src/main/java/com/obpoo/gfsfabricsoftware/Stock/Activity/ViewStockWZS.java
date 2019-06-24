package com.obpoo.gfsfabricsoftware.Stock.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.FSadapter;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.WzsStockAdp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchResDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.StockInDetails;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockDetails;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.MVP.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewStockWZS extends AppCompatActivity implements com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock {
    @BindView(R.id.recycler_view_wzs)
    RecyclerView recycler_view_wzs;
    ArrayList<ViewStockDetails> get_viewStockDetailsArrayList;
    ArrayList<FabSearchResDet> get_fabSearchResDetArrayList;
    ArrayList<StockInDetails> get_StockInDetails;
    //    WzsAdapter adapter;
    WzsStockAdp adapter;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String shelveUnqSC;
    StockPresenterImpl stock_presenter;
    int page_no = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stock_wzs);
        ButterKnife.bind(this);
        stock_presenter = new StockPresenterImpl(this);
        get_viewStockDetailsArrayList = new ArrayList<>();
        get_fabSearchResDetArrayList = new ArrayList<>();
        shelveUnqSC = getIntent().getStringExtra("shelveUnqSC");

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewStockWZS.this);

        recycler_view_wzs.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                    stock_presenter.onViewNewStock("view_by_shelf_pagn",shelveUnqSC, String.valueOf(page_no));
                }
            }

        });
        if (getIntent().getStringExtra("ViewStockDetailsKEY").equals("ViewStockDetailsWZS")) {
            if (getIntent().getStringExtra("ViewStockItmKEY").equals("shelve")) {
                get_StockInDetails = (ArrayList<StockInDetails>) getIntent().getSerializableExtra("ViewStockDetailsWZS");
                adapter = new WzsStockAdp(ViewStockWZS.this, get_StockInDetails);
                recycler_view_wzs.setLayoutManager(linearLayoutManager);
                recycler_view_wzs.setAdapter(adapter);
            }
//            if (getIntent().getStringExtra("ViewStockItmKEY").equals("warezone")){
//                get_viewStockDetailsArrayList=(ArrayList<ViewStockDetails>)getIntent().getSerializableExtra("ViewStockDetailsWZS");
//                adapter = new WzsAdapter(ViewStockWZS.this, get_viewStockDetailsArrayList,null,"wz");
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewStockWZS.this);
//                recycler_view_wzs.setLayoutManager(linearLayoutManager);
//                recycler_view_wzs.setAdapter(adapter);
//            }

        }

        if (getIntent().getStringExtra("ViewStockDetailsKEY").equals("ViewStockDetailsFS")) {
            get_fabSearchResDetArrayList = (ArrayList<FabSearchResDet>) getIntent().getSerializableExtra("ViewStockDetailsWZS");
            FSadapter fs_adapter = new FSadapter(get_fabSearchResDetArrayList, ViewStockWZS.this, AppConstants.ViewStockWZS);
            recycler_view_wzs.setLayoutManager(linearLayoutManager);
            recycler_view_wzs.setAdapter(fs_adapter);

        }

    }

    @Override
    public void onShowStock(ViewStockResponse response) {

    }

    @Override
    public void onShowNewStock(ViewStockNewResponse response) {
        ArrayList<StockInDetails> get_StockInDetails = new ArrayList<>();
        get_StockInDetails = response.getData();
        this.get_StockInDetails.addAll(get_StockInDetails);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onShowActivityLog(ActivityLogResponse response) {

    }

    @Override
    public void onShowFabSearch(FabSearchRes response) {

    }

    @Override
    public void onShowCustomerReserve(CustomerResResp response) {

    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }
}
