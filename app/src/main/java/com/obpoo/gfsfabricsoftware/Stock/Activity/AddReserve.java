package com.obpoo.gfsfabricsoftware.Stock.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.AddReserveAdapterFabricAuto;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.MVP.*;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class AddReserve extends BaseActivity implements CustomersView, com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock{
    @BindView(R.id.cr_customer)
    Spinner cr_customer;
    @BindView(R.id.cr_fabric)
    AutoCompleteTextView cr_fabric;
    @BindView(R.id.ar_rv)
    RecyclerView ar_rv;
    CustomersPresenterImpl presenter;
    String admin_id,customer_id,customer_name;
    private ArrayList<CustomersDetail> customerList=new ArrayList<>();
    StockPresenterImpl stock_presenter;
    ArrayList<AddReserveDet> addReserveDetArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reserve);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Reserve");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new CustomersPresenterImpl(this);
        stock_presenter = new StockPresenterImpl(this);
        admin_id=  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        presenter.viewAll("view_all",admin_id);

        cr_fabric.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                stock_presenter.onViewAddReserve("get_fabric",s.toString());


            }
        });
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
        customerList = response.getDetail();
        ArrayAdapter<CustomersDetail> cus_adapter = new ArrayAdapter<CustomersDetail>(getApplicationContext(),R.layout.spinner_text,customerList);
        cus_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cr_customer.setAdapter(cus_adapter);
    }

    @OnItemSelected(R.id.cr_customer)
    public void onCustomerSelected(int position){
        customer_id = customerList.get(position).getId();
        customer_name=customerList.get(position).getCustomerName();


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

    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {
        Log.i("AddReserveFabricAuto",response.getMessage());
        addReserveDetArrayList=response.getData();
        AddReserveAdapterFabricAuto autofabARadp = new AddReserveAdapterFabricAuto(AddReserve.this,addReserveDetArrayList,customer_name,customer_id);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        ar_rv.setLayoutManager(lm);
        ar_rv.setAdapter(autofabARadp);
        autofabARadp.notifyDataSetChanged();
    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }
}
