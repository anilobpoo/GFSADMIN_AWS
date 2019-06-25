package com.obpoo.gfsfabricsoftware.collections.ui;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.PO_Order;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.adapter.CollectionsDelAdapter;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsPresenterImpl;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionsDeliveries extends AppCompatActivity implements CollectionsView {
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.back_PO_cmngrp)
    ImageView back_PO_cmngrp;
    @BindView(R.id.date_select)
    ImageView date_select;
     @BindView(R.id.tranparent_bg)
    ImageView tranparent_bg;
     @BindView(R.id.progressbar)
     ProgressBar progressbar;

    CollectionsDelAdapter adapter;
    ArrayList<CollectionDatum> data;
    TextView finput, tinput, cancel, add;
    String d1, d2;
    private int mYear, mMonth, mDay;
    CollectionsPresenterImpl presenter;
    String[] previledges = {"Sale Orders", "Purchase Order", "Transfer Stock", "Break Fabric", "Stock", "Master", "Report", "Returns & Deliveries", "Cutter Guy", "Collections", "Associate Tailors"};
    ArrayList<CollectionDatum> collectionDatadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_deliveries);
        ButterKnife.bind(this);
        presenter = new CollectionsPresenterImpl(this);

        Intent intent = getIntent();
        data = intent.getParcelableArrayListExtra("date");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CollectionsDeliveries.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setNestedScrollingEnabled(false);
        Log.i("dataSize fst", data.size() + "");
        adapter = new CollectionsDelAdapter(CollectionsDeliveries.this, data);
        recycler_view.setAdapter(adapter);
    }

    @OnClick(R.id.back_PO_cmngrp)
    public void backClick() {
        finish();
    }

    @OnClick(R.id.date_select)
    public void dateSelectClick() {
        showADialog();
    }

    public void showADialog() {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dprompts, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        alertDialogBuilder.setView(promptsView);

        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();

        cancel = promptsView.findViewById(R.id.cancel);
        add = promptsView.findViewById(R.id.add);

        finput = promptsView.findViewById(R.id.from);
        finput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        tinput = promptsView.findViewById(R.id.to);
        tinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker2();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String f = finput.getText().toString();
                String t = tinput.getText().toString();

                if (f.equals("") || t.equals("") || f.equals("FROM") || t.equals("TO")) {
                    Toast.makeText(CollectionsDeliveries.this, "Please select to and from dates", Toast.LENGTH_SHORT).show();

                } else {
                    presenter.view(t, f, "new_pg_collection", previledges);
                    alertDialog.hide();

                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });

        alertDialog.show();
    }

    @Override
    public void showDialog() {
        tranparent_bg.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        tranparent_bg.setVisibility(View.GONE);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                d1 = String.valueOf(new StringBuilder().append(year).append("-").append(month + 1).append("-").append(dayOfMonth));
                finput.setText(d1);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showDatePicker2() {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                d2 = String.valueOf(new StringBuilder().append(year).append("-").append(+month + 1).append("-").append(dayOfMonth));
                tinput.setText(d2);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CollectionsDResponse response) {
        if (response.getStatus().equals("success")) {
            data = response.getData();
            adapter = new CollectionsDelAdapter(CollectionsDeliveries.this, data);
            recycler_view.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onInvoiceLoad(CollectionInvoiceResponse response) {

    }

    @Override
    public void onDepositeLoad(DepositeResponse response) {

    }
}
