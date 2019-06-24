package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.ItemDetail;


import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.SO_order_det_fab_adp;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderItemDet;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SOorderDetails extends BaseActivity {
    MyOrdersDetail item;
    @BindView(R.id.so_det_orderId)
    TextView so_det_orderId ;
    @BindView(R.id.date_so_det)
    TextView date_so_det;
    @BindView(R.id.desc_so_order_det)
    TextView desc_so_order_det;
    @BindView(R.id.type_so_det)
    TextView type_so_det;
    @BindView(R.id.mode_so_det)
    TextView mode_so_det;
    @BindView(R.id.address_so_det)
    TextView address_so_det;
    @BindView(R.id.item_so_det)
    TextView item_so_det;
    @BindView(R.id.price_so_det)
    TextView price_so_det;
    @BindView(R.id.dis_so_det)
    TextView dis_so_det;
    @BindView(R.id.paid_so_det)
    TextView paid_so_det;
    @BindView(R.id.total_so_det)
    TextView total_so_det;
    @BindView(R.id.cancel_so_det2)
    Button cancel_so_det2;
    @BindView(R.id.add_so_det)
    Button add_so_det;
    @BindView(R.id.rv_so_det)
    RecyclerView rv_so_det;
    ArrayList<AllOrderItemDet> itemDetailsses;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==AppConstants.addfanricSOorders){
            AddReserveDet index = data.getParcelableExtra("ORDERFABRIC");
            String qty_fab = data.getStringExtra("FABSOORDERQTY");
            itemDetailsses.add( new AllOrderItemDet(qty_fab,"0",index.getFabName(),index.getFabImg()));
            SO_order_det_fab_adp adapter = new SO_order_det_fab_adp(itemDetailsses,SOorderDetails.this);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            rv_so_det.setLayoutManager(lm);
            rv_so_det.setAdapter(adapter);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soorder_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        item = getIntent().getParcelableExtra(AppConstants.orderSoDetails);

        Log.i("OrderDetailsCheck",item.getDeliveryType());

        so_det_orderId.setText("#"+item.getOrderNo());
        date_so_det.setText(item.getOrderdate());
        desc_so_order_det.setText("");
        type_so_det.setText(item.getDeliveryType());
        mode_so_det.setText(item.getPayMode());
        address_so_det.setText(item.getDelliveryAddress());

        if(item.getItemDetails().size()>0){
        item_so_det.setText(item.getItemDetails().size()+"");}

        String getCompl = callCompleteStatus();
        desc_so_order_det.setText(getCompl);
        price_so_det.setText(item.getOrderTotal());
        dis_so_det.setText(item.getDiscount()+"%");
        paid_so_det.setText(String.valueOf(Integer.valueOf(item.getPaybleAmount())-Integer.valueOf(item.getLeftover())));


        total_so_det.setText(String.valueOf( Integer.valueOf(item.getOrderTotal()) -( Integer.valueOf(item.getOrderTotal()) *( Integer.valueOf(item.getDiscount())/100))));

        itemDetailsses = item.getItemDetails();
        SO_order_det_fab_adp adapter = new SO_order_det_fab_adp(itemDetailsses,SOorderDetails.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_so_det.setLayoutManager(lm);
        rv_so_det.setAdapter(adapter);



    }

    private String callCompleteStatus() {
        switch(item.getCompleteStatus()){
            case "0":
                return "Order is incompleted now.";
            case "1":
                return "Order is placed, Waiting for confirmation from vendor.";
            case "2":
                return "Waiting for cutter.";
            case "4":
                return "Processing quality check.";
            case "5":
                return "Process Completed";
            case "6":
                return "Packet assigned, pickup pending.";
            case "7":
                return "Order is delivered.";
            case "8":
                return "Order is cancelled.";
            case "9":
                return "Pickup Guy Received Order Still Not Delivered.";
            case "10":
                return "Return requested by the customer.";
            case "11":
                return "Return accepted and PG assigned for reverse pick up.";
            case "12":
                return "Return received by PG.";
            default:
                return "Unknown";
        }
    }

    @OnClick(R.id.add_so_det)
    public void onAddFabricSo(View view){
        Intent in = new Intent(SOorderDetails.this,AddfabricSoOrders.class);
        startActivityForResult(in,AppConstants.addfanricSOorders);

    }
}
