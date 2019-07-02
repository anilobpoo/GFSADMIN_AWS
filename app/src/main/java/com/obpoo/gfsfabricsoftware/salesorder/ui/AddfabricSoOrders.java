package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddFabCMI;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.POAdd;
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
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.AddFabOrderBelowADP;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.AddFabSalesOrder;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.FabricAddOrderSO;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddfabricSoOrders extends AppCompatActivity implements ViewStock, FabricAddOrderSO, CustomersView {
    StockPresenterImpl  presenter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.rv_addfab_soorder)
    RecyclerView rv_addfab_soorder;
    @BindView(R.id.progress_so_fab_add)
    ProgressBar progress_so_fab_add;
    @BindView(R.id.rv_addselectedfab_soorder)
    RecyclerView rv_addselectedfab_soorder;
    String getOrderType;

    ArrayList<AddReserveDet> addbelowDetArrayList;
    CustomersPresenterImpl presenter_cus;
    ArrayList<CustomersDetail> customerList=new ArrayList<>();
    ArrayList<poItem> poItemArrayList_adp = new ArrayList<>();
    private Menu menu;
    AddFabSalesOrder  adapter;
    ArrayList<AddReserveDet> addReserveDetArrayList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppConstants.passcustomerforfabric){
            if(data!=null){
                int index = data.getIntExtra(AppConstants.selctedindexofabric,0);
                String getCustomer = data.getStringExtra(AppConstants.selectedCusforPOaddinFab);
                addReserveDetArrayList.get(index).setCustomer(getCustomer);
                adapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfabric_so_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Available fabric");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));

        getOrderType=getIntent().getStringExtra("ORDERTYPE_SOORDER");

        presenter = new StockPresenterImpl(this);
        addReserveDetArrayList= new ArrayList<>();
        addbelowDetArrayList = new ArrayList<>();

        presenter_cus = new CustomersPresenterImpl(this);
        String admin_id =  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        presenter_cus.viewAll("view_all",admin_id);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu=menu;
        getMenuInflater().inflate(R.menu.addfab,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent in = new Intent(AddfabricSoOrders.this, POAdd.class);
                in.putParcelableArrayListExtra(AppConstants.fabcmselList,poItemArrayList_adp);
                setResult(AppConstants.addcmFab,in);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
            addReserveDetArrayList  = response.getData();
            adapter = new AddFabSalesOrder(addReserveDetArrayList,AddfabricSoOrders.this,this,customerList);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            rv_addfab_soorder.setLayoutManager(lm);
            rv_addfab_soorder.setAdapter(adapter);

        }

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }

    @Override
    public void AddFabricsBelowI(poItem index, String qty) {
     /*  addReserveDetArrayList.add( new AddReserveDet(index.getId(),getOrderType,"",qty));   // to pass data to server
        addbelowDetArrayList.add(new AddReserveDet(index.getFabName(),index.getComposition(),qty));  // to show data at below

        AddFabOrderBelowADP  addFabOrderBelowADP = new AddFabOrderBelowADP(addbelowDetArrayList,AddfabricSoOrders.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_addselectedfab_soorder.setLayoutManager(lm);
        rv_addselectedfab_soorder.setAdapter(addFabOrderBelowADP);*/
        MenuItem menuItem = menu.findItem(R.id.addFab);

        poItemArrayList_adp.add(index);
        menuItem.setTitle(String.valueOf(poItemArrayList_adp.size()));





        //***********

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomersResponse response) {
        customerList=response.getDetail();

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
