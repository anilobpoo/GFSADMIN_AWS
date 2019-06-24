package com.obpoo.gfsfabricsoftware.Stock.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchResDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabricSearchStock;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.StockInDetails;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockDetails;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.MVP.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfDetail;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;
import com.obpoo.gfsfabricsoftware.shelf.mvp.ShelfPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelf.mvp.ShelfView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseDetail;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehousePresenterImpl;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehouseView;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneDetail;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;
import com.obpoo.gfsfabricsoftware.zone.mvp.ZonePresenterImpl;
import com.obpoo.gfsfabricsoftware.zone.mvp.ZoneView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class ViewStock extends AppCompatActivity implements WarehouseView,ZoneView,ShelfView, com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock {
    WarehousePresenterImpl presenter;
    ZonePresenterImpl zone_presenter;
    ShelfPresenterImpl shelf_presenter;
    StockPresenterImpl stock_presenter;
    @BindView(R.id.ware_fabric)
    Spinner ware_fabric;
    @BindView(R.id.zone_fabric)
    Spinner zone_fabric;
    @BindView(R.id.shelve_fabric)
    Spinner shelve_fabric;
    @BindView(R.id.viewstock)
    Button viewstock;
    @BindView(R.id.search_fabric)
    ImageView search_fabric;
    @BindView(R.id.fabric_s)
    EditText fabric_s;
    ArrayList<WarehouseDetail> warehouseDetailArrayList;
    ArrayList<WarehouseDetail> warehouseDetailArrayList1;
    ArrayList<ZoneDetail> zoneDetailArrayList;
    ArrayList<ZoneDetail> zoneDetailArrayList1;
    ArrayList<ShelfDetail> shelfDetailArrayList;
    ArrayList<ShelfDetail> shelfDetailArrayList1;
    String selectedWareValue,wareId;
    String selectedZoneValue,zoneId;
    String selectedShelveValue,shelveId,shelveUnqSC;
    String page_no = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stock);
        ButterKnife.bind(this);
        presenter = new WarehousePresenterImpl(this);
        presenter.viewAll("view_all");
        stock_presenter = new StockPresenterImpl(this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ShelfResponse response) {
        Log.i("shelf_response",response.getMessage());
        shelfDetailArrayList1= new ArrayList<>();
        shelfDetailArrayList1.add(new ShelfDetail("","","",AppConstants.select_shelve,"",""));

        shelfDetailArrayList = response.getDetail();
        shelfDetailArrayList1.addAll(shelfDetailArrayList);

        ArrayAdapter<ShelfDetail>  spinnerAdapter = new ArrayAdapter<ShelfDetail>(getApplicationContext(),R.layout.spinner_text,shelfDetailArrayList1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shelve_fabric.setAdapter(spinnerAdapter);

    }

    @Override
    public void onLoad(ZoneResponse response) {
        Log.i("ZoneResponse",response.getMessage());
        zoneDetailArrayList = response.getDetail();
        ArrayList<String> getZone = new ArrayList<>();
        getZone.add(AppConstants.select_zone);
        for(int i = 0; i<zoneDetailArrayList.size();i++){
            getZone.add("Zone - "+(i+1) );
        }
        ArrayAdapter<String>  spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text,getZone);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zone_fabric.setAdapter(spinnerAdapter);

    }

    @Override
    public void onLoad(WarehouseResponse response) {

        warehouseDetailArrayList1= new ArrayList<WarehouseDetail>();
        warehouseDetailArrayList1.add(new WarehouseDetail("0","","",AppConstants.select_ware,
                "","","","","","",
                "","",""));

        warehouseDetailArrayList= response.getDetail();
        warehouseDetailArrayList1.addAll(warehouseDetailArrayList);

        ArrayAdapter<WarehouseDetail>  spinnerAdapter = new ArrayAdapter<WarehouseDetail>(getApplicationContext(),R.layout.spinner_text,warehouseDetailArrayList1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ware_fabric.setAdapter(spinnerAdapter);

    }

    @OnItemSelected(R.id.ware_fabric)
    public void OnWareSelected(int position){
        //Toast.makeText(this, warehouseDetailArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();
         selectedWareValue   = ware_fabric.getItemAtPosition(position).toString();

        if(selectedWareValue.equals(AppConstants.select_ware)){

            ArrayAdapter<String>  spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text,getResources().getStringArray(R.array.selectZone));
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            zone_fabric.setAdapter(spinnerAdapter);
        }
        else{
            zone_presenter=new ZonePresenterImpl(this);
            wareId=warehouseDetailArrayList1.get(position).getId();
            zone_presenter.viewAll("view_all",warehouseDetailArrayList1.get(position).getId());
        }

    }
    @OnItemSelected(R.id.zone_fabric)
    public void onZoneSelected(int position){
         selectedZoneValue = zone_fabric.getItemAtPosition(position).toString();
        if(selectedZoneValue.equals(AppConstants.select_zone)){
            ArrayAdapter<String>  spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text,getResources().getStringArray(R.array.selectShelf));
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            shelve_fabric.setAdapter(spinnerAdapter);
        }
        else{
            shelf_presenter= new ShelfPresenterImpl(this);
            zoneId=zoneDetailArrayList.get(position-1).getId();
            shelf_presenter.viewShelf("view_shelves",zoneDetailArrayList.get(position-1).getId());
        }

    }
    @OnItemSelected(R.id.shelve_fabric)
    public void onShelveSelected(int position){
        selectedShelveValue = shelve_fabric.getItemAtPosition(position).toString();
        if(selectedShelveValue.equals(AppConstants.select_shelve)){

        }
        else{
            shelveId=shelfDetailArrayList1.get(position).getId();
            shelveUnqSC=shelfDetailArrayList1.get(position).getUnq_scan_code();
        }
    }

    @OnClick(R.id.viewstock)
    public void onViewStock(){

        if(!selectedWareValue.equals(AppConstants.select_ware)&& selectedZoneValue.equals(AppConstants.select_zone)
                && selectedShelveValue.equals(AppConstants.select_shelve) ){

            stock_presenter.onViewStock("view_by_zone_shelf",wareId,AppConstants.select_ware);
        }
        if(!selectedWareValue.equals(AppConstants.select_ware)&& !selectedZoneValue.equals(AppConstants.select_zone)
                && selectedShelveValue.equals(AppConstants.select_shelve) ){
            stock_presenter.onViewStock("view_by_zone_shelf",zoneId,AppConstants.select_zone);

        }
        if(!selectedWareValue.equals(AppConstants.select_ware)&& !selectedZoneValue.equals(AppConstants.select_zone)
                && !selectedShelveValue.equals(AppConstants.select_shelve) ){
            stock_presenter.onViewNewStock("view_by_shelf_pagn",shelveUnqSC,page_no);
        }

    }

    @Override
    public void onShowStock(ViewStockResponse response) {
        Log.i("ViewStockResponse",response.getMessage());
        ArrayList<ViewStockDetails> viewStockDetailsArrayList = response.getData();
        Intent in = new Intent(ViewStock.this,ViewStockWZS.class);
        in.putExtra("ViewStockDetailsWZS",viewStockDetailsArrayList);
        in.putExtra("ViewStockDetailsKEY","ViewStockDetailsWZS");
        in.putExtra("ViewStockItmKEY","warezone");

        startActivity(in);
        finish();

    }

    @Override
    public void onShowNewStock(ViewStockNewResponse response) {
        ArrayList<StockInDetails> viewStockDetailsArrayList = response.getData();
        Intent in = new Intent(ViewStock.this,ViewStockWZS.class);
        in.putExtra("ViewStockDetailsWZS",viewStockDetailsArrayList);
        in.putExtra("shelveUnqSC",shelveUnqSC);
        in.putExtra("ViewStockDetailsKEY","ViewStockDetailsWZS");
        in.putExtra("ViewStockItmKEY","shelve");
        startActivity(in);
        finish();
    }

    @Override
    public void onShowActivityLog(ActivityLogResponse response) {

    }

    @Override
    public void onShowFabSearch(FabSearchRes response) {
        Log.i("FabricSearch",response.getMessage());
        ArrayList<FabSearchResDet> fabSearchResDetArrayList = response.getData();
        ArrayList<FabricSearchStock> fabricSearchStockArrayList = fabSearchResDetArrayList.get(0).getStock();

        Intent in = new Intent(ViewStock.this,ViewStockWZS.class);
        in.putExtra("ViewStockDetailsWZS",fabSearchResDetArrayList);
        in.putExtra("ViewStockDetailsKEY","ViewStockDetailsFS");
        startActivity(in);
        finish();


    }

    @Override
    public void onShowCustomerReserve(CustomerResResp response) {

    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }

    @OnClick(R.id.search_fabric)
    public void onSearchFabric(){
        stock_presenter.onViewFabricSearch("show_fab_location",fabric_s.getText().toString().trim());

    }
}
