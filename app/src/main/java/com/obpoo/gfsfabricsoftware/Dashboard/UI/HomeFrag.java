package com.obpoo.gfsfabricsoftware.Dashboard.UI;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.obpoo.gfsfabricsoftware.Dashboard.Adapter.Adapter_Dash;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.Data;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.FabricReport;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.IncomeDeposits;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.OrderCount;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.PoList;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateData;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.SaleReport;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFrag extends Fragment implements ReportView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ReportPresenterImpl presenter;
    @BindView(R.id.piechart)
    PieChart pieChart;
    @BindView(R.id.child_layout)
    TableLayout childLayout;
    @BindView(R.id.barchart)
    BarChart barChart;
    Data getData = new Data();
    ArrayList<FabricReport> getFabricReport = new ArrayList<>();
    ArrayList<PoList> getPoList = new ArrayList<>();

    //Income
    @BindView(R.id.totalincome)
    TextView totalIncome;
    @BindView(R.id.thb_in)
    TextView thb_In;
    @BindView(R.id.dollar_in)
    TextView dollar_in;
    @BindView(R.id.month_in)
    TextView month_In;
    @BindView(R.id.month_pend)
    TextView month_Pend;
    @BindView(R.id.month_collect)
    TextView month_Collect;
    @BindView(R.id.month_name)
    TextView month_Name;

    Double getExchange=0.0;

    @BindView(R.id.c_pend)
    TextView c_pend_count;
    @BindView(R.id.processing)
    TextView process_count;
    @BindView(R.id.deliver_count)
    TextView deliver_count;
    @BindView(R.id.return_count)
    TextView return_count;
    @BindView(R.id.dash_recycle)
    RecyclerView dash_recycle;
    String baht ="\u0e3f";


    public HomeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFrag newInstance(String param1, String param2) {
        HomeFrag fragment = new HomeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        presenter=new ReportPresenterImpl(this);
       // presenter.onViewRates("THB");
        presenter.onViewReport("allReport");


        pieChart.setUsePercentValues(true);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onGetReportResponse(DashResponse response) {
        Log.i("ReportResponse",response.getMessage());
        getData=response.getData();
        getFabricReport = getData.getFabricReport();

      ArrayList<Entry> yValues = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<String>();
      for(int i = 0; i<getFabricReport.size();i++){
          yValues.add(new Entry(Float.valueOf(String.valueOf(getFabricReport.get(i).getPercent())),i));
          xVals.add(getFabricReport.get(i).getType());
      }

        PieDataSet dataSet = new PieDataSet(yValues,"FabricResults");
        PieData data = new PieData(xVals,dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.setNoDataText("Please wait Loading data....");
        pieChart.setDescription("");
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(70f);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(3f);
        data.setValueTextColor(Color.TRANSPARENT);
        pieChart.animateXY(1400,1400);


        setCustomLegend();


        // Barchart begin


        ArrayList<SaleReport> getSalesReport = getData.getSaleReport();


        ArrayList<BarEntry> yBValues = new ArrayList<>();
        ArrayList<String> xBVals = new ArrayList<String>();

        for(int k=0;k<getSalesReport.size();k++){
        yBValues.add(new BarEntry(Float.valueOf(getSalesReport.get(k).getIncomeThisMonth()),k));
        xBVals.add(getSalesReport.get(k).getMonthYear());
        }
        BarDataSet barDataSet = new BarDataSet(yBValues,"SalesReport");
        barChart.animateY(5000);
        barChart.setNoDataText("Please wait Loading data....");
        BarData bardata = new BarData(xBVals,barDataSet);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(bardata);

        //Total Income Begin


        Calendar cal =Calendar.getInstance();
        SimpleDateFormat month = new SimpleDateFormat("MMMM");
        String month_name = month.format(cal.getTime());
        month_Name.setText(month_name+" "+"Summary");
        IncomeDeposits incomeDeposits = new IncomeDeposits();
        incomeDeposits=getData.getIncomeDeposits();
        thb_In.setText(baht+String.valueOf(Math.round(Float.parseFloat(incomeDeposits.getTotalIncome()))));
        month_In.setText(baht+String.valueOf(Math.round(Float.parseFloat(incomeDeposits.getIncomeThisMonth())))+"("+"$"+getExchangeValue(incomeDeposits.getIncomeThisMonth())+")");
        month_Pend.setText(baht+String.valueOf(Math.round(Float.parseFloat(incomeDeposits.getPendingThisMonth())))+"("+"$"+getExchangeValue(incomeDeposits.getPendingThisMonth())+")");
        month_Collect.setText(baht+String.valueOf(Math.round(Float.parseFloat(String.valueOf(incomeDeposits.getCollectionThisMonth()))))+"("+"$"+getExchangeValue(String.valueOf(incomeDeposits.getCollectionThisMonth()))+")");
        dollar_in.setText("$"+getExchangeValue(incomeDeposits.getTotalIncome()));


        //begin orderStatus
        List<Integer> c_pend_list = new ArrayList<>();
        List<Integer> process_list = new ArrayList<>();
        List<Integer> delivered_list = new ArrayList<>();
        List<Integer> return_list = new ArrayList<>();
        ArrayList<OrderCount> getOrderCount_list = new ArrayList<>();
        getOrderCount_list=getData.getOrderCounts();
        for(int c=0;c<getOrderCount_list.size();c++){
            switch (getOrderCount_list.get(c).getStatus()){
                case "0":

                    break;
                case "1":
                    c_pend_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "2":
                    process_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "3":
                    process_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "4":
                    process_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "5":
                    process_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "6":
                    process_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "7":
                    delivered_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "8":break;
                case "9":break;
                case "10":
                    return_list.add(Integer.valueOf(getOrderCount_list.get(c).getCount()));
                    break;
                case "11":break;
                case "12":break;

            }
        }

        int cp_sum=0;
        int process_sum=0;
        int deliver_sum=0;
        int return_sum =0;

        for (int cp :c_pend_list){
            cp_sum +=cp;
        }
        c_pend_count.setText(String.valueOf(cp_sum));

        for (int cp :process_list){
            process_sum +=cp;
        }
        process_count.setText(String.valueOf(process_sum));

        for (int cp :delivered_list){
            deliver_sum +=cp;
        }
        deliver_count.setText(String.valueOf(deliver_sum));

        for (int cp :return_list){
            return_sum +=cp;
        }
        return_count.setText(String.valueOf(return_sum));

        // begin POStatus
        getPoList = getData.getPoList();
        Adapter_Dash adapter = new Adapter_Dash(getActivity(),getPoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        dash_recycle.setLayoutManager(linearLayoutManager);
        dash_recycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onGetExchangerate(RateResponse response) {
        Log.i("ExchangeRate",response.getBase());
        RateData rateData =new RateData();
        rateData=response.getRates();
        getExchange=rateData.getUSD();
        Log.i("getExchange",getExchange+"");


    }

    @Override
    public void onGetStockAlert(Response response) {

    }

    @Override
    public void onGetDSCurve(CurveResponse response) {

    }

    @Override
    public void onGetSearchStock(Response response) {

    }

    @Override
    public void onGetPreviledgesStock(PreviledgesResponse response) {

    }

    private void setCustomLegend() {

        for (int j=0; j<getFabricReport.size();j++){
        LayoutInflater inflater = getLayoutInflater();
            TableRow tr =(TableRow)inflater.inflate(R.layout.table_row_legend,childLayout,false);
            childLayout.addView(tr);
            LinearLayout linearlayoutColorContainer =(LinearLayout)tr.getChildAt(0);
            LinearLayout linearLayoutColor =(LinearLayout)linearlayoutColorContainer.getChildAt(0);
            TextView tvLabel =(TextView)tr.getChildAt(1);
            TextView tvAmt =(TextView)tr.getChildAt(2);
            linearLayoutColor.setBackgroundColor(ColorTemplate.VORDIPLOM_COLORS[j]);
            tvLabel.setText(getFabricReport.get(j).getType());
            tvAmt.setText(String.format("%.2f",getFabricReport.get(j).getPercent())+"%");
        }
        pieChart.getLegend().setWordWrapEnabled(true);
        pieChart.getLegend().setEnabled(false);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public String getExchangeValue(String value){
      double result;
      result = Double.parseDouble(value)*getExchange;
     String final_res = String.valueOf(Math.round(Float.parseFloat(String.valueOf(result))));
     return final_res;


    }
}
