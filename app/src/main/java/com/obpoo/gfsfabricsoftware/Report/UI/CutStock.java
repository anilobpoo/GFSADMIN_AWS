package com.obpoo.gfsfabricsoftware.Report.UI;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.CutStockAdapter;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponseDetails;
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
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CutStock extends BaseActivity implements ReportView {
    TextView fromdate_bi;
    TextView todate_bi;
    TextView cancel_bi;
    TextView add_bi;
    PopupWindow popupWindow;
    @BindView(R.id.linear_cs)
    LinearLayout linear_cs;
    private DatePickerDialog.OnDateSetListener fromdateSetListener, todateSetListener;
    String getFromDate, getToDate;
    ReportPresenterImpl presenter;
    @BindView(R.id.rv_cs)
    RecyclerView rv_cs;
    @BindView(R.id.etSearch)
    EditText etSearch;
    ArrayList<CutStockResponseDetails> cutStockResponseDetailsArrayList;
    CutStockAdapter adapter;
    @BindView(R.id.pbatshowcut)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_stock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cut Stock");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        etSearch.setHint("Search by Fabname/code/warehouse");

        presenter = new ReportPresenterImpl(this);

        fromdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                getFromDate = year + "-" + month + "-" + dayOfMonth;
                fromdate_bi.setText(getFromDate);
                Log.i("getFromDate", getFromDate);
            }
        };
        todateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                getToDate = year + "-" + month + "-" + dayOfMonth;
                todate_bi.setText(getToDate);
                Log.i("getToDate", getToDate);
            }
        };

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(cutStockResponseDetailsArrayList!=null){
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

    }

    @Override
    public void onCutStock_report(CutStockResponse response) {

        cutStockResponseDetailsArrayList = response.getData();
         adapter = new CutStockAdapter(cutStockResponseDetailsArrayList,CutStock.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_cs.setLayoutManager(lm);
        rv_cs.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_filterDate) {


            LayoutInflater layoutInflater = (LayoutInflater) CutStock.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = layoutInflater.inflate(R.layout.filterdate_bill_invoice, null);
            fromdate_bi = (TextView) customView.findViewById(R.id.fromdate_bi);
            todate_bi = (TextView) customView.findViewById(R.id.todate_bi);
            cancel_bi = (TextView) customView.findViewById(R.id.cancel_bi);
            add_bi = (TextView) customView.findViewById(R.id.add_bi);

            popupWindow = new PopupWindow(customView, Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(linear_cs, Gravity.CENTER,0,0);



            fromdate_bi.setText("From");
            todate_bi.setText("To");

            fromdate_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(CutStock.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, fromdateSetListener, year, month, day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            todate_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(CutStock.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, todateSetListener, year, month, day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            add_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    presenter.onSend_CutStock("cut_stock_report", getFromDate, getToDate);
                    popupWindow.dismiss();
                }
            });

            cancel_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });

        }


        return super.onOptionsItemSelected(item);
    }
    void filter(String text) {
        ArrayList<CutStockResponseDetails> temp = new ArrayList();

        for (CutStockResponseDetails d : cutStockResponseDetailsArrayList) {

                if ( d.getFabName()==null){
                    if(d.getUniqueCode().toLowerCase().contains(text.toLowerCase()) || d.getLocation().getWarehouseName().toLowerCase().contains(text.toLowerCase())){
                        temp.add(d);
                    }
                }
                else{
                    if(d.getFabName().toLowerCase().contains(text.toLowerCase())||
                            d.getUniqueCode().toLowerCase().contains(text.toLowerCase()) ||
                            d.getLocation().getWarehouseName().toLowerCase().contains(text.toLowerCase())){
                        temp.add(d);
                    }
                }
                }
        Log.i("TEMP", temp.size() + "");
        adapter.updateList(temp);

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
}

