package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.customers.ui.AddCustomers;
import com.obpoo.gfsfabricsoftware.fabric.ui.OrderFabrics;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.MyOrdersAdapter;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AddFabricOrdersSO;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersDetail;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersPresenterImpl;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrders extends BaseActivity implements MyOrdersView,CustomersView {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private ArrayList<MyOrdersDetail> cartList=new ArrayList<>();
    private MyOrdersAdapter mAdapter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    MyOrdersPresenterImpl presenter;
    CustomersPresenterImpl customersPresenter;
    private ArrayList<CustomersDetail> customersDetails=new ArrayList<>();
    String admin_id;
    ArrayAdapter customerAdapter;
    ArrayList<String> customerList=new ArrayList<>();
    AutoCompleteTextView name;
    String autoname;
    String customer_id,discount,groupname,groupId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new MyOrdersPresenterImpl(this);
        customersPresenter = new CustomersPresenterImpl(this);

        admin_id=  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        presenter.view("viewall_pagn",1);
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

        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customer();
               /* Intent intent=new Intent(MyOrders.this, OrderFabrics.class);
                startActivity(intent);*/

            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
      //  showDialog();
        //presenter.view("viewall");
       // presenter.view("view_with_status");


    }

    public void onPause(){
        super.onPause();
    }


    void filter(String text) {
        ArrayList<MyOrdersDetail> temp = new ArrayList();
        for (MyOrdersDetail d : cartList) {
            if ((d.getOrderQr().toLowerCase().contains(text.toLowerCase()))||
                    (d.getStatusText().toLowerCase().contains(text.toLowerCase()))
                    ) {
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
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            customersDetails = response.getDetail();
            for (int i = 0; i < customersDetails.size(); i++) {
                {
                    customerList.add(customersDetails.get(i).getCustomerName());
                }
                name.setThreshold(1);
                name.setAdapter(customerAdapter);
            }
        }
    }

    @Override
    public void onLoad(MyOrdersResponse response) {
        Log.i("ReCheckPrevioudORders",response.getMessage());
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();


            if (response.getMessage().toLowerCase().contains("successfully"))
            {
                Intent intent=new Intent(this, OrderFabrics.class);
                intent.putExtra("id",response.getLast_id());
                intent.putExtra("discount",discount);
                startActivity(intent);
            }
            else
            {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new MyOrdersAdapter(this, cartList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                mShimmerViewContainer.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }


        }else
        {
            hideDialog();
            showError(response.getMessage().toString());
        }

    }

    @Override
    public void onAllSO(AllOrderRes response) {

    }

    @Override
    public void onAllSoStatus(AllOrderStatusRes response) {

    }

    @Override
    public void onAddFabricsSO(AddFabricOrdersSO response) {

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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
       // Log.i("orderErr",message);
    }


    public void customer()
    {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.alert_customer, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);
        name = (AutoCompleteTextView) promptsView.findViewById(R.id.name);
        final ImageView addCustomer = (ImageView) promptsView.findViewById(R.id.add);
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrders.this, AddCustomers.class));
            }
        });
        customerAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, customerList);
        autoname=name.getText().toString();
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getStoreID(name.getText().toString().trim());
            }
        });


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                presenter.add("take_order",customer_id,"","",admin_id,randomAlphaNumeric(10),"0","0","0","", "",groupId,"","","",discount,"","","","","","","");


                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        customersPresenter.viewAll("view_all",admin_id);

    }


    public int check(String id) {
        int j=0;
        for (int i = 0; i < customersDetails.size(); i++) {
            try {
                if (customersDetails.get(i).getCustomerName().equals(id))
                    j=i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return j;

    }

    private String getStoreID(String value){
        String id="";
        try {

            int pos=check(value);

            customer_id=customersDetails.get(pos).getId();
            groupId=customersDetails.get(pos).getCustomerGroup();
            groupname=customersDetails.get(pos).getCustomerGroupName();
            discount=customersDetails.get(pos).getDiscountPer();

            Log.e("customer_id",customer_id);
            Log.e("defaultId",groupId);
            Log.e("groupname",groupname);
            Log.e("discount",discount);


            name.setText(value);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private static final String ALPHA_NUMERIC_STRING = "123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
