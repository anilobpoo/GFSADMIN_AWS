package com.obpoo.gfsfabricsoftware.shop.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxDetail;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxPresenterImpl;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxView;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopDetail;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopPresenterImpl;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateShop extends BaseActivity implements ShopView,MinMaxView {

    @BindView(R.id.name) EditText name;
    @BindView(R.id.location) EditText location;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.type) EditText minmax;
    @BindView(R.id.submit) Button add;
    @BindView(R.id.options)
    ImageView options;
    NetworkDetection networkDetection;
    List<String> typeList;
    JSONArray typeArray;
    CharSequence[] types;
    String typeId,id;
    ShopPresenterImpl presenter;
    MinMaxPresenterImpl minMaxPresenter;
    ArrayList<MinMaxDetail> list=new ArrayList<>();
    ArrayList<ShopDetail> shopDetailArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Edit Shop");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new ShopPresenterImpl(this);
        minMaxPresenter = new MinMaxPresenterImpl(this);
        typeList=new ArrayList<>();
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                typeList.clear();
                minMaxPresenter.viewAll("viewAllMinMax");
            }
        });

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        presenter.getone("view_one",id,"getone");
        add.setText("Update Shop");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shopName=name.getText().toString().trim();
                String citty=location.getText().toString().trim();
                String ad=address.getText().toString().trim();
                String mm=minmax.getText().toString().trim();


                if (shopName.isEmpty())
                {
                    name.setError("Required");
                    return;
                }
                    name.requestFocus();

                if (mm.isEmpty())
                {
                    minmax.setError("Required");
                    minmax.requestFocus();
                    return;
                }
                if (ad.isEmpty())
                {
                    address.setError("Required");
                    address.requestFocus();
                    return;
                }

                if (citty.isEmpty())
                {
                    location.setError("Required");
                    location.requestFocus();
                    return;
                }

                presenter.edit("update_shop",shopName,citty,ad,typeId,id);

            }
        });


    }

    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Min Max type");
        dialogBuilder.setItems(types, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = types[item].toString();
                typeId=getID(item);
                minmax.setText(selectedText);
                Log.e("id",typeId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getID(int position){
        String id="";
        try {

            id=list.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MinMaxResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            list=response.getDetail();
            for (int i = 0; i < list.size(); i++) {
                String name=list.get(i).getTitle();
                typeList.add(name);
            }
            types();

        }else
        {
            hideDialog();
            showError(response.toString());
        }

    }


    @Override
    public void onLoad(ShopResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            if (response.getMessage().toLowerCase().contains("updated"))
            {                closeProgressbar();

                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                closeProgressbar();
                finish();
            }else
            {
                shopDetailArrayList=response.getDetail();
                for (int i = 0; i < shopDetailArrayList.size(); i++) {
                    String title=shopDetailArrayList.get(i).getTitle();
                    minmax.setText(title);
                    String names=shopDetailArrayList.get(i).getName();
                    name.setText(names);
                    typeId=shopDetailArrayList.get(i).getMin_max_type();
                    String loc=shopDetailArrayList.get(i).getLocation();
                    location.setText(loc);
                    String ad=shopDetailArrayList.get(i).getAddress();
                    address.setText(ad);

                }
            }



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
