package com.obpoo.gfsfabricsoftware.vendors.ui;

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

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.vendors.adapter.VendorsAdapter;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Vendors extends BaseActivity implements VendorsView {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<VendorsDetail> cartList=new ArrayList<>();
    private VendorsAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    VendorsPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vendors");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new VendorsPresenterImpl(this);
        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Vendors.this,AddVendor.class));
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
        ArrayList<VendorsDetail> temp = new ArrayList();
        for (VendorsDetail d : cartList) {
            if (d.getVendor().toLowerCase().contains(text.toLowerCase())||d.getVendorno().toLowerCase().contains(text.toLowerCase())||d.getEmail().toLowerCase().contains(text.toLowerCase())||d.getTelephone().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    @Override
    public void onResume() {
        super.onResume();
      /*  cartList.clear();
        mShimmerViewContainer.startShimmerAnimation();
        mAdapter.notifyDataSetChanged();*/
        showProgressBar();
        presenter.viewAll("view_all");


    }

    public void onPause(){
        super.onPause();
    }





    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(VendorsResponse response) {

        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();
            cartList.clear();
            cartList = response.getDetail();
            mAdapter = new VendorsAdapter(this, cartList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mShimmerViewContainer.setVisibility(View.GONE);
            mAdapter.notifyDataSetChanged();
        }else
        {
            closeProgressbar();
            showError(response.toString());
        }


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
