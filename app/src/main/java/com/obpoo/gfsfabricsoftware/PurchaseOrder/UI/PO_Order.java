package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ConfirmPOAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TransferStockIn;
import com.obpoo.gfsfabricsoftware.collections.ui.CollectionsDeliveries;
import com.obpoo.gfsfabricsoftware.shelfassignment.ui.Scanning;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PO_Order extends BaseActivity implements PoView {


    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    @BindView(R.id.received_ord)
    LinearLayout received_ord;
    @BindView(R.id.pending_ord)
    LinearLayout pending_ord;
    @BindView(R.id.received_img)
    ImageView received_img;
    @BindView(R.id.pending_img)
    ImageView pending_img;
    @BindView(R.id.received_text)
    TextView received_text;
    @BindView(R.id.pending_text)
    TextView pending_text;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.tranparent_bg)
    ImageView transparent_bg;
    @BindView(R.id.search_view)
    LinearLayout search_view;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.search_et)
    EditText search_et;

    PoPresenterImpl presenter;
    int page_no = 1;
    ConfirmPOAdapter adapter;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String fromdate, todate;
    ArrayList<poDatum> data = new ArrayList<>();
    ArrayList<poDatum> data1 = new ArrayList<>();
    Toolbar toolbar;
    TextView finput, tinput, cancel, add;
    String d1, d2;
    boolean menuStatus = true;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po__order);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Received Order");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new PoPresenterImpl(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PO_Order.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setNestedScrollingEnabled(false);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        fromdate = dateFormat.format(todate1);

        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
        adapter = new ConfirmPOAdapter(PO_Order.this, data, "poorder");
        recycler_view.setAdapter(adapter);
        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (data != null) {
                    filter(editable.toString());
                }

            }
        });

        recycler_view.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PO_Order.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                currentItems = linearLayoutManager.getChildCount();
                totalItems = linearLayoutManager.getItemCount();
                scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();
                if (menuStatus) {
                    if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                        isScrolling = false;
                        page_no++;
                        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
                    }
                }
            }
        });

    }


    @OnClick(R.id.received_ord)
    public void receivedClick() {
        toolbar.setTitle("Received Order");
        data.clear();
        menuStatus = true;
        invalidateOptionsMenu();
        searchCancelClick();
        presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
        received_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue_100), android.graphics.PorterDuff.Mode.SRC_IN);
        received_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue_100));
        pending_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.iron), android.graphics.PorterDuff.Mode.SRC_IN);
        pending_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.iron));

    }

    @OnClick(R.id.pending_ord)
    public void pendingClick() {
        toolbar.setTitle("Pending Order");
        data.clear();
        menuStatus = false;
        invalidateOptionsMenu();
        presenter.viewPOPendingOrder("pending_orders");
        pending_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue_100), android.graphics.PorterDuff.Mode.SRC_IN);
        pending_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue_100));
        received_img.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.iron), android.graphics.PorterDuff.Mode.SRC_IN);
        received_text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.iron));
        searchCancelClick();
    }

    @OnClick(R.id.search_cancel)
    public void searchCancelClick() {
        search_view.setVisibility(View.VISIBLE);
        search.setVisibility(View.GONE);
        search_et.clearFocus();
    }

    @OnClick(R.id.search_view)
    public void searchViewClick() {
        search_view.setVisibility(View.GONE);
        search.setVisibility(View.VISIBLE);
        search_et.requestFocus();
        search_et.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(PO_Order.this.INPUT_METHOD_SERVICE);
        imm.showSoftInput(search_et, InputMethodManager.SHOW_FORCED);
    }

    @Override
    public void onShowViewPO(poPOJO response) {

        if (response.getStatus().equals("success")) {
            data1 = response.getData();
            data.addAll(data1);
            adapter.notifyDataSetChanged();
        }


    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @Override
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void onShowFilter(PoFilterResponse response) {

    }

    @Override
    public void showDialog() {
        progressbar.setVisibility(View.VISIBLE);
        transparent_bg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressbar.setVisibility(View.GONE);
        transparent_bg.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    void filter(String text) {
        ArrayList<poDatum> temp = new ArrayList();
        for (poDatum d : data) {
            if (d.getPo_no().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        adapter.updateList(temp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calender, menu);
        if (menuStatus) {
            menu.getItem(0).setVisible(true);
        } else {
            menu.getItem(0).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.date_range) {
            showADialog();
        }
        return super.onOptionsItemSelected(item);
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

                fromdate = finput.getText().toString();
                todate = tinput.getText().toString();

                if (fromdate.equals("") || todate.equals("") || fromdate.equals("FROM") || todate.equals("TO")) {
                    Toast.makeText(PO_Order.this, "Please select to and from dates", Toast.LENGTH_SHORT).show();

                } else {
                    page_no = 1;
                    presenter.viewPOOrder("view_received_orders_prcs_pagn", fromdate, todate, String.valueOf(page_no));
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
}
