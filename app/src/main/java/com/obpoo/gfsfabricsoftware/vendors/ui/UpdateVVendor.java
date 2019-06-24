package com.obpoo.gfsfabricsoftware.vendors.ui;

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
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeDetail;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;
import com.obpoo.gfsfabricsoftware.vendortype.mvp.VendorTypePresenterImpl;
import com.obpoo.gfsfabricsoftware.vendortype.mvp.VendorTypeView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UpdateVVendor extends BaseActivity implements VendorsView,VendorTypeView {
    NetworkDetection networkDetection;
    @BindView(R.id.fullName) EditText fullName;
    @BindView(R.id.shortName) EditText shortName;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.fax) EditText fax;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.telephone) EditText telephone;
    @BindView(R.id.zipcode) EditText zipcode;
    @BindView(R.id.country) EditText country;
    @BindView(R.id.type) EditText type;
    @BindView(R.id.options) ImageView options;
    @BindView(R.id.submit) Button submit;
    List<String> typeList;
    JSONArray typeArray;
    CharSequence[] types;
    String typeId;
    VendorsPresenterImpl presenter;
    VendorTypePresenterImpl vendorTypePresenter;
    ArrayList<VendorTypeDetail> lists=new ArrayList<>();
    ArrayList<VendorsDetail> vendorsDetails=new ArrayList<>();
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Edit Vendors");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        typeList=new ArrayList<>();
        presenter = new VendorsPresenterImpl(this);
        vendorTypePresenter = new VendorTypePresenterImpl(this);
        submit.setText("Update Vendor");
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname=fullName.getText().toString().trim();
                String shortname=shortName.getText().toString().trim();
                String add=address.getText().toString().trim();
                String faxs=fax.getText().toString().trim();
                String emails=email.getText().toString().trim();
                String tel=telephone.getText().toString().trim();
                String zipcodes=zipcode.getText().toString().trim();
                String types=type.getText().toString().trim();
                String co=country.getText().toString().trim();

                if (shortname.isEmpty())
                {
                    shortName.setError("Required");
                    shortName.requestFocus();
                    return;
                }
                if (fullname.isEmpty())
                {
                    fullName.setError("Required");
                    fullName.requestFocus();
                    return;
                }


                if (types.isEmpty())
                {
                    type.setError("Required");
                    type.requestFocus();
                    return;
                }

                if (emails.isEmpty())
                {
                    email.setError("Required");
                    email.requestFocus();
                    return;
                }


                if (tel.isEmpty())
                {
                    telephone.setError("Required");
                    telephone.requestFocus();
                    return;
                }
                if (faxs.isEmpty())
                {
                    fax.setError("Required");
                    fax.requestFocus();
                    return;
                }

                if (add.isEmpty())
                {
                    address.setError("Required");
                    address.requestFocus();
                    return;
                }

                if (co.isEmpty())
                {
                    country.setError("Required");
                    country.requestFocus();
                    return;
                }

                if (zipcodes.isEmpty())
                {
                    zipcode.setError("Required");
                    zipcode.requestFocus();
                    return;
                }

                presenter.update("update_vendor",shortname,fullname,typeId,add,co,zipcodes,tel,faxs,emails,id);
            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeList.clear();
                showDialog();
                vendorTypePresenter.viewAll("view_all");
                //getVendor();
            }
        });

        presenter.getone("view_one",id);

    }




    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Vendor type");
        dialogBuilder.setItems(types, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = types[item].toString();
                typeId=getID(item);
                type.setText(selectedText);
                Log.e("id",typeId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getID(int position){
        String id="";
        try {

            id=lists.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(VendorTypeResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            lists=response.getDetail();
            for (int i = 0; i < lists.size(); i++) {
                String name=lists.get(i).getVendortype();
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
    public void onLoad(VendorsResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {


            hideDialog();
            if (response.getMessage().toLowerCase().contains("updated"))
            {                closeProgressbar();

                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                closeProgressbar();
                finish();
            }else
            {
                    vendorsDetails=response.getDetail();
                    for (int i = 0; i < vendorsDetails.size(); i++) {
                    String title=vendorsDetails.get(i).getVendorno();
                    String names=vendorsDetails.get(i).getVendor();
                    typeId=vendorsDetails.get(i).getVendortype();
                    String loc=vendorsDetails.get(i).getZipcode();
                    String ad=vendorsDetails.get(i).getAddress();
                    String faxs=vendorsDetails.get(i).getFax();
                    String semails=vendorsDetails.get(i).getEmail();
                    String phone=vendorsDetails.get(i).getTelephone();
                    String co=vendorsDetails.get(i).getCountry();
                    String ty=vendorsDetails.get(i).getVendortype();


                    fax.setText(faxs);
                    email.setText(semails);
                    zipcode.setText(loc);
                    address.setText(ad);
                    fullName.setText(names);
                    telephone.setText(phone);
                    country.setText(co);
                    fullName.setText(names);
                    shortName.setText(title);
                    type.setText(ty);






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
