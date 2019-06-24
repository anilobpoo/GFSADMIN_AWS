package com.obpoo.gfsfabricsoftware.shop.ui;

import android.content.DialogInterface;
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

public class AddShop extends BaseActivity implements ShopView,MinMaxView {

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
    String typeId;
    ShopPresenterImpl presenter;
    MinMaxPresenterImpl minMaxPresenter;
    ArrayList<MinMaxDetail> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Shop");
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
                    name.requestFocus();
                    return;
                }


                if (mm.isEmpty())
                {
                    minmax.setError("Required");
                    minmax.requestFocus();
                    return;
                }
                if (citty.isEmpty())
                {
                    location.setError("Required");
                    location.requestFocus();
                    return;
                }
                if (ad.isEmpty())
                {
                    address.setError("Required");
                    address.requestFocus();
                    return;
                }



                presenter.add("add_shop",shopName,citty,ad,typeId);

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
            closeProgressbar();
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }else
        {
            closeProgressbar();
            showError(response.getMessage().toString());
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

        if (message.toLowerCase().contains("exists"))
        {
            Toast.makeText(this, "Shop Already Exists", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Failed to add", Toast.LENGTH_SHORT).show();

    }
}
