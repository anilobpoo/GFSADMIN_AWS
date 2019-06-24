package com.obpoo.gfsfabricsoftware.warehouse.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.warehouse.adapter.WarehouseAdapter;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehousePresenterImpl;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehouseView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Warehouse extends BaseActivity implements WarehouseView {
    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<WarehouseDetail> cartList=new ArrayList<>();
    private WarehouseAdapter mAdapter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    WarehousePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Warehouse");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new WarehousePresenterImpl(this);
        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Warehouse.this,AddWarehouse.class));
            }
        });
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



    }

    void filter(String text) {
        ArrayList<WarehouseDetail> temp = new ArrayList();
        for (WarehouseDetail d : cartList) {
            if (d.getWarehouse_name().toLowerCase().contains(text.toLowerCase())||d.getLocality().toLowerCase().contains(text.toLowerCase())||d.getAddress().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.viewAll("view_all");

    }

    public void onPause(){
        super.onPause();
    }



    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(WarehouseResponse response) {

        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();
            cartList.clear();
            cartList = response.getDetail();
            mAdapter = new WarehouseAdapter(this, cartList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mShimmerViewContainer.setVisibility(View.GONE);
            mAdapter.notifyDataSetChanged();
        }else
        {
            closeProgressbar();
            showError(response.getMessage().toString());
        }
    }

    @Override
    public void showDialog() {
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
