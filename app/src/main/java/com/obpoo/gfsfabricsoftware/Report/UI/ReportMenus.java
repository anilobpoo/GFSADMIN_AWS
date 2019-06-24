package com.obpoo.gfsfabricsoftware.Report.UI;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.ReportMenuAdp;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportMenus extends BaseActivity {
    @BindView(R.id.rv_report_menu)
    RecyclerView rv_report_menu;

    ArrayList<String> reportMenus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_menus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Report");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        reportMenus.add(AppConstants.billReport);
        reportMenus.add("Customers Pending Report");
        reportMenus.add("Cut Stocks");
        reportMenus.add(AppConstants.salesReport);
        reportMenus.add(AppConstants.fabricAnaluytics);
        reportMenus.add("Fabric Order History");
        reportMenus.add(AppConstants.openBill);
        reportMenus.add(AppConstants.paymentReceived);
        reportMenus.add("RequestedOrder Delivery Details");
        reportMenus.add(AppConstants.po_fabric_list_const);
        reportMenus.add(AppConstants.po_left_overs);
        reportMenus.add(AppConstants.po_check_in);
        reportMenus.add(AppConstants.pocheckOut);
        reportMenus.add(AppConstants.soldfabrics);

        int[] report_icon = new int[]{
                R.drawable.bill_32,
                R.drawable.pendingreport_32,
                R.drawable.cutstock_32,
                R.drawable.dailyreport_32,
                R.drawable.analytics_32,
                R.drawable.orderhistory_32,
                R.drawable.bill_32,
                R.drawable.paymentreceived_32,
                R.drawable.delivery_32,
                R.drawable.pofabric_32,
                R.drawable.poleftover_32,
                R.drawable.chequein_32,
                R.drawable.chequeout_32,
                R.drawable.saleorder_32
        };

        ReportMenuAdp adapter = new ReportMenuAdp(reportMenus,ReportMenus.this,report_icon);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_report_menu.setLayoutManager(lm);
        rv_report_menu.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
