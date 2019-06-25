package com.obpoo.gfsfabricsoftware.collections.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.adapter.DepositeAdapter;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsPresenterImpl;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Deposit extends AppCompatActivity implements CollectionsView {

    @BindView(R.id.card2)
    CardView card2;
    @BindView(R.id.date_et)
    EditText date_et;
    @BindView(R.id.trans_bg)
    ImageView trans_bg;
    @BindView(R.id.back_PO_cmngrp)
    ImageView back_PO_cmngrp;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    CollectionsPresenterImpl presenter;
    String currentDate;
    DepositeAdapter adapter;
    List<DepositeDatum> depositeData;
    String view_diposites[] = {"Sale Orders", "Purchase Order", "Transfer Stock", "Break Fabric", "Stock", "Master", "Report", "Returns & Deliveries", "Cutter Guy", "Collections", "Associate Tailors"};
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        ButterKnife.bind(this);
        presenter = new CollectionsPresenterImpl(this);
        currentDate = (String) android.text.format.DateFormat.format("yyyy-MM-dd", new java.util.Date());
        LinearLayoutManager lm = new LinearLayoutManager(Deposit.this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(lm);
        presenter.depositeView("view_diposites", currentDate, view_diposites);

    }

    @OnClick(R.id.card2)
    public void viewDataClick() {
        String date = String.valueOf(date_et.getText());
        presenter.depositeView("view_diposites", date, view_diposites);
    }

    @OnClick(R.id.date_et)
    public void dateWiseClick() {
        DateDialog();
    }

    @OnClick(R.id.back_PO_cmngrp)
    public void backClick() {
        finish();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CollectionsDResponse response) {

    }

    @Override
    public void onInvoiceLoad(CollectionInvoiceResponse response) {

    }

    @Override
    public void onDepositeLoad(DepositeResponse response) {
        if (response.getStatus().equals("success")) {
            depositeData = response.getData();
            adapter = new DepositeAdapter(getApplicationContext(), depositeData);
            recycler_view.setAdapter(adapter);
        }
    }

    @Override
    public void showDialog() {
        trans_bg.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        trans_bg.setVisibility(View.GONE);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    private void DateDialog() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = (year + "-" + month + 1 + "-" + dayOfMonth);
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                        "yyyy-mm-dd");

                Date myDate = null;
                try {
                    myDate = dateFormat.parse(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
                String finalDate = timeFormat.format(myDate);


                date_et.setText(finalDate);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
