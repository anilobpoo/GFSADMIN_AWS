package com.obpoo.gfsfabricsoftware.Dashboard.UI;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveData;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class StockInStockOut extends BaseActivity implements ReportView {
    @BindView(R.id.stock_img)
    CircleImageView image_stock;
    @BindView(R.id.stock_name)
    TextView stock_name;
    @BindView(R.id.stock_composition)
    TextView stock_composition;
    ReportPresenterImpl presenter;
    @BindView(R.id.barchart_stock)
    BarChart barChart;
    @BindView(R.id.spin_year)
    Spinner spin_year;

    ArrayList<String> yearsList = new ArrayList<>();
    Calendar cal = Calendar.getInstance();
    int thisYear = cal.get(Calendar.YEAR);
    int thisMonth = cal.get(Calendar.MONTH);
    String getSelectedYear;
    int selectedTabPosition, qYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_in_stock_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Stock in Stock Out");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        Intent in = getIntent();
        stock_name.setText(in.getStringExtra("FABNAME_STOCK"));
        stock_composition.setText(in.getStringExtra("COMPOSITION_STOCK"));
        Picasso.with(this).load(AppConstants.FABRIC_IMAGE + in.getStringExtra("FABIMG_STOCK")).into(image_stock);
        presenter = new ReportPresenterImpl(this);


        for (int i = thisYear; i >= 2000; i--) {
            yearsList.add(Integer.toString(i));

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yearsList);
        spin_year.setAdapter(adapter);

        spin_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getSelectedYear = parent.getItemAtPosition(position).toString();
                presenter.onViewCurve("ds_curve", "151", getSelectedYear);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_stock);
        tabLayout.setTabTextColors(getResources().getColor(R.color.red_500), getResources().getColor(R.color.green_500));


        TabLayout.Tab QuaterlyTab = tabLayout.newTab();
        QuaterlyTab.setText("Quaterly");
        tabLayout.addTab(QuaterlyTab);

        TabLayout.Tab HalfTab = tabLayout.newTab();
        HalfTab.setText("Half Year");
        tabLayout.addTab(HalfTab);

        TabLayout.Tab YearlyTab = tabLayout.newTab();
        YearlyTab.setText("Yearly");
        tabLayout.addTab(YearlyTab);

        TabLayout.Tab Year3Tab = tabLayout.newTab();
        Year3Tab.setText("3 Year");
        tabLayout.addTab(Year3Tab);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        tabLayout.getTabAt(2).select();
                    }
                }, 100);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                selectedTabPosition = tab.getPosition();
                switch (selectedTabPosition) {
                    case 0:
                        spin_year.setEnabled(false);
                        Toast.makeText(getApplicationContext(), thisMonth + "", Toast.LENGTH_SHORT).show();
                        presenter.onViewCurve("ds_curve", "151", String.valueOf(thisYear));
                        break;
                    case 1:
                        spin_year.setEnabled(false);
                        presenter.onViewCurve("ds_curve", "151", String.valueOf(thisYear));
                        break;
                    case 2:
                        spin_year.setEnabled(true);
                        presenter.onViewCurve("ds_curve", "151", String.valueOf(thisYear));
                        break;
                    case 3:
                        spin_year.setEnabled(false);
                        presenter.onViewCurve("ds_curve", "151", String.valueOf(thisYear));
                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private String getMonth(Calendar cal) {
        int qMonth = cal.get(Calendar.MONTH);
        //  Log.i("QuarterMonthInt", qMonth + "");
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        //Log.i("QuarterMonthString", month_name);
        qYear = cal.get(Calendar.YEAR);
        //Log.i("QuarterYear", qYear + "");
        String finalVal = month_name + " " + String.valueOf(qYear);
        return finalVal;

    }

    @Override
    public void onGetReportResponse(DashResponse response) {

    }

    @Override
    public void onGetExchangerate(RateResponse response) {

    }

    @Override
    public void onGetStockAlert(Response response) {

    }

    @Override
    public void onGetDSCurve(CurveResponse response) {
        Log.i("curveMEssage", response.getMessage());
        ArrayList<CurveData> curveDatalist = new ArrayList<>();
        curveDatalist = response.getData();

        ArrayList<BarEntry> yB1Values = new ArrayList<>();
        ArrayList<BarEntry> yB2Values = new ArrayList<>();
        ArrayList<String> xBVals = new ArrayList<String>();


        // for yearly
        if (selectedTabPosition == 2) {

            yB1Values = new ArrayList<>();
            yB2Values = new ArrayList<>();
            xBVals = new ArrayList<String>();
            for (int i = 0; i < curveDatalist.size(); i++) {
                if (curveDatalist.get(i).getMonthYear().contains(getSelectedYear)) {

                    yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                    yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                    xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(getSelectedYear, ""));
                }
            }
        }
        // for Quaterly
        if (selectedTabPosition == 0) {

            yB1Values = new ArrayList<>();
            yB2Values = new ArrayList<>();
            xBVals = new ArrayList<String>();

            for (int i = 0; i < curveDatalist.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        cal = Calendar.getInstance();
                        String showVal = getMonth(cal);

                        if (curveDatalist.get(i).getMonthYear().contains(showVal)) {
                            Log.i("ShowVal", showVal);
                            yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                            yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                            xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(String.valueOf(qYear), ""));
                        }
                    } else {
                        cal = Calendar.getInstance();
                        cal.add(Calendar.MONTH, -j);
                        String showVal = getMonth(cal);

                        if (curveDatalist.get(i).getMonthYear().contains(showVal)) {
                            Log.i("ShowVal", showVal);
                            yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                            yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                            xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(String.valueOf(qYear), ""));
                        }

                    }
                }
            }


        }

        // for HalfYear
        if (selectedTabPosition == 1) {
            yB1Values = new ArrayList<>();
            yB2Values = new ArrayList<>();
            xBVals = new ArrayList<String>();

            for (int i = 0; i < curveDatalist.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (j == 0) {
                        cal = Calendar.getInstance();
                        String showVal = getMonth(cal);

                        if (curveDatalist.get(i).getMonthYear().contains(showVal)) {
                            Log.i("ShowVal", showVal);
                            yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                            yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                            xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(String.valueOf(qYear), ""));
                        }
                    } else {
                        cal = Calendar.getInstance();
                        cal.add(Calendar.MONTH, -j);
                        String showVal = getMonth(cal);

                        if (curveDatalist.get(i).getMonthYear().contains(showVal)) {
                            Log.i("ShowVal", showVal);
                            yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                            yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                            xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(String.valueOf(qYear), ""));
                        }

                    }
                }
            }


        }

        // for 3Years
        if (selectedTabPosition == 3) {
            yB1Values = new ArrayList<>();
            yB2Values = new ArrayList<>();
            xBVals = new ArrayList<String>();
            for (int i = 0; i < curveDatalist.size(); i++) {

                yB1Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockIn()), i));
                yB2Values.add(new BarEntry(Float.valueOf(curveDatalist.get(i).getStockOut()), i));
                xBVals.add(curveDatalist.get(i).getMonthYear().replaceAll(getSelectedYear, ""));

            }

        }


        BarDataSet barDataSet1 = new BarDataSet(yB1Values, "StockIn");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(yB2Values, "StockOut");
        barDataSet2.setColors(ColorTemplate.VORDIPLOM_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

        BarData barData = new BarData(xBVals, dataSets);
        barChart.setData(barData);
        barChart.invalidate();
        barChart.animateY(800);


    }

    @Override
    public void onGetSearchStock(Response response) {


    }

    @Override
    public void onGetPreviledgesStock(PreviledgesResponse response) {

    }


}
