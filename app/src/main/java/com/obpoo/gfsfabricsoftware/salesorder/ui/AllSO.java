package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.TrackPO;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.UI.Bill_Invoice_Report;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.AllOrderSoAdp;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AddFabricOrdersSO;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderStatusData;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSOData;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersPresenterImpl;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllSO extends BaseActivity implements MyOrdersView {
    MyOrdersPresenterImpl  presenter;
    @BindView(R.id.allSo_rv)
    RecyclerView allSo_rv;
    @BindView(R.id.progress_allso)
    ProgressBar progress_allso;
    @BindView(R.id.rel_so_allorder)
    RelativeLayout rel_so_allorder;
    TextView fromdate_bi, todate_bi, cancel_bi, add_bi;
    PopupWindow popupWindow;
    String formattedDate, getFromDate, getToDate;;
    private DatePickerDialog.OnDateSetListener fromdateSetListener, todateSetListener;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppConstants.salesORderAllActIN){
            ArrayList<AllOrderSOData> allOrderSODataArrayList = data.getParcelableArrayListExtra(AppConstants.salesAllOrderSelectedStatsuRes);
            AllOrderSoAdp adapter = new AllOrderSoAdp(allOrderSODataArrayList,AllSO.this);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            allSo_rv.setLayoutManager(lm);
            allSo_rv.setAdapter(adapter);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_so);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("All Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new MyOrdersPresenterImpl(this);

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
        presenter.onPassAllORderSo("view_with_status_pagn","1");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.soallorder,menu);
        return true;
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MyOrdersResponse response) {

    }

    @Override
    public void onAllSO(AllOrderRes response) {
        Log.i("AllSoRes",response.getMessage());
        ArrayList<AllOrderSOData> allOrderSODataArrayList = response.getData();
        AllOrderSoAdp adapter = new AllOrderSoAdp(allOrderSODataArrayList,AllSO.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        allSo_rv.setLayoutManager(lm);
        allSo_rv.setAdapter(adapter);



    }

    @Override
    public void onAllSoStatus(AllOrderStatusRes response) {
        if(response.getStatus().equals("success")){
            ArrayList<AllORderStatusData> allORderStatusDataArrayList = response.getData();
            Intent in = new Intent(AllSO.this, TrackPO.class);
            in.putExtra("POSOTAG","SOALLSTATUSVAL");
            in.putParcelableArrayListExtra(AppConstants.salesallOrderStatus,allORderStatusDataArrayList);
            startActivityForResult(in,AppConstants.salesORderAllActIN);

        }


    }

    @Override
    public void onAddFabricsSO(AddFabricOrdersSO response) {

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
           case R.id.so_date_filter: callDateSoAllOrderFilter();
               break;
           case R.id.so_filter:
               presenter.onPassAllOrderSoStatus("view_all");
               break;
            default:break;
       }


        return super.onOptionsItemSelected(item);
    }

    private void callDateSoAllOrderFilter() {

        LayoutInflater layoutInflater = (LayoutInflater) AllSO.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.filterdate_bill_invoice, null);
        fromdate_bi = (TextView) customView.findViewById(R.id.fromdate_bi);
        todate_bi = (TextView) customView.findViewById(R.id.todate_bi);
        cancel_bi = (TextView) customView.findViewById(R.id.cancel_bi);
        add_bi = (TextView) customView.findViewById(R.id.add_bi);

        popupWindow = new PopupWindow(customView, Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(rel_so_allorder, Gravity.CENTER,0,0);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = df.format(c.getTime());

        fromdate_bi.setText(formattedDate);
        todate_bi.setText(formattedDate);

        fromdate_bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AllSO.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, fromdateSetListener, year, month, day);
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

                DatePickerDialog dialog = new DatePickerDialog(AllSO.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, todateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        add_bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onPassAllSOorderdateFilter("view_with_status_pro_pagn",getFromDate,getToDate,"1");

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
}
