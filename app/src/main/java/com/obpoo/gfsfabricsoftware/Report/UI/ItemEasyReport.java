package com.obpoo.gfsfabricsoftware.Report.UI;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.ItemEasyAdp;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemEasyReport extends BaseActivity implements ReportView {
    @BindView(R.id.allSo_rv)
    RecyclerView allSo_rv;
    @BindView(R.id.progress_allso)
    ProgressBar progress_allso;
    ReportPresenterImpl presenter;
    String getFromIEF,getToIEF,getCusIDIEF;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppConstants.itemEasyfilter){
            if(data!=null){
                getFromIEF= data.getStringExtra("getFromDateIEF");
                getToIEF=data.getStringExtra("getTodateIEF");
                getCusIDIEF=data.getStringExtra("statusIEF");

                presenter.onSend_item_easy_report(getCusIDIEF,getFromIEF,"filterView_prcs_pagn",getToIEF,"1");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_so);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Item Easy");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new ReportPresenterImpl(this);
        presenter.onSend_item_easy_report("ALL","2019-06-18 09:26:44 +0000","filterView_prcs_pagn","2019-06-25","1");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.soallorder,menu);
        return true;
    }

    @Override
    public void onBill_Invoice_Report(Bill_Invoice_Response_data response) {

    }

    @Override
    public void onCustomer_pending_Report(CustomerPendingResponse response) {

    }

    @Override
    public void onCutStock_report(CutStockResponse response) {

    }

    @Override
    public void onFabricAnalytics(FabricAnalyticsResponse response) {

    }

    @Override
    public void onfabricNames(FabricHistoryResponse response) {

    }

    @Override
    public void onFabricHistory(FabricGraphResponse response) {

    }

    @Override
    public void onPaymentReceived(PaymentRecResponse response) {

    }

    @Override
    public void onPOdetails(PoDetailsresponse response) {

    }

    @Override
    public void onPOfabricList(PO_Fabric_Response response) {

    }

    @Override
    public void onPOleftovers(POleftOverResponse response) {

    }

    @Override
    public void onCheckIn(CheckInResponse response) {

    }

    @Override
    public void onCheckOut(CheckOutResponse response) {

    }

    @Override
    public void onSoldFabrics(SoldFabricsResponse response) {

    }

    @Override
    public void onItemEasyReport(SoldFabricsResponse response) {
        if(response.getStatus().equals("success")){
            ArrayList<SoldFabricsData> soldFabricsDataArrayList = response.getData();
            ItemEasyAdp  adapter = new ItemEasyAdp(soldFabricsDataArrayList,ItemEasyReport.this);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            allSo_rv.setLayoutManager(lm);
            allSo_rv.setAdapter(adapter);



        }

    }

    @Override
    public void showDialog() {
        progress_allso.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progress_allso.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.so_filter:
                Intent in = new Intent(ItemEasyReport.this,ItemEasyFilter.class);
                startActivityForResult(in, AppConstants.itemEasyfilter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
