package com.obpoo.gfsfabricsoftware.shop.ui;

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
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopDetail;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopPresenterImpl;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.shop.adapter.ShopAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Shops extends BaseActivity implements ShopView {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<ShopDetail> cartList=new ArrayList<>();
    private ShopAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    ShopPresenterImpl presenter;


    void filter(String text) {
        ArrayList<ShopDetail> temp = new ArrayList();
        for (ShopDetail d : cartList) {
            if (d.getName().toLowerCase().contains(text.toLowerCase())||d.getAddress().toLowerCase().contains(text.toLowerCase())||d.getLocation().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        presenter = new ShopPresenterImpl(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Shops");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();

        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Shops.this,AddShop.class));
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

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
        presenter.viewAll("view_all");
        showProgressBar();

    }

    public void onPause(){
        super.onPause();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ShopResponse response) {
        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();
            cartList.clear();
            cartList = response.getDetail();
            mAdapter = new ShopAdapter(this, cartList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mShimmerViewContainer.setVisibility(View.GONE);
            mShimmerViewContainer.stopShimmerAnimation();
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
        Toast.makeText(this,  message, Toast.LENGTH_SHORT).show();

    }

}
