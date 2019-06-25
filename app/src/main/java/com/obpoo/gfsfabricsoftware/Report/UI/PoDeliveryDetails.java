package com.obpoo.gfsfabricsoftware.Report.UI;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.PoDetailsAdapter;
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
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsRespoDet;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoDeliveryDetails extends BaseActivity implements ReportView{
    @BindView(R.id.rv_pod)
    RecyclerView rv_pod;
    ReportPresenterImpl presenter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    ArrayList<PoDetailsRespoDet> poDetailsRespoDetArrayList;
    PoDetailsAdapter adapter;
    @BindView(R.id.pbatshowdelivery)
    ProgressBar pbatshowdelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_delivery_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RequestedOrder Delivery Details");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new ReportPresenterImpl(this);
        etSearch.setHint("Search by Order No/factory/Staff");
        presenter.onSend_PoDetails("pending_orders");
        
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(poDetailsRespoDetArrayList!=null){
                    filter(s.toString());
                }

            }
        });
    }

    private void filter(String text) {
        ArrayList<PoDetailsRespoDet> temp = new ArrayList<>();

        for(PoDetailsRespoDet d:poDetailsRespoDetArrayList ){
            if(d.getFactory().contains(text.toLowerCase()) || d.getId().contains(text.toLowerCase())|| d.getStaff().contains(text.toLowerCase())){
                temp.add(d);
            }
            adapter.updateList(temp);
        }
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
        Log.i("PoDetailsresponse",response.getMessage());
         poDetailsRespoDetArrayList = response.getData();

         adapter = new PoDetailsAdapter(poDetailsRespoDetArrayList,PoDeliveryDetails.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_pod.setLayoutManager(lm);
        rv_pod.setAdapter(adapter);
        adapter.notifyDataSetChanged();


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

    }

    @Override
    public void showDialog() {
        pbatshowdelivery.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        pbatshowdelivery.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }
}
