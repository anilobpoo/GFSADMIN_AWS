package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SOMenu extends BaseActivity {
    @BindView(R.id.so_order_menu)
    RelativeLayout so_order_menu;
    @BindView(R.id.so_allorder_menu)
    RelativeLayout so_allorder_menu;
    @BindView(R.id.so_collect_menu)
    RelativeLayout so_collect_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sale Order");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);



    }
    @OnClick(R.id.so_allorder_menu)
    public void onAllOrder(View view){
        Intent in = new Intent(SOMenu.this,AllSO.class);
        startActivity(in);

    }
    @OnClick(R.id.so_order_menu)
    public void onOrders(View view){
        Intent in = new Intent(SOMenu.this,MyOrders.class);
        startActivity(in);
    }
}
