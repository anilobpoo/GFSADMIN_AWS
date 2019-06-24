package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockView;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.poViewAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorDetail;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.user.mvp.UserPresenterImpl;
import com.obpoo.gfsfabricsoftware.user.mvp.UserView;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestedOrder extends AppCompatActivity implements poView,UserView,VendorsView,StockView,ColorView {
    @BindView(R.id.rv_po)
    RecyclerView rv_po;
    poPresenterImpl presenter;
    @BindView(R.id.pbatshowPO)
    ProgressBar progressBar;
    @BindView(R.id.etSearch)
    EditText etSearch;
    UserPresenterImpl presenter_user;
    ArrayList<UserDetail> userdetailList;
    VendorsPresenterImpl vendor_presenter;
    private ArrayList<VendorsDetail> cartList=new ArrayList<>();
    StockPresenterImpl article_presenter;
    ArrayList<StockDataResponse> stocklist = new ArrayList<>();
    ColorPresenterImpl color_presenter;
    private ArrayList<ColorDetail> colorlist=new ArrayList<>();
    ArrayList<poDatum> pOdataList;
    poViewAdapter adapter;
    int page_no = 1;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        ImageView back = (ImageView)toolbar.findViewById(R.id.back_PO_cmngrp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RequestedOrder.this);

        ImageView addPO = (ImageView)toolbar.findViewById(R.id.add_stock_cmngrp);
        addPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RequestedOrder.this,POAdd.class);
//                in.putExtra("userSpinner",userdetailList);
//                in.putExtra("vendorSpinner",cartList);
//                in.putExtra("articleSpinner",stocklist);
//                in.putExtra("colorSpinner",colorlist);
                in.putExtra("mediateVIA","PO_class");
                in.putExtra("getItemList","addItemList");

                startActivity(in);
            }
        });
        ButterKnife.bind(this);
        presenter = new poPresenterImpl(this);
        vendor_presenter= new VendorsPresenterImpl(this);
        article_presenter= new StockPresenterImpl(this);
        color_presenter=new ColorPresenterImpl(this);
        presenter.OnViewPO("view_all_pagn", String.valueOf(page_no));
        // presenter for user......
        presenter_user = new UserPresenterImpl(this);
        presenter_user.viewAll("view_all");
        vendor_presenter.viewAll("view_all");
        article_presenter.showResponse("viewall");
        color_presenter.viewAll("view_all");

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cartList != null) {
                    filter(editable.toString());
                }

            }
        });

        rv_po.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                    presenter.OnViewPO("view_all_pagn", String.valueOf(page_no));
                }
            }

        });
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onShowViewPO(poPOJO response) {
        Log.i("POView", response.getMessage());
        showInRecyclerView(response);
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

    private void showInRecyclerView(poPOJO response) {
       pOdataList  = response.getData();

         adapter  = new poViewAdapter(getApplicationContext(), pOdataList);
        final LinearLayoutManager lm = new LinearLayoutManager(RequestedOrder.this);

        rv_po.setLayoutManager(lm);
        rv_po.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ColorResponse response) {
        colorlist=response.getDetail();

    }

    @Override
    public void onLoad(VendorsResponse response) {
        cartList=response.getDetail();

    }

    @Override
    public void viewUserList(UserResponse response) {
        Log.i("UserPO",response.getMessage());
        userdetailList=response.getDetail();

    }

    @Override
    public void onGetResponse(String name, int drawable) {

    }

    @Override
    public void onShowStock(stockPOJO response) {
        stocklist=response.getData();

    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {

    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {

    }
    void filter(String text) {
        ArrayList<poDatum> temp = new ArrayList();
        for (poDatum d : pOdataList ) {
            if (d.getStatusText().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        Log.i("TEMP",temp.size()+"");
         adapter.updateList(temp);

    }

}
