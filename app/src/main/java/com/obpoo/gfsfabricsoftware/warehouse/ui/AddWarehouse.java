package com.obpoo.gfsfabricsoftware.warehouse.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopDetail;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopPresenterImpl;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehousePresenterImpl;
import com.obpoo.gfsfabricsoftware.warehouse.mvp.WarehouseView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddWarehouse extends BaseActivity implements WarehouseView,ShopView {

    NetworkDetection networkDetection;
    @BindView(R.id.fullName)
    EditText fullName;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.locality) EditText locality;
    @BindView(R.id.wno) EditText wno;
    @BindView(R.id.availbile) EditText availbile;
    @BindView(R.id.allow) EditText allow;
    @BindView(R.id.shop) EditText shop;
    @BindView(R.id.options) ImageView options;
    @BindView(R.id.allowoptions) ImageView allowoptions;
    @BindView(R.id.aoptions) ImageView aoptions;
    @BindView(R.id.submit)
    Button submit;
    List<String> shopList;
    JSONArray shopArray;
    CharSequence[] shops;
    String shopId;
    String can="0";
    WarehousePresenterImpl presenter;
    ShopPresenterImpl shoppresenter;
    ArrayList<ShopDetail> shopLists=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_warehouse);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Warehouse");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new WarehousePresenterImpl(this);
        shoppresenter = new ShopPresenterImpl(this);
        shopList=new ArrayList<>();
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopList.clear();
                shoppresenter.viewAll("view_all");
            }
        });

        allowoptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allow();
            }
        });

        aoptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            available();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname=fullName.getText().toString().trim();
                String add=address.getText().toString().trim();
                String city=locality.getText().toString().trim();
                String shops=shop.getText().toString().trim();
                String no=wno.getText().toString().trim();
                String allows=allow.getText().toString().trim();
                String av=availbile.getText().toString().trim();

                if (fullname.isEmpty())
                {
                    fullName.setError("Required");
                    fullName.requestFocus();
                    return;
                }

                if (shops.isEmpty())
                {
                    shop.setError("Required");
                    shop.requestFocus();
                    return;
                }

                if (no.isEmpty())
                {
                    wno.setError("Required");
                    wno.requestFocus();
                    return;
                }
                if (allows.isEmpty())
                {
                    allow.setError("Required");
                    allow.requestFocus();
                    return;
                }

                if (city.isEmpty())
                {
                    locality.setError("Required");
                    locality.requestFocus();
                    return;
                }

                if (add.isEmpty())
                {
                    address.setError("Required");
                    address.requestFocus();
                    return;
                }


                if (av.isEmpty())
                {
                    availbile.setError("Required");
                    availbile.requestFocus();
                    return;
                }



                presenter.add("add_warehouse",fullname,no,can,city,add,av,shopId);

            }
        });
    }



    public void shops()
    {

        shops = shopList.toArray(new String[shopList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Shop");
        dialogBuilder.setItems(shops, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = shops[item].toString();
                shopId=getShopId(item);
                shop.setText(selectedText);
                Log.e("id",shopId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getShopId(int position){
        String id="";
        try {
            id=shopLists.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void allow()
    {
        List<String> items = new ArrayList<String>();
        items.add("Allow to sell part of roll");
        items.add("Not Allow to sell part of roll");

        final CharSequence[] Items = items.toArray(new String[items.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setItems(Items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Items[item].toString();
                allow.setText(selectedText);
                if (selectedText.equals("Allow to sell part of roll"))
                {
                    can="1";
                }else
                    can="0";


            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    public void available()
    {
        List<String> items = new ArrayList<String>();
        items.add("Available");
        items.add("In 30 Days");
        items.add("Do Not show in the web");

        final CharSequence[] Items = items.toArray(new String[items.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setItems(Items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Items[item].toString();
                availbile.setText(selectedText);


            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ShopResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            shopLists=response.getDetail();
            for (int i = 0; i < shopLists.size(); i++) {
                String name=shopLists.get(i).getName();
                shopList.add(name);
            }
            shops();

        }else
        {
            hideDialog();
            showError(response.toString());
        }
    }

    @Override
    public void onLoad(WarehouseResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {

            closeProgressbar();
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }else
        {
            closeProgressbar();
            showError(response.toString());
        }
    }

    @Override
    public void showDialog() {
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
