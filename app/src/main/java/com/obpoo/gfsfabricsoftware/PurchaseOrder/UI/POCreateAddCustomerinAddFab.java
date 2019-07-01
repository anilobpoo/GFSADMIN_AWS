package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.CustomerForFabAdp;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.CustomerSelForFabMod;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPObyCusData;
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
    @BindView(R.id.etSearch)
    EditText etSearch;
    int index;
    CustomerForFabAdp adapter;
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
        Log.i("CustomerList",customerList.size()+"");
        index = getIntent().getIntExtra(AppConstants.selctedindexofabric,0);

        adapter= new CustomerForFabAdp(customerList,POCreateAddCustomerinAddFab.this,this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        customerforFab_rv.setLayoutManager(lm);
        customerforFab_rv.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    filter(s.toString());
                }
            }
        });

    }

    private void filter(String s) {
        ArrayList<CustomersDetail> temp = new ArrayList<>();

        for(CustomersDetail d : customerList){
            if(d.getCustomerName().toLowerCase().contains(s.toLowerCase())){
                temp.add(d);
            }
        }


        adapter.updateFilterData(temp);
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
