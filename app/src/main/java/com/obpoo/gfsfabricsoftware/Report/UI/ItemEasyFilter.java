package com.obpoo.gfsfabricsoftware.Report.UI;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemEasyFilter extends BaseActivity {
    @BindView(R.id.ief_status)
    TextView ief_status;
    @BindView(R.id.ief_from)
    TextView ief_from;
    @BindView(R.id.ief_to)
    TextView ief_to;
    @BindView(R.id.ief_process)
    Button ief_process;
    String getStatus, getStatusID;
    private DatePickerDialog.OnDateSetListener fromdateSetListener, todateSetListener;
    String getFromDate, getToDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_easy_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Filter");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        fromdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                getFromDate = year + "-" + month + "-" + dayOfMonth;
                ief_from.setText(getFromDate);
                Log.i("getFromDate", getFromDate);
            }
        };
        todateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                getToDate = year + "-" + month + "-" + dayOfMonth;
                ief_to.setText(getToDate);
                Log.i("getToDate", getToDate);
            }
        };

    }

    @OnClick(R.id.ief_status)
    public void onStatusClick(View view) {
        final String statusList[] = {"cutting_pending", "qc_pending", "qc_done", "ready", "N/A", "cancel", "return_requested", "request accepted", "All"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Status");
        builder.setItems(statusList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getStatus = statusList[which];
                getStatusID =getStatusID(getStatus);
                ief_status.setText(getStatus);

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }


    public String getStatusID(String getStatus) {
        switch (getStatus) {
            case "cutting_pending":
                return "0";
            case "qc_pending":
                return "2";
            case "qc_done":
                return "3";
            case "ready":
                return "4";
            case "N/A":
                return "5";
            case "cancel":
                return "6";
            case "return_requested":
                return "7";
            case "request accepted":
                return "8";
            case "All":
                return "ALL";
            default:
                return "ALL";

        }
    }
    @OnClick(R.id.ief_from)
    public void onFrom(View view){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(ItemEasyFilter.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, fromdateSetListener, year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @OnClick(R.id.ief_to)
    public void onTo(View view){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(ItemEasyFilter.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, todateSetListener, year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    @OnClick(R.id.ief_process)
    public void onProcess(View view){
        Intent in = new Intent(ItemEasyFilter.this,ItemEasyReport.class);
        in.putExtra("getFromDateIEF",getFromDate);
        in.putExtra("getTodateIEF",getToDate);
        in.putExtra("statusIEF",getStatusID);
        setResult(AppConstants.itemEasyfilter,in);
        finish();
    }


}
