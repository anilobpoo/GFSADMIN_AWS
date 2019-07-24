package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.PendingFabricsAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TransferWareWareAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.CheckModel;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDdetail;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderDetails;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareDet;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseDetail;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehousePresenterImpl;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehouseView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class Ts_Mainactivity extends BaseActivity implements TsView, CustomersView,WarehouseView {
    @BindView(R.id.ts_pending)
    Spinner ts_pending;
    @BindView(R.id.ts_from)
    Spinner ts_from;
    @BindView(R.id.ts_to)
    Spinner ts_to;
    @BindView(R.id.ts_rv)
    RecyclerView ts_rv;
    @BindView(R.id.ts_transfer)
    Button ts_transfer;
    @BindView(R.id.card_from_ts)
    CardView card_from_ts;
    @BindView(R.id.card_to_ts)
    CardView card_to_ts;
    @BindView(R.id.text_from)
    TextView text_from;
    @BindView(R.id.text_to)
    TextView text_to;
    String admin_id;


    TsPresenterImpl presenter;
    CustomersPresenterImpl customer_presenter;
    WarehousePresenterImpl warehousePresenter;
    ArrayList<PendingOrderDetails> pendingOrderDetailsArrayList;
    private ArrayList<CustomersDetail> customer_list = new ArrayList<>();
    private ArrayList<WarehouseDetail> warehouseList=new ArrayList<>();
    PendingFabricsAdp adapter;
    String customer_id_selected, group_id, discount, address, creditTime;
    int customer_selected_position;
    String getSelectedTransfer;
    String spinner_selected_wareHouse_id;
    TransferWareWareAdp WWadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts__mainactivity);
        getSelectedTransfer = getIntent().getStringExtra("getSelectedTransferVal");
        Log.i("getSelectedTransferVal",getSelectedTransfer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSelectedTransfer.equals(AppConstants.tran_cust)){
            toolbar.setTitle(AppConstants.tran_cust);
        }
        if(getSelectedTransfer.equals(AppConstants.tran_ware)){
            toolbar.setTitle(AppConstants.tran_ware);
        }
        if(getSelectedTransfer.equals(AppConstants.ware_ware)){
            toolbar.setTitle(AppConstants.ware_ware);
        }
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        ts_to.setEnabled(false);


        presenter = new TsPresenterImpl(this);
        customer_presenter = new CustomersPresenterImpl(this);
        warehousePresenter= new WarehousePresenterImpl(this);
        presenter.onGetPendingOrderId("view_all");                            // for Pending POID's
    }

    @Override
    public void onGetPendingOrderIdResponse(PendingOrderRes response) {

        Log.i("PendingOrderResponse", response.getMessage());
        pendingOrderDetailsArrayList = response.getData();

        ArrayList<PendingOrderDetails> pendingOrderDetailsArrayList_select = new ArrayList<>();
        pendingOrderDetailsArrayList_select.add(new PendingOrderDetails(AppConstants.select_poid));
        pendingOrderDetailsArrayList_select.addAll(pendingOrderDetailsArrayList);
        ArrayAdapter<PendingOrderDetails> spinnerAdapter = new ArrayAdapter<PendingOrderDetails>(getApplicationContext(), R.layout.spinner_text, pendingOrderDetailsArrayList_select);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ts_pending.setAdapter(spinnerAdapter);

    }

    @Override
    public void onGetFabricPendingRes(FabricPendingOIDRes response) {
        Log.i("FabPending", response.getMessage());

        if (response.getMessage().equals("No Fabrics Requested OR Received ON ")) {
            ts_rv.setVisibility(View.GONE);
            ts_from.setVisibility(View.GONE);
            ts_to.setVisibility(View.GONE);
            ts_transfer.setVisibility(View.GONE);
            text_from.setVisibility(View.GONE);
            text_to.setVisibility(View.GONE);
        } else {
            ts_rv.setVisibility(View.VISIBLE);
            ts_from.setVisibility(View.VISIBLE);
            ts_to.setVisibility(View.VISIBLE);
            ts_transfer.setVisibility(View.VISIBLE);
            text_from.setVisibility(View.VISIBLE);
            text_to.setVisibility(View.VISIBLE);

            ArrayList<FabricPendingOIDdetail> get_fabricPendingDet = response.getData();

            Log.i("BeforeSet", get_fabricPendingDet.size() + "");


            adapter = new PendingFabricsAdp(get_fabricPendingDet, Ts_Mainactivity.this,ts_to,ts_transfer,getSelectedTransfer);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Ts_Mainactivity.this);
            ts_rv.setLayoutManager(linearLayoutManager);
            ts_rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            Set set = new TreeSet(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (((FabricPendingOIDdetail) o1).getVendor().equalsIgnoreCase(((FabricPendingOIDdetail) o2).getVendor())) {
                        return 0;
                    }
                    return 1;
                }
            });
            set.addAll(get_fabricPendingDet);
            final ArrayList newList = new ArrayList(set);


            ArrayAdapter<FabricPendingOIDdetail> spinnerAdapter = new ArrayAdapter<FabricPendingOIDdetail>(getApplicationContext(), R.layout.spinner_text, newList);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ts_from.setAdapter(spinnerAdapter);
            admin_id = PreferenceConnector.readString(this, getString(R.string.admin_id), "");

            if(getSelectedTransfer.equals(AppConstants.tran_cust)){
                customer_presenter.viewAll("view_all", admin_id);
            }
            if(getSelectedTransfer.equals(AppConstants.tran_ware)){
                warehousePresenter.viewAll("view_all");
            }


        }


    }

    @Override
    public void onTranferFabric(TransferResponse response) {
        if(response.getStatus().equals("success")){
            ts_rv.setVisibility(View.GONE);
            ts_from.setVisibility(View.GONE);
            ts_to.setVisibility(View.GONE);
            ts_transfer.setVisibility(View.GONE);
            text_from.setVisibility(View.GONE);
            text_to.setVisibility(View.GONE);

            Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onTransferWare(TransferWareWareRes response) {
        if (response.getMessage().equals("No Fabrics Requested OR Received ON ")) {
            ts_rv.setVisibility(View.GONE);
            ts_from.setVisibility(View.GONE);
            ts_to.setVisibility(View.GONE);
            ts_transfer.setVisibility(View.GONE);
            text_from.setVisibility(View.GONE);
            text_to.setVisibility(View.GONE);
        }else {
            ts_rv.setVisibility(View.VISIBLE);
            ts_from.setVisibility(View.VISIBLE);
            ts_to.setVisibility(View.VISIBLE);
            ts_transfer.setVisibility(View.VISIBLE);
            text_from.setVisibility(View.VISIBLE);
            text_to.setVisibility(View.VISIBLE);

            ArrayList<TransferWareWareDet> get_fabricPendingWareWareDet = response.getData();

             WWadapter = new TransferWareWareAdp(get_fabricPendingWareWareDet, Ts_Mainactivity.this,ts_to,ts_transfer,getSelectedTransfer);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Ts_Mainactivity.this);
            ts_rv.setLayoutManager(linearLayoutManager);
            ts_rv.setAdapter(WWadapter);
            WWadapter.notifyDataSetChanged();



            // before Adapter

            Set set = new TreeSet(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (((TransferWareWareDet) o1).getWarehouseName().equalsIgnoreCase(((TransferWareWareDet) o2).getWarehouseName())) {
                        return 0;
                    }
                    return 1;
                }
            });
            set.addAll(get_fabricPendingWareWareDet);
            final ArrayList newList = new ArrayList(set);

            ArrayAdapter<TransferWareWareDet> spinnerAdapter = new ArrayAdapter<TransferWareWareDet>(getApplicationContext(), R.layout.spinner_text, newList);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ts_from.setAdapter(spinnerAdapter);

            if (getSelectedTransfer.equals(AppConstants.ware_ware)) {
                warehousePresenter.viewAll("view_all");
            }

        }


    }

    @Override
    public void onPassWare(TransferResponse response) {
        Log.i("onpassWare",response.getMessage());
        if(response.getStatus().equals("success")){
            ts_rv.setVisibility(View.GONE);
            ts_from.setVisibility(View.GONE);
            ts_to.setVisibility(View.GONE);
            ts_transfer.setVisibility(View.GONE);
            text_from.setVisibility(View.GONE);
            text_to.setVisibility(View.GONE);
        }

    }

    @Override
    public void onTransfer(Ts_Response response) {

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

    @OnItemSelected(R.id.ts_pending)
    public void onPendingSelected(int position) {
        String selectedPendingOid = ts_pending.getItemAtPosition(position).toString();
        if (selectedPendingOid.equals(AppConstants.select_poid)) {
            ts_rv.setVisibility(View.GONE);
            ts_from.setVisibility(View.GONE);
            ts_to.setVisibility(View.GONE);
            ts_transfer.setVisibility(View.GONE);
            text_from.setVisibility(View.GONE);
            text_to.setVisibility(View.GONE);

        } else {

            if(getSelectedTransfer.equals(AppConstants.tran_cust) || getSelectedTransfer.equals(AppConstants.tran_ware)){
                presenter.onGetFabricPendingOID("view_fabrics", selectedPendingOid);
            }

            if(getSelectedTransfer.equals(AppConstants.ware_ware)){
                presenter.onTransferWare_Ware("view_warehouse_fabrics",selectedPendingOid);

            }


        }


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
    public void onLoad(WarehouseResponse response) {
        warehouseList = response.getDetail();
        ArrayAdapter<WarehouseDetail> spinnerAdapter = new ArrayAdapter<WarehouseDetail>(getApplicationContext(), R.layout.spinner_text, warehouseList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ts_to.setAdapter(spinnerAdapter);

    }

    @Override
    public void onLoad(CustomersResponse response) {
        customer_list = response.getDetail();
        ArrayAdapter<CustomersDetail> spinnerAdapter = new ArrayAdapter<CustomersDetail>(getApplicationContext(), R.layout.spinner_text, customer_list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ts_to.setAdapter(spinnerAdapter);

    }

    @OnClick(R.id.ts_transfer)
    public void onClick() {

        if(getSelectedTransfer.equals(AppConstants.tran_cust)){
            ArrayList<CheckModel> getCheckedList = adapter.checkModelArrayList;
            ArrayList<String> getAll_id = new ArrayList<>();
            ArrayList<String> getcQTY = new ArrayList<>();
            String vatAmount, payableAmount;
            Double order_total = 0.0;
            ArrayList<HashMap<String, String>> hashItems = new ArrayList<>();

            for (int i = 0; i < getCheckedList.size(); i++) {
                HashMap<String,String> hashMap = new HashMap<>();
                getAll_id.add(getCheckedList.get(i).getId());
                getcQTY.add(getCheckedList.get(i).getcQty());
                order_total = order_total + (Double.parseDouble(getCheckedList.get(i).getQty_final()) * Double.parseDouble(getCheckedList.get(i).getSell_pr_mtr()));
                hashMap.put("item_id",getCheckedList.get(i).getFab_id());
                hashMap.put("quantity",getCheckedList.get(i).getcQty());
                hashMap.put("actual_price",getCheckedList.get(i).getSell_pr_mtr());
                hashMap.put("fab_name",getCheckedList.get(i).getFab_name());
                hashMap.put("qty_type","meter");
                hashMap.put("subtotal",String.valueOf((Double.parseDouble(getCheckedList.get(i).getQty_final()) * Double.parseDouble(getCheckedList.get(i).getSell_pr_mtr()))));
                hashItems.add(hashMap);


            }
            Double getDis = (Double.parseDouble(customer_list.get(customer_selected_position).getDiscountPer()) * order_total) / 100;
            Double discountedPrice = order_total - getDis;
            vatAmount = String.valueOf(0.07 * discountedPrice);
            payableAmount = String.valueOf(Double.parseDouble(vatAmount) + discountedPrice);


            presenter.onTransfer(getAll_id,getcQTY,"transfer_to_customer",customer_id_selected,group_id,discount,
                    address,creditTime,"1","cod","pickup Guy","Invoice",
                    String.valueOf(order_total),admin_id,vatAmount,payableAmount,hashItems);


        }
        if(getSelectedTransfer.equals(AppConstants.tran_ware)){
            ArrayList<CheckModel> getCheckedList = adapter.checkModelArrayList;
            ArrayList<String> getAll_id = new ArrayList<>();
            for (int i = 0; i < getCheckedList.size(); i++) {
                getAll_id.add(getCheckedList.get(i).getId());
            }

          presenter.onTransferWare(getAll_id,spinner_selected_wareHouse_id,"transfer_fabrics");


        }

        if(getSelectedTransfer.equals(AppConstants.ware_ware)){
            ArrayList<CheckModel> getCheckedList = WWadapter.checkModelArrayList;
            Log.i(spinner_selected_wareHouse_id+getCheckedList.size(),"passParameters");
            presenter.onPassWare_ware(spinner_selected_wareHouse_id,WWadapter.fabId_pass,"transfer_ware_ware");

        }

    }

    @OnItemSelected(R.id.ts_to)
    public void onSelectTo(int position) {

        if(getSelectedTransfer.equals(AppConstants.tran_cust)){
            customer_selected_position = position;
            customer_id_selected = customer_list.get(position).getId();
            group_id = customer_list.get(position).getCustomerGroup();
            discount = customer_list.get(position).getDiscountPer();
            address = customer_list.get(position).getAddress();
            creditTime = customer_list.get(position).getCreditTime();
        }
        if(getSelectedTransfer.equals(AppConstants.tran_ware)|| getSelectedTransfer.equals(AppConstants.ware_ware)){
            spinner_selected_wareHouse_id= warehouseList.get(position).getId();

        }
    }
}
