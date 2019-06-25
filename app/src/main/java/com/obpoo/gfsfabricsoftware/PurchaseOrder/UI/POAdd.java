package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.AutoFabricAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.POChangedAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.PoAddAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.SpinnerAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.SpinnerArticleAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.SpinnerColorAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.SpinnerVendorAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField_changeD;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsPresenterImpl;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.user.mvp.UserPresenterImpl;
import com.obpoo.gfsfabricsoftware.user.mvp.UserView;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class POAdd extends BaseActivity implements poView, FabricsView, UserView, VendorsView {
    @BindView(R.id.vendor_spin)
    Spinner vendor;
    @BindView(R.id.staff_spin)
    Spinner user;
    @BindView(R.id.cc_email)
    EditText cc_email;

    @BindView(R.id.quantity)
    EditText quantity;
    @BindView(R.id.brandname)
    EditText brandname;
    @BindView(R.id.add_button)
    Button add_button;

    @BindView(R.id.brand)
    EditText brand;
    @BindView(R.id.fabric_spin)
    AutoCompleteTextView fabric_auto;
    @BindView(R.id.occassion_add)
    TextView occassion_add;
    View view;

    int i = 1;
    List<dynamicField> getAllValues = new ArrayList<>();
    JSONArray jsonArray;
    SpinnerAdapter Aadapter, Cadapter;
    @BindView(R.id.addreViews)
    RecyclerView addreViews;
    SpinnerAdapter adapter;
    SpinnerVendorAdapter vendorAdapter_spin;
    SpinnerArticleAdapter articleAdapter_spin;
    SpinnerColorAdapter color_adapter;
    String getSpinArticle, getSpinColor, getSpinVendor, getSpinUser, getFabricName, getFabricImage;

    //    ArrayList<StockDataResponse> stocklist = new ArrayList<>();
//    ArrayList<ColorDetail> colorlist=new ArrayList<>();
    poPresenterImpl presenter;

    FabricsPresenterImpl fabric_presenter;
    private ArrayList<FabricsDetail> fabricList = new ArrayList<>();
    UserPresenterImpl presenter_user;
    ArrayList<UserDetail> userList = new ArrayList<>();
    VendorsPresenterImpl vendor_presenter;
    private ArrayList<VendorsDetail> cartList = new ArrayList<>();
    ArrayList<dynamicField_changeD> addItemList = new ArrayList<>();
    ArrayList<dynamicField_changeD> mergeaddItemList = new ArrayList<>();
    PoAddAdapter POAddadapter = null;
    POChangedAdapter poChangedAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            addItemList = (ArrayList<dynamicField_changeD>) data.getSerializableExtra("getItemList");
            mergeaddItemList.add(new dynamicField_changeD(addItemList.get(0).getFabImage(),
                    addItemList.get(0).getComposition(), addItemList.get(0).getArticle(), addItemList.get(0).getCustomer(),
                    addItemList.get(0).getQty_mtr(), addItemList.get(0).getGty_yard(), addItemList.get(0).getBrand()));
            Log.i("mergeaddItemList", String.valueOf(mergeaddItemList.size()));
            poChangedAdapter = new POChangedAdapter(getApplicationContext(), mergeaddItemList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(POAdd.this);
            addreViews.setLayoutManager(linearLayoutManager);
            addreViews.setAdapter(poChangedAdapter);
            poChangedAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poadd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create Request");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
//        userList= (ArrayList<UserDetail>) getIntent().getSerializableExtra("userSpinner");
//        System.out.println(userList.get(0).getName()+"userName");
//        cartList=(ArrayList<VendorsDetail>)getIntent().getSerializableExtra("vendorSpinner");
//        stocklist=(ArrayList<StockDataResponse>)getIntent().getSerializableExtra("articleSpinner");
//        colorlist=(ArrayList<ColorDetail>)getIntent().getSerializableExtra("colorSpinner");


//        articleAdapter_spin=new SpinnerArticleAdapter(stocklist,this);
//        color_adapter=new SpinnerColorAdapter(colorlist,this);

        Log.i(getIntent().getStringExtra("mediateVIA"), "mediateVIA");
      /*if(getIntent().getStringExtra("mediateVIA").equals("Adapter")){
         addItemList=(ArrayList<dynamicField_changeD>)getIntent().getSerializableExtra("getItemList");
           poChangedAdapter = new POChangedAdapter(getApplicationContext(),addItemList);
           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(POAdd.this);
           addreViews.setLayoutManager(linearLayoutManager);

           addreViews.setAdapter(poChangedAdapter);
           poChangedAdapter.notifyDataSetChanged();
       }*/

        presenter = new poPresenterImpl(this);

        presenter_user = new UserPresenterImpl(this);
        presenter_user.viewAll("view_all");
        vendor_presenter = new VendorsPresenterImpl(this);
        vendor_presenter.viewAll("view_all");

        fabric_presenter = new FabricsPresenterImpl(this);
        fabric_presenter.viewAll("view_all_fabric");

        fabric_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("fabric_auto_articleNo", fabricList.get(position).getArticleno());
                getSpinArticle = fabricList.get(position).getArticleno();
                Log.i("fabricAuto_fabname", fabricList.get(position).getFab_name());
                getFabricName = fabricList.get(position).getFab_name();
                Log.i("fabricAuto_color", fabricList.get(position).getColor_code());
                getSpinColor = fabricList.get(position).getColor_code();
                Log.i("fabricAuto_image", fabricList.get(position).getFab_img());
                getFabricImage = fabricList.get(position).getFab_img();

            }
        });

    }

    @OnClick(R.id.add_button)
    public void onClick() {

        i = 2;
        String brandnamestr = brandname.getText().toString();

        String getQty = quantity.getText().toString();
        String fabricnumber = fabric_auto.getText().toString();

        if (!checkValidFabricNumber(fabricnumber)) {
            Toast.makeText(getApplicationContext(), "Incorrect Fabric Name/number", Toast.LENGTH_SHORT).show();
        } else if (fabricnumber.equals("")) {
            fabric_auto.setError("Enter Fabric number");
        } else if (getQty.length() == 0) {
            quantity.setError("Enter Quantity");
        } else if (checkList()) {
//        getAllValues.add(new com.obpoo.giovanifabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField(getSpinArticle,getSpinColor,getQty));
            Log.e("BrandName--", brandnamestr);
            getAllValues.add(new dynamicField(getSpinArticle, getSpinColor, getQty, getFabricName, getFabricImage, brandnamestr));
        }

        if (i == 2) {
            POAddadapter = new PoAddAdapter(getApplicationContext(), getAllValues);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(POAdd.this);
            addreViews.setLayoutManager(linearLayoutManager);
            addreViews.setAdapter(POAddadapter);
            POAddadapter.notifyDataSetChanged();
            //fabric_auto.setText("");
        } else {
            POAddadapter.notifyDataSetChanged();
        }

    }

    @OnClick(R.id.onSubmit)
    public void onSubmit() {
        JSONArray jsonArray = new JSONArray();
        Toast.makeText(getApplicationContext(), "onSubmit", Toast.LENGTH_SHORT).show();
      /* for(int i =0; i<getAllValues.size();i++){
            JSONObject jsonObject= new JSONObject();
            try{
               jsonObject.put("quantity",getAllValues.get(i).getQty_bean());
               jsonObject.put("art_no",getAllValues.get(i).getArticle_bean());
               jsonObject.put("color_code",getAllValues.get(i).getColor_bean());
               jsonArray.put(jsonObject);

            }
            catch(Exception e){
                Log.i("JSONException",e.getMessage());
            }

        }
        System.out.println("JsonArrayItems"+jsonArray.toString());*/

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < getAllValues.size(); i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("quantity", getAllValues.get(i).getQty_bean());
            hashMap.put("art_no", getAllValues.get(i).getArticle_bean());
            hashMap.put("color_code", getAllValues.get(i).getColor_bean());
            hashMap.put("brand_name", getAllValues.get(i).getBrandname());
            arrayList.add(hashMap);
        }

        System.out.println("HashMapItems" + arrayList);
        ArrayList<HashMap<String, String>> merged_arrayList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < mergeaddItemList.size(); i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("fabImage", mergeaddItemList.get(i).getFabImage());
            hashMap.put("composition", mergeaddItemList.get(i).getComposition());
            hashMap.put("article", mergeaddItemList.get(i).getArticle());
            hashMap.put("customer", mergeaddItemList.get(i).getCustomer());
            hashMap.put("meter", mergeaddItemList.get(i).getQty_mtr());
            hashMap.put("yard", mergeaddItemList.get(i).getGty_yard());
            hashMap.put("brand", mergeaddItemList.get(i).getBrand());
            merged_arrayList.add(hashMap);
        }

        presenter.OnAddPO("po_direct_order", getSpinVendor, getSpinUser,
                cc_email.getText().toString(), brand.getText().toString(), "1", "1", merged_arrayList);

    }

    @OnItemSelected(R.id.vendor_spin)
    public void onSelectVendor(int position) {
        getSpinVendor = cartList.get(position).getVendorID();
        Log.i("getSpinVendor", getSpinVendor);

    }

    @OnItemSelected(R.id.staff_spin)
    public void onSelectUser(int position) {
        getSpinUser = userList.get(position).getId();
        Log.i("getSpinUser", getSpinUser);
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
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {
        Log.i("AddResponsePO", response.getMessage());
        Log.e("AddResponsePO", response.getMessage());
        Intent in = new Intent(POAdd.this, RequestedOrder.class);
        startActivity(in);
        finish();

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

    }

    @Override
    public void onValidationfail(int type) {
        switch (type) {
            case 1:
                cc_email.setError("Enter Email");
                break;

        }

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @OnClick(R.id.onCancel)
    public void onCancel() {
        Intent in = new Intent(POAdd.this, RequestedOrder.class);
        startActivity(in);
        finish();

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(VendorsResponse response) {
        Log.i("Vendor_poADD", response.getMessage());
        cartList = response.getDetail();
        vendorAdapter_spin = new SpinnerVendorAdapter(cartList, this);
        vendor.setAdapter(vendorAdapter_spin);
    }

    @Override
    public void viewUserList(UserResponse response) {
        userList = response.getDetail();
        adapter = new SpinnerAdapter(userList, this);
        user.setAdapter(adapter);

    }

    @Override
    public void onLoad(FabricsResponse response) {
        fabricList = response.getDetail();
        Log.i("FabricForPO", response.getMessage());
        fabric_auto.setThreshold(1);
        AutoFabricAdapter fabricAdapter = new AutoFabricAdapter(this, R.layout.autocompletefabric, R.id.lbl_fabric, fabricList);
        fabric_auto.setAdapter(fabricAdapter);

    }

    public boolean checkList() {
        for (int i = 0; i < getAllValues.size(); i++) {
            if (getAllValues.get(i).getFab_name().equals(getFabricName)) {

                return false;
            }


        }

        return true;
    }

    public boolean checkValidFabricNumber(String fabNumber) {
        Log.e("fabricNumber-", fabNumber);
        boolean flag = true;
        for (int i = 0; i < fabricList.size(); i++) {
            Log.e("fabricNumber-" + i, fabNumber + "fabnumfromlist" + i + "--" + fabricList.get(i).getFab_name());
            if (fabricList.get(i).getFab_name().equals(fabNumber)) {

                flag = true;
                break;
                // Toast.makeText(getApplicationContext(), "Correct Fabric Name/number", Toast.LENGTH_SHORT).show();
                //return  true;
            } else {

                flag = false;
            }


        }

        return flag;
    }

    @OnClick(R.id.occassion_add)
    public void onAddItems() {
        Intent in = new Intent(POAdd.this, AddFabricInPoContract.class);
        in.putExtra("FabricListItems", fabricList);
        startActivityForResult(in, 2);

    }

}