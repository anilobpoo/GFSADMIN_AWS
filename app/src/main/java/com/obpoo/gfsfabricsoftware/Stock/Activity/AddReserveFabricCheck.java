package com.obpoo.gfsfabricsoftware.Stock.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.FSadapter;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.WzsAdapter;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveCheckModel;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchResDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.RequestObjectCustomerAddReserve;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.MVP.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddReserveFabricCheck extends AppCompatActivity implements com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock {
    @BindView(R.id.ar_image_check)
    ImageView ar_image_check;
    @BindView(R.id.ar_fabrics_check)
    TextView ar_fabrics_check;
    @BindView(R.id.ar_bundles_check)
    TextView ar_bundles_check;
    @BindView(R.id.ar_get_cust_check)
    TextView ar_get_cust_check;
    @BindView(R.id.check_ar_view_rv)
    RecyclerView check_ar_view_rv;
    @BindView(R.id.reserve_submit)
    Button reserve_submit;
    StockPresenterImpl stock_presenter;
    WzsAdapter adapter;
    FSadapter fs_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reserve_fabric_check);
        ButterKnife.bind(this);
        ar_fabrics_check.setText(getIntent().getStringExtra("FABNAME_AR"));
        ar_bundles_check.setText(getIntent().getStringExtra("COMPOSITION_AR"));
        ar_get_cust_check.setText(getIntent().getStringExtra("CUSTOMER_NAME_AR"));
        Picasso.with(this).load(AppConstants.FABRIC_IMAGE+getIntent().getStringExtra("FABIMAGE_AR")).into(ar_image_check);


        stock_presenter = new StockPresenterImpl(this);
        stock_presenter.onViewFabricSearch("show_fab_location",getIntent().getStringExtra("FABNAME_AR"));

    }

    @Override
    public void onShowStock(ViewStockResponse response) {

    }

    @Override
    public void onShowNewStock(ViewStockNewResponse response) {

    }

    @Override
    public void onShowActivityLog(ActivityLogResponse response) {

    }

    @Override
    public void onShowFabSearch(FabSearchRes response) {
        Log.i("FabricSearch",response.getMessage());
        ArrayList<FabSearchResDet> fabSearchResDetArrayList = response.getData();
         fs_adapter = new FSadapter(fabSearchResDetArrayList,AddReserveFabricCheck.this,AppConstants.AddReserveFabricCheck);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddReserveFabricCheck.this);
        check_ar_view_rv.setLayoutManager(linearLayoutManager);
        check_ar_view_rv.setAdapter(fs_adapter);



    }

    @Override
    public void onShowCustomerReserve(CustomerResResp response) {

    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {
        Log.i("AddCustomerReserveFinal",response.getMessage());
        if(response.getStatus().equals("success")){


        }

    }

    @OnClick(R.id.reserve_submit)
    public void onReserveSubmit(){
        Log.i("onReserveSubmit","onReserveSubmit");
        ArrayList<AddReserveCheckModel> addReserveCheckModelArrayList = new ArrayList<>();
        addReserveCheckModelArrayList=fs_adapter.addReserveCheckModelArrayList;
        ArrayList<String> getUniqueList = new ArrayList<>();
        ArrayList<String> getRemainList = new ArrayList<>();
        for(int i =0;i<addReserveCheckModelArrayList.size();i++){
            getUniqueList.add(addReserveCheckModelArrayList.get(i).getUniqueCode());
            getRemainList.add(addReserveCheckModelArrayList.get(i).getRemain());
        }
        JSONObject requestObject = new JSONObject();
        try {
            requestObject.put("customer",getIntent().getStringExtra("CUSTOMER_ID_AR"));
            requestObject.put("fab_name",getIntent().getStringExtra("FABNAME_AR"));
            requestObject.put("unicode",getUniqueList);
            requestObject.put("remain",getRemainList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("requestObject",requestObject.toString());


        stock_presenter.onViewCustomerAddReserve("customer_reserve",
                new RequestObjectCustomerAddReserve(getIntent().getStringExtra("CUSTOMER_ID_AR"),
                        getIntent().getStringExtra("FABNAME_AR"),getUniqueList,getRemainList));




    }
}
