package com.obpoo.gfsfabricsoftware.Report.UI;

import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.CustomerPendingAdapter;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingDetails;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportView;
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

public class CustomerPending extends BaseActivity implements ReportView,CustomersView {
    @BindView(R.id.cp_customer_spinner)
    Spinner cp_customer_spinner;
    @BindView(R.id.tabLayout_cp)
    TabLayout tabLayout_cp;
    @BindView(R.id.cp_rv)
    RecyclerView cp_rv;
    ReportPresenterImpl presenter;
    CustomersPresenterImpl customer_presenter;
    private ArrayList<CustomersDetail> customer_list = new ArrayList<>();
    String getCustomerId;
    int i =0;
    @BindView(R.id.etSearch)
    EditText etSearch;
    ArrayList<CustomerPendingDetails> customerPendingDetailsArrayList;
    CustomerPendingAdapter adapter;
    @BindView(R.id.pbatshowcustomer)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Report");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        tabLayout_cp.setTabTextColors(getResources().getColor(R.color.red_500),getResources().getColor(R.color.green_500));
        presenter = new ReportPresenterImpl(this);
        customer_presenter = new CustomersPresenterImpl(this);
        String admin_id = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        customer_presenter.viewAll("view_all", admin_id);
        etSearch.setHint("Search by OrderNo/Mode/DeliveryType");

        tabLayout_cp.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        i=1;
                        presenter.onSend_Customer_Pending_report("pending_bills",getCustomerId);
                        break;
                    case 1:
                        i=2;
                        presenter.onSend_Customer_Pending_report("paid_bills",getCustomerId);
                        break;
                    case 2:
                        i=3;
                        presenter.onSend_Customer_Pending_report("all_payments",getCustomerId);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(customerPendingDetailsArrayList!=null){
                    filter(s.toString());
                }

            }
        });
    }

    @Override
    public void onBill_Invoice_Report(Bill_Invoice_Response_data response) {

    }

    @Override
    public void onCustomer_pending_Report(CustomerPendingResponse response) {
        Log.i("CustomerPendingResponse",response.getMessage());
        customerPendingDetailsArrayList = response.getData();
         adapter = new CustomerPendingAdapter(customerPendingDetailsArrayList,CustomerPending.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        cp_rv.setLayoutManager(lm);
        cp_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


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

    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomersResponse response) {
        customer_list = response.getDetail();
        ArrayAdapter<CustomersDetail> spinnerAdapter = new ArrayAdapter<CustomersDetail>(getApplicationContext(), R.layout.spinner_text, customer_list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cp_customer_spinner.setAdapter(spinnerAdapter);


    }
    @OnItemSelected(R.id.cp_customer_spinner)
    public void onCustomerSelctioninCP(int position){
        getCustomerId=customer_list.get(position).getId();
        Log.i("getCustomerId",getCustomerId);
        if(i==0 || i==1){
        presenter.onSend_Customer_Pending_report("pending_bills",getCustomerId);
        } // execute only once

        if(i==2){
            presenter.onSend_Customer_Pending_report("paid_bills",getCustomerId);
        }
        if(i==3){
            presenter.onSend_Customer_Pending_report("all_payments",getCustomerId);
        }

    }

    void filter(String text) {
        ArrayList<CustomerPendingDetails> temp = new ArrayList();

            for (CustomerPendingDetails d : customerPendingDetailsArrayList) {
                if (d.getOrderNo().toLowerCase().contains(text.toLowerCase()) || d.getDeliveryType().toLowerCase().contains(text.toLowerCase()) ||
                        d.getPayMode().toLowerCase().contains(text.toLowerCase())) {
                    temp.add(d);
                }
            }
            Log.i("TEMP", temp.size() + "");
            adapter.updateList(temp);

    }
}
