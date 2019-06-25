package com.obpoo.gfsfabricsoftware.Report.UI;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryDetails;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricResponseDetails;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FabricOrderHistory extends BaseActivity implements ReportView {
    @BindView(R.id.fh_fabric)
    AutoCompleteTextView fh_fabric;
    @BindView(R.id.lineChart)
    LineChart lineChart;
    ReportPresenterImpl presenter;
    ArrayList<FabricHistoryDetails> fabricHistoryDetailsArrayList;
    @BindView(R.id.pbatshowhistory)
    ProgressBar pbatshowhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabric_order_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fabric Order History");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new ReportPresenterImpl(this);
        presenter.onSend_FabricNames("view_fabs");

        fh_fabric.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getSelctedFabric = fabricHistoryDetailsArrayList.get(position).getFabName();
                presenter.onSend_FabricGraphHistory("ordered_fabric",getSelctedFabric);
            }
        });




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
        fabricHistoryDetailsArrayList= response.getData();
        ArrayAdapter<FabricHistoryDetails> adapter  = new ArrayAdapter<FabricHistoryDetails>(this,android.R.layout.select_dialog_item,fabricHistoryDetailsArrayList);
        fh_fabric.setThreshold(1);
        fh_fabric.setAdapter(adapter);

    }

    @Override
    public void onFabricHistory(FabricGraphResponse response) {
        Log.i("FabricGraphResponse",response.getMessage());

        ArrayList<FabricResponseDetails> fabricResponseDetails = response.getData();

        ArrayList<Entry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();
        for(int i = 0; i<fabricResponseDetails.size();i++){
            yEntries.add(new Entry(Float.valueOf(fabricResponseDetails.get(i).getOrderedQuantity()),i));
            xEntries.add(fabricResponseDetails.get(i).getMonth());
        }

        int fabrichisSize = fabricResponseDetails.size();

        yEntries.add(new Entry(Float.valueOf(response.get1monthExpectedOrder()),fabrichisSize+1));
        yEntries.add(new Entry(Float.valueOf(response.get2monthExpectedOrder()),fabrichisSize+2));
        yEntries.add(new Entry(Float.valueOf(response.get3monthExpectedOrder()),fabrichisSize+3));
        xEntries.add("Jan");
        xEntries.add("Feb");
        xEntries.add("Mar");

        LineDataSet lineDataSet = new LineDataSet(yEntries,"Fabric Quantity in Meter ");
        lineDataSet.setDrawFilled(true);
        lineDataSet.setColor(getResources().getColor(R.color.blue_200));
        LineData lineData = new LineData(xEntries,lineDataSet);
        lineChart.setData(lineData);
        lineChart.animateY(3000);










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

    }


    @Override
    public void showDialog() {
        pbatshowhistory.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        pbatshowhistory.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }
}
