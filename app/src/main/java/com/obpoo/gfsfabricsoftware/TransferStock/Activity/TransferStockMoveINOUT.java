package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.PO_Order;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TransferStockAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_data;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransferStockMoveINOUT extends BaseActivity implements TsView {
    TsPresenterImpl presenter;
    @BindView(R.id.rv_ts_fab)
    RecyclerView rv_ts_fab;
    @BindView(R.id.search_view)
    LinearLayout search_view;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.search_et)
    EditText search_et;
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    @BindView(R.id.tranparent_bg)
    ImageView tranparent_bg;
    String getSelctedMenu;
    TextView finput, tinput, cancel, add;
    String d1, d2;
    private int mYear, mMonth, mDay;
    String fromdate, todate;
    int page_no = 1;
    int page_noFI = 1;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    ArrayList<Ts_data> ts_dataArrayList = new ArrayList<>();
    ArrayList<Ts_data> ts_dataArrayList1 = new ArrayList<>();
    ArrayList<Ts_data> ts_dataArrayListFI = new ArrayList<>();
    TransferStockAdp adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_stock_move_inout);
        getSelctedMenu = getIntent().getStringExtra("getSelectedTransferVal");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getSelctedMenu.equals(AppConstants.tran_stock)) {
            toolbar.setTitle(AppConstants.tran_stock);
        }
        if (getSelctedMenu.equals(AppConstants.tran_stockIn)) {
            toolbar.setTitle(AppConstants.tran_stockIn);
        }

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new TsPresenterImpl(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        fromdate = dateFormat.format(todate1);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        if (getSelctedMenu.equals(AppConstants.tran_stock)) {
            presenter.onTransferParameters("get_documents_with_date_pagn", fromdate, todate, String.valueOf(page_no), "0");
        }
//        if(getSelctedMenu.equals(AppConstants.tran_stockIn)){
//            presenter.onTransferParameters("transfered_stock_documents");
//        }
        adapter = new TransferStockAdp(ts_dataArrayList, TransferStockMoveINOUT.this, getSelctedMenu,progress_bar,tranparent_bg);
        rv_ts_fab.setLayoutManager(lm);
        rv_ts_fab.setAdapter(adapter);

        rv_ts_fab.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                LinearLayoutManager lm = new LinearLayoutManager(TransferStockMoveINOUT.this);
                currentItems = lm.getChildCount();
                totalItems = lm.getItemCount();
                scrollOutItems = lm.findFirstVisibleItemPosition();

                if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                    isScrolling = false;
                    page_no++;
                    presenter.onTransferParameters("get_documents_with_date_pagn", fromdate, todate, String.valueOf(page_no), "0");

                }
            }

        });

        search_et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(TransferStockMoveINOUT.this.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(search_et.getWindowToken(), 0);
                    findItem(search_et.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.search_cancel)
    public void searchCancelClick() {
        search_view.setVisibility(View.VISIBLE);
        search.setVisibility(View.GONE);
        search_et.getText().clear();
        if (ts_dataArrayListFI.isEmpty()) {

        } else {
            ts_dataArrayList.clear();
            ts_dataArrayList.addAll(ts_dataArrayListFI);
            page_no = page_noFI;
            adapter.notifyDataSetChanged();
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(TransferStockMoveINOUT.this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(search_et.getWindowToken(), 0);
    }

    @OnClick(R.id.search_view)
    public void searchViewClick() {
        search_view.setVisibility(View.GONE);
        search.setVisibility(View.VISIBLE);
        search_et.requestFocus();
        search_et.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(TransferStockMoveINOUT.this.INPUT_METHOD_SERVICE);
        imm.showSoftInput(search_et, InputMethodManager.SHOW_FORCED);
    }

    public void findItem(String doc) {
        ts_dataArrayListFI.addAll(ts_dataArrayList);
        page_noFI = page_no;
        page_no = 1;
        ts_dataArrayList.clear();
        presenter.onTransferParameters("get_documents_with_date_pagn", fromdate, todate, String.valueOf(page_no), doc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calender, menu);
        return true;
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
                    Toast.makeText(TransferStockMoveINOUT.this, "Please select to and from dates", Toast.LENGTH_SHORT).show();

                } else {
                    page_no = 1;
                    presenter.onTransferParameters("get_documents_with_date_pagn", fromdate, todate, String.valueOf(page_no), "0");
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

    @Override
    public void onGetPendingOrderIdResponse(PendingOrderRes response) {

    }

    @Override
    public void onGetFabricPendingRes(FabricPendingOIDRes response) {

    }

    @Override
    public void onTranferFabric(TransferResponse response) {

    }

    @Override
    public void onTransferWare(TransferWareWareRes response) {

    }

    @Override
    public void onPassWare(TransferResponse response) {

    }

    @Override
    public void onTransfer(Ts_Response response) {
        if (response.getStatus().equals("success")) {

            ts_dataArrayList1 = response.getData();
            ts_dataArrayList.addAll(ts_dataArrayList1);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onTransferStockOut(TransferResponse response) {

    }

    @Override
    public void onStockDocView(StockDocumentResponse response) {

    }

    @Override
    public void onSelectDocView(DocumentData response) {

    }

    @Override
    public void showDialog() {
        progress_bar.setVisibility(View.VISIBLE);
        tranparent_bg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progress_bar.setVisibility(View.GONE);
        tranparent_bg.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }
}
