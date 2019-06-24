package com.obpoo.gfsfabricsoftware.Stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.CustomerReserveAdapter;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResVRespoDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.MVP.*;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerReserve extends BaseActivity implements com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock {
    @BindView(R.id.cusres_rv)
    RecyclerView cusres_rv;
    StockPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reserve);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Customer Reserve");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new StockPresenterImpl(this);
        presenter.onViewCustomerReserve("view_all");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public void onShowStock(ViewStockResponse response) {

    }

    @Override
    public void onShowNewStock(ViewStockNewResponse response) {

    }

    @Override
    public void onShowActivityLog(ActivityLogResponse response) {

    }

    @Override
    public void onShowFabSearch(FabSearchRes response) {

    }

    @Override
    public void onShowCustomerReserve(CustomerResResp response) {
        Log.i("CustomerReserve",response.getMessage());
        ArrayList<CustomerResVRespoDet> customerResVRespoDetArrayList = response.getData();

        CustomerReserveAdapter adapter = new CustomerReserveAdapter(customerResVRespoDetArrayList,CustomerReserve.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        cusres_rv.setLayoutManager(lm);
        cusres_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_addItem){
            Intent in = new Intent(CustomerReserve.this,AddReserve.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
