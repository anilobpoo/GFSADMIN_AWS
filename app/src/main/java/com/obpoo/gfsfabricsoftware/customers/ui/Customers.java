package com.obpoo.gfsfabricsoftware.customers.ui;

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
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;

import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.customers.adapter.CustomerAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Customers extends BaseActivity implements CustomersView{

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<CustomersDetail> cartList=new ArrayList<>();
    private CustomerAdapter mAdapter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    CustomersPresenterImpl presenter;
    String admin_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Customers");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new CustomersPresenterImpl(this);
        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Customers.this,AddCustomers.class));
            }
        });
        admin_id=  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
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
        showProgressBar();
        presenter.viewAll("view_all",admin_id);


    }

    public void onPause(){
        super.onPause();
    }

    void filter(String text) {
        ArrayList<CustomersDetail> temp = new ArrayList();
        for (CustomersDetail d : cartList) {
            if (d.getCustomerName().toLowerCase().contains(text.toLowerCase())||d.getEmail().toLowerCase().contains(text.toLowerCase())||d.getPhone().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }


    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomersResponse response) {

        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();
            cartList.clear();
            cartList = response.getDetail();
            mAdapter = new CustomerAdapter(this, cartList);
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
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {

    }
}
