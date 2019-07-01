package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.CustomerForFabAdp;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.CustomerSelForFabMod;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.salesorder.ui.AddfabricSoOrders;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class POCreateAddCustomerinAddFab extends BaseActivity implements CustomerSelForFabMod {
    @BindView(R.id.trackpo_cus_rv)
    RecyclerView customerforFab_rv;
    ArrayList<CustomersDetail> customerList = new ArrayList<>();
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocreate_add_customerin_add_fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Available fabric");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        customerList = PreferenceConnector.getArraylistofObjectForFab(AppConstants.selectcustomerforPOinaddfab,this);
        index = getIntent().getIntExtra(AppConstants.selctedindexofabric,0);

        CustomerForFabAdp adapter = new CustomerForFabAdp(customerList,POCreateAddCustomerinAddFab.this,this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        customerforFab_rv.setLayoutManager(lm);
        customerforFab_rv.setAdapter(adapter);


    }

    @Override
    public void onCustomerSelForFabMod(int position) {
        Log.i("onCustomerSelForFabMod",customerList.get(position).getCustomerName());


        Intent in = new Intent(POCreateAddCustomerinAddFab.this, AddfabricSoOrders.class);
        in.putExtra(AppConstants.selctedindexofabric,index);
        in.putExtra(AppConstants.selectedCusforPOaddinFab,customerList.get(position).getCustomerName());
        setResult(AppConstants.passcustomerforfabric,in);
        finish();

    }
}
