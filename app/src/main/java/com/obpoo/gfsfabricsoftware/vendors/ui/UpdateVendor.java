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
import com.obpoo.gfsfabricsoftware.others.http.vendor.GetVendorClient;
import com.obpoo.gfsfabricsoftware.others.http.vendors.GetVendorsIdClient;
import com.obpoo.gfsfabricsoftware.others.http.vendors.UpdateVendorsClient;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class UpdateVendor extends BaseActivity implements HttpReqResCallBack {
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
    String typeId,id;



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

        Intent intent=getIntent();
        id=intent.getStringExtra("id");


        submit.setText("Update Vendor");
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

                addVendor(fullname,shortname,add,tel,faxs,emails,zipcodes,co,types);
            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeList.clear();
                getVendor();
            }
        });

        getVendorId();

    }

    private void addVendor(String fullname, String shortname, String add, String tel, String faxs, String emails, String zipcodes, String co, String types) {

        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "update_vendor");
            mapOfRequestParams.put(Constants.vendorno, shortname);
            mapOfRequestParams.put(Constants.vendor, fullname);
            mapOfRequestParams.put(Constants.vendortype, typeId);
            mapOfRequestParams.put(Constants.address, add);
            mapOfRequestParams.put(Constants.country, co);
            mapOfRequestParams.put(Constants.zipcode, zipcodes);
            mapOfRequestParams.put(Constants.telephone, tel);
            mapOfRequestParams.put(Constants.fax, faxs);
            mapOfRequestParams.put(Constants.email, emails);
            mapOfRequestParams.put(Constants.id, id);

            UpdateVendorsClient addClient = new UpdateVendorsClient(this);
            addClient.callBack = this;
            addClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }

    }

    private void getVendorId() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_one");
            mapOfRequestParams.put(Constants.id, id);
            GetVendorsIdClient getClient = new GetVendorsIdClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }
    private void getVendor() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetVendorClient getClient = new GetVendorClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {
            case Constants.UPDATE_VENDORS:
                Log.e("add",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            Toast.makeText(this, "Updated Vendor Successfully", Toast.LENGTH_SHORT).show();
                            closeProgressbar();
                            finish();
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, getString(R.string.status_error), Toast.LENGTH_SHORT).show();
                }
                closeProgressbar();
                
                break;

            case Constants.GET_VENDOR_TYPE:
                Log.e("get",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            typeArray = jsonObject.getJSONArray("data");
                            if(typeArray==null||typeArray.length()==0)
                            {

                            }
                            else {
                                for (int i = 0; i < typeArray.length(); i++) {
                                    JSONObject feedObj = (JSONObject) typeArray.get(i);
                                    String id=feedObj.getString("id");
                                    String name=feedObj.getString("vendortype");
                                    typeList.add(name);
                                }
                                types();
                            }
                        }else
                        {
                            Toast.makeText(this, "Type already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, getString(R.string.status_error), Toast.LENGTH_SHORT).show();
                }
                closeProgressbar();
                break;

            case Constants.GET_ID_VENDORS:
                Log.e("get",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            typeArray = jsonObject.getJSONArray("data");
                            if(typeArray==null||typeArray.length()==0)
                            {

                            }
                            else {
                                for (int i = 0; i < typeArray.length(); i++) {
                                    JSONObject feedObj = (JSONObject) typeArray.get(i);
                                    String id=feedObj.getString("vendorID");
                                    String vendorno=feedObj.getString("vendorno");
                                    String vendor=feedObj.getString("vendor");
                                    String addresss=feedObj.getString("address");
                                    String countrys=feedObj.getString("country");
                                    String telephones=feedObj.getString("telephone");
                                    String faxs=feedObj.getString("fax");
                                    String emails=feedObj.getString("email");
                                    String zipcodes=feedObj.getString("zipcode");
                                    String name=feedObj.getString("name");
                                    typeId=feedObj.getString("vendortype");
                                    shortName.setText(vendorno);
                                    fullName.setText(vendor);
                                    address.setText(addresss);
                                    country.setText(countrys);
                                    telephone.setText(telephones);
                                    fax.setText(faxs);
                                    email.setText(emails);
                                    zipcode.setText(zipcodes);
                                    type.setText(name);


                                }

                            }
                        }else
                        {
                            Toast.makeText(this, "Type already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, getString(R.string.status_error), Toast.LENGTH_SHORT).show();
                }
                closeProgressbar();
                break;


            default:
                break;
        }
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
            JSONObject json = typeArray.getJSONObject(position);
            id=json.getString("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return id;
    }
}
