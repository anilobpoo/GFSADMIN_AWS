package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.FilterDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorDetail;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.user.mvp.UserPresenterImpl;
import com.obpoo.gfsfabricsoftware.user.mvp.UserView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequestedOrder extends BaseActivity implements PoView, UserView, VendorsView, StockView, ColorView {
    @BindView(R.id.rv_po)
    RecyclerView rv_po;
    PoPresenterImpl presenter;
    @BindView(R.id.pbatshowPO)
    ProgressBar progressBar;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.search)
    ImageView search_icon;
    UserPresenterImpl presenter_user;
    ArrayList<UserDetail> userdetailList;
    VendorsPresenterImpl vendor_presenter;
    private ArrayList<VendorsDetail> cartList = new ArrayList<>();
    StockPresenterImpl article_presenter;
    ArrayList<StockDataResponse> stocklist = new ArrayList<>();
    ColorPresenterImpl color_presenter;
    private ArrayList<ColorDetail> colorlist = new ArrayList<>();
    ArrayList<poDatum> pOdataList = new ArrayList<>();
    ArrayList<FilterDatum> filterData = new ArrayList<>();
    poViewAdapter adapter;
    int page_no = 1;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    int setStatusTag=0;
     String get_cm_statusId;
    LinearLayoutManager lm;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==AppConstants.cm_filter_status){
            if(data!=null){
                setStatusTag =1;
                ArrayList<poDatum> selectData = data.getParcelableArrayListExtra(AppConstants.slected_status_cm);
                get_cm_statusId =data.getStringExtra("CMSTATUSID");
                adapter = new poViewAdapter(getApplicationContext(), selectData);
                final LinearLayoutManager lm1 = new LinearLayoutManager(RequestedOrder.this);

                rv_po.setLayoutManager(lm1);
                rv_po.setAdapter(adapter);
                adapter.notifyDataSetChanged();

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
                        currentItems = lm1.getChildCount();
                        totalItems = lm1.getItemCount();
                        scrollOutItems = lm1.findFirstVisibleItemPosition();

                        if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                            isScrolling = false;
                            page_no++;
                            presenter.onVIewSelectFilter("filter",get_cm_statusId,String.valueOf(page_no));
                        }
                    }

                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Manage/CreatePO");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        ButterKnife.bind(this);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RequestedOrder.this);

        presenter = new PoPresenterImpl(this);
        vendor_presenter = new VendorsPresenterImpl(this);
        article_presenter = new StockPresenterImpl(this);
        color_presenter = new ColorPresenterImpl(this);
        etSearch.setHint("Search By PO Number");
        presenter.OnViewPO("view_all_pagn", String.valueOf(page_no));
        // presenter for user......
        presenter_user = new UserPresenterImpl(this);

        adapter = new poViewAdapter(getApplicationContext(), pOdataList);

        lm  = new LinearLayoutManager(RequestedOrder.this);

        rv_po.setLayoutManager(lm);
        rv_po.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//        presenter_user.viewAll("view_all");
//        vendor_presenter.viewAll("view_all");
//        article_presenter.showResponse("viewall");
//        color_presenter.viewAll("view_all");

//        etSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (cartList != null) {
//                    filter(editable.toString());
//                }
//
//            }
//        });


    }


    @OnClick(R.id.search)
    public void searchClick() {
        presenter.onSearchPo("view_all_pagn_search", etSearch.getText().toString(), "1");
        pOdataList.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mcpo, menu);
        return true;
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

    @Override
    public void onModifyNotes(ModifyNotes response) {
    }

    @Override
    public void onShowFilter(PoFilterResponse response) {
        if (response.getStatus().equals("success")) {
            filterData = response.getData();
            Intent intent = new Intent(RequestedOrder.this, FilterView.class);
            intent.putExtra("data", filterData);
            startActivityForResult(intent, AppConstants.cm_filter_status);
        }
    }

    private void showInRecyclerView(poPOJO response) {
        ArrayList<poDatum> pOdummydataList = new ArrayList<>();
        if(response.getStatus().equals("success")){
        pOdummydataList = response.getData();
        pOdataList.addAll(pOdummydataList);
        adapter.notifyDataSetChanged();

       }


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
                currentItems = lm.getChildCount();
                totalItems = lm.getItemCount();
                scrollOutItems = lm.findFirstVisibleItemPosition();

                if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                    isScrolling = false;
                    page_no++;
                    if(setStatusTag==1){
                        presenter.onVIewSelectFilter("filter",get_cm_statusId,String.valueOf(page_no));
                    }
                    else{
                    presenter.OnViewPO("view_all_pagn", String.valueOf(page_no));}
                }
            }

        });
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ColorResponse response) {
        colorlist = response.getDetail();

    }

    @Override
    public void onLoad(VendorsResponse response) {
        cartList = response.getDetail();

    }

    @Override
    public void viewUserList(UserResponse response) {
        Log.i("UserPO", response.getMessage());
        userdetailList = response.getDetail();

    }

    @Override
    public void onGetResponse(String name, int drawable) {

    }

    @Override
    public void onShowStock(stockPOJO response) {
        stocklist = response.getData();

    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {

    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {

    }

    void filter(String text) {
        ArrayList<poDatum> temp = new ArrayList();
        for (poDatum d : pOdataList) {
            if (d.getPo_no().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        Log.i("TEMP", temp.size() + "");
        adapter.updateList(temp);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.so_filter:
                presenter.onVIewFilter("status_view");
                break;
            case R.id.so_date_filter:
                Intent in = new Intent(RequestedOrder.this, POAdd.class);
                in.putExtra("mediateVIA", "PO_class");
                in.putExtra("getItemList", "addItemList");
                startActivity(in);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
