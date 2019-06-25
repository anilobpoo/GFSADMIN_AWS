package com.obpoo.gfsfabricsoftware.Report.UI;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
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
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.BillInvoiceAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.DailySalesAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.FabricAnalyticsAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.POCheckINAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.POFabricListAdp;
import com.obpoo.gfsfabricsoftware.Report.Adapter.POcheckOUtAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.POleftAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.PaymentReceivedAdapter;
import com.obpoo.gfsfabricsoftware.Report.Adapter.SoldFabricsAdapter;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOUtData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsDetails;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POLeftOverData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_fabric_response_details;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentReceivedData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsData;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Report.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Bill_Invoice_Report extends BaseActivity implements ReportView {
    ReportPresenterImpl presenter;
    @BindView(R.id.rv_bi)
    RecyclerView rv_bi;
    @BindView(R.id.t_vat)
    TextView t_vat;
    @BindView(R.id.tpa_bi)
    TextView tpa_bi;
    @BindView(R.id.dis_act_bi)
    TextView dis_act_bi;
    @BindView(R.id.etSearch)
    EditText etSearch;
    String formattedDate;
    String getFromDate, getToDate;
    private DatePickerDialog.OnDateSetListener fromdateSetListener, todateSetListener;
    TextView fromdate_bi;
    TextView todate_bi;
    TextView cancel_bi;
    TextView add_bi;
    PopupWindow popupWindow;
    @BindView(R.id.bi_con_lay)
    ConstraintLayout bi_con_lay;
    String reportName;
    @BindView(R.id.pbatshowbill)
    ProgressBar progressBar;



    ArrayList<Bill_Invoice_Response> bill_invoice_responseArrayList;
    BillInvoiceAdapter billInvoiceAdapter;
    DailySalesAdapter dailyAdapter;
    ArrayList<FabricAnalyticsDetails> fabricAnalyticsDetailsArrayList;
    FabricAnalyticsAdapter fabricAnalyticsAdapter;
    ArrayList<PaymentReceivedData> paymentReceivedDataArrayList;
    PaymentReceivedAdapter paymentReceivedAdapter;
    ArrayList<PO_fabric_response_details> po_fabric_response_details;
    POFabricListAdp poFabricListAdp;
    ArrayList<POLeftOverData> poLeftOverData;
    POleftAdapter pOleftAdapter;
    ArrayList<CheckInData> checkInDataArrayList;
    POCheckINAdapter poCheckINAdapter;
    ArrayList<CheckOUtData> checkOutDataArrayList;
    POcheckOUtAdapter pOcheckOUtAdapter;
    ArrayList<SoldFabricsData> soldFabricsDataArrayList;
    SoldFabricsAdapter  soldFabricsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill__invoice__report);
        reportName=getIntent().getStringExtra("ReportName");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(reportName.equals(AppConstants.billReport)){
        toolbar.setTitle(AppConstants.billReport);

        }
        if(reportName.equals(AppConstants.salesReport)){
            toolbar.setTitle(AppConstants.salesReport);
        }
        if(reportName.equals(AppConstants.fabricAnaluytics)){
            toolbar.setTitle(AppConstants.fabricAnaluytics);
        }
        if(reportName.equals(AppConstants.openBill)){
            toolbar.setTitle(AppConstants.openBill);
        }
        if(reportName.equals(AppConstants.paymentReceived)){
            toolbar.setTitle(AppConstants.paymentReceived);
        }
        if(reportName.equals(AppConstants.po_fabric_list_const)){
            toolbar.setTitle(AppConstants.po_fabric_list_const);
        }
        if(reportName.equals(AppConstants.po_left_overs)){
            toolbar.setTitle(AppConstants.po_left_overs);
        }
        if(reportName.equals(AppConstants.po_check_in)){
            toolbar.setTitle(AppConstants.po_check_in);
        }

        if(reportName.equals(AppConstants.pocheckOut)){
            toolbar.setTitle(AppConstants.pocheckOut);
        }
        if(reportName.equals(AppConstants.soldfabrics)){
            toolbar.setTitle(AppConstants.soldfabrics);
        }
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        if(reportName.equals(AppConstants.billReport) || reportName.equals(AppConstants.salesReport) || reportName.equals(AppConstants.openBill)){
            etSearch.setHint("Search by Order No/Mode/Delivery type");
        }
        if(reportName.equals(AppConstants.fabricAnaluytics)){
            etSearch.setHint("Search By FabName");
        }
        if(reportName.equals(AppConstants.paymentReceived)){
            etSearch.setHint("Search by Txn No/from/type");
        }
        if(reportName.equals(AppConstants.po_fabric_list_const)){
            etSearch.setHint("Search by Order No/Fabric/Status");
        }
        if(reportName.equals(AppConstants.po_left_overs)){
            etSearch.setHint("Search by Invoice/Baikon/Bundle/Order No");
        }
        if(reportName.equals(AppConstants.po_check_in)){
            etSearch.setHint("Search by Name/type/Txn no");
        }
        if(reportName.equals(AppConstants.pocheckOut)) {
            etSearch.setHint("Search by Type/Txn no ");
        }
        if(reportName.equals(AppConstants.soldfabrics)){
            etSearch.setHint("Search by OrderId/Fabric/Mode ");
        }


        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = df.format(c.getTime());
        Log.i("formattedDate",formattedDate);

        presenter = new ReportPresenterImpl(this);

        if(reportName.equals(AppConstants.billReport)|| reportName.equals(AppConstants.salesReport)){
        presenter.onSend_Bill_Invoice_Report("all_order_search", formattedDate, formattedDate);}
        if(reportName.equals(AppConstants.openBill)){
            presenter.onSend_Bill_Invoice_Report("not_yet_closed", formattedDate, formattedDate);
        }
        if(reportName.equals(AppConstants.paymentReceived)){
            presenter.onSend_PaymentReceived("all_payments",formattedDate,formattedDate);
        }
        if(reportName.equals(AppConstants.po_fabric_list_const)){
            presenter.onSend_PO_Fabric_List("view_all_fabric",formattedDate,formattedDate);
        }
        if(reportName.equals(AppConstants.po_left_overs)){
            presenter.onSend_PO_LeftOvers("po_leftovers",formattedDate,formattedDate);
        }
        if(reportName.equals(AppConstants.po_check_in)){
            presenter.onSend_PO_checkIN("check_in",formattedDate,formattedDate);
        }
        if(reportName.equals(AppConstants.pocheckOut)){
            presenter.onSend_PO_checkOUT("check_out",formattedDate,formattedDate);        //for checkin And checkout same presenter
        }
        if(reportName.equals(AppConstants.soldfabrics)){
            presenter.onSend_Sold_Fabric("sold_fabrics",formattedDate,formattedDate);        //for checkin And checkout same presenter
        }


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

        if(reportName.equals(AppConstants.salesReport)||reportName.equals(AppConstants.fabricAnaluytics)
                ||reportName.equals(AppConstants.paymentReceived) ||
                reportName.equals(AppConstants.po_fabric_list_const) ||
                reportName.equals(AppConstants.po_left_overs) || reportName.equals(AppConstants.po_check_in)
                || reportName.equals(AppConstants.pocheckOut)|| reportName.equals(AppConstants.soldfabrics)){
            t_vat.setVisibility(View.GONE);
            tpa_bi.setVisibility(View.GONE);
            dis_act_bi.setVisibility(View.GONE);


        }

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(reportName.equals(AppConstants.billReport)){
                    if(bill_invoice_responseArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.salesReport)){
                    if(bill_invoice_responseArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.fabricAnaluytics)){
                    if(fabricAnalyticsDetailsArrayList!=null){
                        filter(s.toString());
                    }

                }
                if(reportName.equals(AppConstants.openBill)){
                    if(bill_invoice_responseArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.paymentReceived)){
                    if(paymentReceivedDataArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.po_fabric_list_const)){
                    if(po_fabric_response_details!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.po_left_overs)){
                    if(poLeftOverData!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.po_check_in)){
                    if(checkInDataArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.pocheckOut)){
                    if(checkOutDataArrayList!=null){
                        filter(s.toString());
                    }
                }
                if(reportName.equals(AppConstants.soldfabrics)){
                    if(soldFabricsDataArrayList!=null){
                        filter(s.toString());
                    }
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter, menu);
        return true;
    }

    @Override
    public void onBill_Invoice_Report(Bill_Invoice_Response_data response) {


        Log.i("onBill_Invoice_Report", response.getMessage());
        if(response.getMessage().equals("0 Orders Found.")){
            Toast.makeText(getApplicationContext(),"No Invoice Available",Toast.LENGTH_SHORT).show();
        }
        else {
           bill_invoice_responseArrayList  = response.getData();

            if(reportName.equals(AppConstants.billReport)|| reportName.equals(AppConstants.openBill)){

        billInvoiceAdapter = new BillInvoiceAdapter(bill_invoice_responseArrayList, Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(billInvoiceAdapter);
        billInvoiceAdapter.notifyDataSetChanged();

            double vatTotal = 0.0;
            double discountTotal = 0.0;
            double payableTotal = 0.0;

            for (int i = 0; i < bill_invoice_responseArrayList.size(); i++) {
                vatTotal = vatTotal + Double.parseDouble(bill_invoice_responseArrayList.get(i).getVatAmount());
                Double discountDoub = Double.parseDouble(bill_invoice_responseArrayList.get(i).getOrderTotal()) * (Double.parseDouble(
                        bill_invoice_responseArrayList.get(i).getDiscountPer()) / 100);
                discountTotal = discountTotal + discountDoub;
                payableTotal = payableTotal + Double.parseDouble(bill_invoice_responseArrayList.get(i).getPaybleAmount());

            }

            t_vat.setText("Vat: " + String.format("%.2f", vatTotal));
            tpa_bi.setText("Discount: " + String.format("%.2f", payableTotal));
            dis_act_bi.setText("Total Payable Amount: " + String.format("%.2f", discountTotal));}

            if(reportName.equals(AppConstants.salesReport)){
                t_vat.setVisibility(View.GONE);
                tpa_bi.setVisibility(View.GONE);
                dis_act_bi.setVisibility(View.GONE);

                 dailyAdapter = new DailySalesAdapter(bill_invoice_responseArrayList,Bill_Invoice_Report.this);
                LinearLayoutManager lm = new LinearLayoutManager(this);
                rv_bi.setLayoutManager(lm);
                rv_bi.setAdapter(dailyAdapter);
                dailyAdapter.notifyDataSetChanged();


            }
        }


    }

    @Override
    public void onCustomer_pending_Report(CustomerPendingResponse response) {

    }

    @Override
    public void onCutStock_report(CutStockResponse response) {

    }

    @Override
    public void onFabricAnalytics(FabricAnalyticsResponse response) {
        fabricAnalyticsDetailsArrayList= response.getData();
         fabricAnalyticsAdapter = new FabricAnalyticsAdapter(fabricAnalyticsDetailsArrayList,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(fabricAnalyticsAdapter);
        fabricAnalyticsAdapter.notifyDataSetChanged();


    }

    @Override
    public void onfabricNames(FabricHistoryResponse response) {

    }

    @Override
    public void onFabricHistory(FabricGraphResponse response) {

    }

    @Override
    public void onPaymentReceived(PaymentRecResponse response) {
        paymentReceivedDataArrayList = response.getData();
         paymentReceivedAdapter = new PaymentReceivedAdapter(paymentReceivedDataArrayList,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(paymentReceivedAdapter);
        paymentReceivedAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPOdetails(PoDetailsresponse response) {

    }

    @Override
    public void onPOfabricList(PO_Fabric_Response response) {
        Log.i("onPOfabricList",response.getMessage());
        po_fabric_response_details = response.getData();
         poFabricListAdp = new POFabricListAdp(po_fabric_response_details,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(poFabricListAdp);
        poFabricListAdp.notifyDataSetChanged();

    }

    @Override
    public void onPOleftovers(POleftOverResponse response) {
        Log.i("POleftOverResponse",response.getMessage());
         poLeftOverData = response.getData();
         pOleftAdapter = new POleftAdapter(poLeftOverData,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(pOleftAdapter);
        pOleftAdapter.notifyDataSetChanged();


    }

    @Override
    public void onCheckIn(CheckInResponse response) {

        Log.i("CheckInResponse",response.getMessage());
         checkInDataArrayList = response.getData();
         poCheckINAdapter = new POCheckINAdapter(checkInDataArrayList,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(poCheckINAdapter);
        poCheckINAdapter.notifyDataSetChanged();




    }

    @Override
    public void onCheckOut(CheckOutResponse response) {
        Log.i("checkOut",response.getMessage());
        checkOutDataArrayList = response.getData();
        pOcheckOUtAdapter = new POcheckOUtAdapter(checkOutDataArrayList,Bill_Invoice_Report.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(pOcheckOUtAdapter);
        pOcheckOUtAdapter.notifyDataSetChanged();

    }

    @Override
    public void onSoldFabrics(SoldFabricsResponse response) {
        Log.i("SoldFabrics",response.getMessage());
         soldFabricsDataArrayList = response.getData();
          soldFabricsAdapter = new SoldFabricsAdapter(soldFabricsDataArrayList,Bill_Invoice_Report.this) ;
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi.setLayoutManager(lm);
        rv_bi.setAdapter(soldFabricsAdapter);
        soldFabricsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemEasyReport(SoldFabricsResponse response) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_filterDate) {


            LayoutInflater layoutInflater = (LayoutInflater) Bill_Invoice_Report.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = layoutInflater.inflate(R.layout.filterdate_bill_invoice, null);
            fromdate_bi = (TextView) customView.findViewById(R.id.fromdate_bi);
            todate_bi = (TextView) customView.findViewById(R.id.todate_bi);
            cancel_bi = (TextView) customView.findViewById(R.id.cancel_bi);
            add_bi = (TextView) customView.findViewById(R.id.add_bi);

            popupWindow = new PopupWindow(customView, Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(bi_con_lay, Gravity.CENTER,0,0);



            fromdate_bi.setText(formattedDate);
            todate_bi.setText(formattedDate);

            fromdate_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(Bill_Invoice_Report.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, fromdateSetListener, year, month, day);
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

                    DatePickerDialog dialog = new DatePickerDialog(Bill_Invoice_Report.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, todateSetListener, year, month, day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            add_bi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(reportName.equals(AppConstants.fabricAnaluytics)){
                        presenter.onSend_FabricAnalytics("fabric_analytics",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.billReport)|| reportName.equals(AppConstants.salesReport)){

                    presenter.onSend_Bill_Invoice_Report("all_order_search", getFromDate, getToDate);
                   }
                    if(reportName.equals(AppConstants.openBill)){
                        presenter.onSend_Bill_Invoice_Report("not_yet_closed", getFromDate, getToDate);
                    }
                    if(reportName.equals(AppConstants.paymentReceived)){
                        presenter.onSend_PaymentReceived("all_payments",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.po_fabric_list_const)){
                        presenter.onSend_PO_Fabric_List("view_all_fabric",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.po_left_overs)){
                        presenter.onSend_PO_LeftOvers("po_leftovers",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.po_check_in)){
                        presenter.onSend_PO_checkIN("check_in",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.pocheckOut)){
                        presenter.onSend_PO_checkOUT("check_out",getFromDate,getToDate);
                    }
                    if(reportName.equals(AppConstants.soldfabrics)){
                        presenter.onSend_Sold_Fabric("sold_fabrics",getFromDate,getToDate);        //for checkin And checkout same presenter
                    }

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
        ArrayList<Bill_Invoice_Response> temp = new ArrayList();
        if (reportName.equals(AppConstants.billReport)|| reportName.equals(AppConstants.openBill)) {
            for (Bill_Invoice_Response d : bill_invoice_responseArrayList) {
                if (d.getOrderNo().toLowerCase().contains(text.toLowerCase()) || d.getDeliveryType().toLowerCase().contains(text.toLowerCase()) ||
                        d.getPayMode().toLowerCase().contains(text.toLowerCase())) {
                    temp.add(d);
                }
            }
            Log.i("TEMP", temp.size() + "");
            billInvoiceAdapter.updateList(temp);
        }

        if (reportName.equals(AppConstants.salesReport)) {
            for (Bill_Invoice_Response d : bill_invoice_responseArrayList) {
                if (d.getOrderNo().toLowerCase().contains(text.toLowerCase()) || d.getDeliveryType().toLowerCase().contains(text.toLowerCase()) ||
                        d.getPayMode().toLowerCase().contains(text.toLowerCase())) {
                    temp.add(d);
                }
            }
            Log.i("TEMP", temp.size() + "");
            dailyAdapter.updateList(temp);
        }

        if (reportName.equals(AppConstants.fabricAnaluytics)) {
            ArrayList<FabricAnalyticsDetails> tempfabric = new ArrayList<>();
            for (FabricAnalyticsDetails d : fabricAnalyticsDetailsArrayList) {
                if (d.getFabName().toLowerCase().contains(text.toLowerCase())) {
                    tempfabric.add(d);
                }
            }
            Log.i("TEMP", temp.size() + "");
            fabricAnalyticsAdapter.updateList(tempfabric);
        }
        if (reportName.equals(AppConstants.paymentReceived)) {
            ArrayList<PaymentReceivedData> temppayment = new ArrayList<>();
            for (PaymentReceivedData d : paymentReceivedDataArrayList) {
                if (d.getNumber().toLowerCase().contains(text.toLowerCase())|| d.getFrom().toLowerCase().contains(text.toLowerCase())||
                        d.getType().toLowerCase().contains(text.toLowerCase())) {
                    temppayment.add(d);
                }
            }

            paymentReceivedAdapter.updateList(temppayment);
        }

        if (reportName.equals(AppConstants.po_fabric_list_const)) {
            ArrayList<PO_fabric_response_details> temp_po_fabric = new ArrayList<>();
            for (PO_fabric_response_details d : po_fabric_response_details) {
                if (d.getOid().toLowerCase().contains(text.toLowerCase())|| d.getFabName().toLowerCase().contains(text.toLowerCase())||
                        d.getPoSatatus().toLowerCase().contains(text.toLowerCase())) {
                    temp_po_fabric.add(d);
                }
            }

            poFabricListAdp.updateList(temp_po_fabric);
        }

        if (reportName.equals(AppConstants.po_left_overs)) {
            ArrayList<POLeftOverData> temp_po_fabric = new ArrayList<>();
            for (POLeftOverData d : poLeftOverData) {
                if (d.getInvoiceNo().toLowerCase().contains(text.toLowerCase())|| d.getBaikonNo().toLowerCase().contains(text.toLowerCase())||
                        d.getBundleNo().toLowerCase().contains(text.toLowerCase()) || d.getPoId().toLowerCase().contains(text.toLowerCase())) {
                    temp_po_fabric.add(d);
                }
            }

            pOleftAdapter.updateList(temp_po_fabric);
        }
        if (reportName.equals(AppConstants.po_check_in)) {
            ArrayList<CheckInData> temp_po_fabric = new ArrayList<>();
            for (CheckInData d : checkInDataArrayList) {
                if (d.getCustomerName().toLowerCase().contains(text.toLowerCase())|| d.getType().toLowerCase().contains(text.toLowerCase())||
                        d.getNumber().toLowerCase().contains(text.toLowerCase())) {
                    temp_po_fabric.add(d);
                }
            }

            poCheckINAdapter.updateList(temp_po_fabric);
        }

        if (reportName.equals(AppConstants.pocheckOut)) {
            ArrayList<CheckOUtData> temp_po_fabric = new ArrayList<>();
            for (CheckOUtData d : checkOutDataArrayList) {
                if (d.getType().toLowerCase().contains(text.toLowerCase())||
                        d.getNumber().toLowerCase().contains(text.toLowerCase())) {
                    temp_po_fabric.add(d);
                }
            }

            pOcheckOUtAdapter.updateList(temp_po_fabric);
        }
        if (reportName.equals(AppConstants.soldfabrics)) {
            ArrayList<SoldFabricsData> temp_po_fabric = new ArrayList<>();
            for (SoldFabricsData d : soldFabricsDataArrayList) {
                if (d.getOrderid().toLowerCase().contains(text.toLowerCase())||
                        d.getFabName().toLowerCase().contains(text.toLowerCase())|| d.getPayMode().toLowerCase().contains(text.toLowerCase())) {
                    temp_po_fabric.add(d);
                }
            }

            soldFabricsAdapter.updateList(temp_po_fabric);
        }
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

