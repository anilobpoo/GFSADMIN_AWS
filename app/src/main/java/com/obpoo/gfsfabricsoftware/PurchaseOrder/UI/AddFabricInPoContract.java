package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.FabricItemsAdapter;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFabricInPoContract extends BaseActivity implements CustomersView {
    @BindView(R.id.recyclerView_addFabricInPO)
    RecyclerView recyclerView;
    FabricItemsAdapter adapter;
    CustomersPresenterImpl presenter;
    String admin_id;
     ArrayList<CustomersDetail> cartList=new ArrayList<>();
    ArrayList<FabricsDetail> getFabricList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fabric_in_po_contract);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Select Item");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        Intent in = getIntent();
        getFabricList= ( ArrayList<FabricsDetail>)in.getSerializableExtra("FabricListItems");
        presenter = new CustomersPresenterImpl(this);
        admin_id =  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        presenter.viewAll("view_all",admin_id);
//        Log.i("FabImage",getFabricList.get(0).getFab_img());

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

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomersResponse response) {
        cartList=response.getDetail();
        Log.i("customerList",cartList.get(0).getCustomerName());
        adapter  = new FabricItemsAdapter(AddFabricInPoContract.this, getFabricList,cartList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddFabricInPoContract.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
