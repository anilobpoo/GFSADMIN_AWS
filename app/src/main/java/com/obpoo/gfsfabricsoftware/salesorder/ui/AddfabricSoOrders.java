package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.MVP.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.AddFabSalesOrder;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddfabricSoOrders extends BaseActivity implements ViewStock {
    StockPresenterImpl  presenter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.rv_addfab_soorder)
    RecyclerView rv_addfab_soorder;
    @BindView(R.id.progress_so_fab_add)
    ProgressBar progress_so_fab_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfabric_so_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new StockPresenterImpl(this);

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
                    progress_so_fab_add.setVisibility(View.VISIBLE);
                    presenter.onViewAddReserve("get_fabric",s.toString());
                }

            }
        });

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
        progress_so_fab_add.setVisibility(View.GONE);
        if(response.getStatus().equals("success")){
            ArrayList<AddReserveDet> addReserveDetArrayList = response.getData();
            AddFabSalesOrder  adapter = new AddFabSalesOrder(addReserveDetArrayList,AddfabricSoOrders.this);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            rv_addfab_soorder.setLayoutManager(lm);
            rv_addfab_soorder.setAdapter(adapter);

        }

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }
}
