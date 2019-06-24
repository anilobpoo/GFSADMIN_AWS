package com.obpoo.gfsfabricsoftware.user.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.others.http.customerType.GetCustomerTypeClient;
import com.obpoo.gfsfabricsoftware.others.http.shop.GetShopClient;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class AddUser extends BaseActivity implements HttpReqResCallBack {

    NetworkDetection networkDetection;
    @BindView(R.id.fullName) EditText fullName;
   // @BindView(R.id.address) EditText address;
   // @BindView(R.id.fax) EditText fax;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.telephone) EditText telephone;
   // @BindView(R.id.zipcode) EditText zipcode;
    //@BindView(R.id.group) EditText group;
   // @BindView(R.id.vat) EditText vat;
    //@BindView(R.id.country) EditText country;
    @BindView(R.id.type) EditText type;
    //@BindView(R.id.shop) EditText shop;
    @BindView(R.id.options) ImageView options;

    @BindView(R.id.showPassword) ImageView showPassword;
   // @BindView(R.id.shopOption) ImageView shopOption;
    @BindView(R.id.submit) Button submit;
    List<String> typeList,shopList;
    JSONArray typeArray,shopArray;
    CharSequence[] types,shops;
    String typeId,shopId,tag="0";
    String user_id,user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add User");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        typeList=new ArrayList<>();
        shopList=new ArrayList<>();
        user_id = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        user_name = PreferenceConnector.readString(this, getString(R.string.name), "");


        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tag.equals("0"))
                {
                    tag="1";
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPassword.setBackground(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                }else if (tag.equals("1"))
                {
                    tag="0";
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPassword.setBackground(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                }

            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeList.clear();
                getCustomerTypes();
            }
        });




      /*  shopOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopList.clear();
                getShops();
            }
        });
*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fullname=fullName.getText().toString().trim();

                String emails=email.getText().toString().trim();
                String tel=telephone.getText().toString().trim();
                //String groups=group.getText().toString().trim();
                String pass=password.getText().toString().trim();



                if (fullname.isEmpty())
                {
                    fullName.setError("Required");
                    fullName.requestFocus();
                    return;
                }



                if (emails.isEmpty())
                {
                    email.setError("Required");
                    email.requestFocus();
                    return;
                }

                if (pass.isEmpty())
                {
                    password.setError("Required");
                    password.requestFocus();
                    return;
                }


                if (tel.isEmpty())
                {
                    telephone.setError("Required");
                    telephone.requestFocus();
                    return;
                }


                //addCustomer(fullname,add,tel,faxs,emails,zipcodes,co,typeId,shopId,pass,vats,groups);


            }
        });


    }


    private void getShops() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetShopClient getClient = new GetShopClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    private void getCustomerTypes() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetCustomerTypeClient getClient = new GetCustomerTypeClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType)
        {

            case Constants.CUSTOMER:
                Log.e("addCustomer",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            Toast.makeText(this, "Added Customer Successfully", Toast.LENGTH_SHORT).show();
                            closeProgressbar();
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


            case Constants.GET_CUSTOMER_TYPE:
                Log.e("getCustomerType",jsonResponse.toString());
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
                                    String name=feedObj.getString("customer_type");
                                    typeList.add(name);

                                }
                                types();
                            }
                        }else
                        {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
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


            case Constants.GET_SHOP:
                Log.e("getShop",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            shopArray = jsonObject.getJSONArray("data");
                            if(shopArray==null||shopArray.length()==0)
                            {

                            }
                            else {
                                for (int i = 0; i < shopArray.length(); i++) {
                                    JSONObject feedObj = (JSONObject) shopArray.get(i);
                                    String name=feedObj.getString("name");
                                    shopList.add(name);

                                }
                                shops();
                            }
                        }else
                        {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
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
        }
    }


    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Customer type");
        dialogBuilder.setItems(types, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = types[item].toString();
                typeId=getID(item);
               // type.setText(selectedText);
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

    public void shops()
    {

        shops = shopList.toArray(new String[shopList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Shop");
        dialogBuilder.setItems(shops, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = shops[item].toString();
                shopId=getShopId(item);
               // shop.setText(selectedText);
                Log.e("id",shopId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getShopId(int position){
        String id="";
        try {
            JSONObject json = shopArray.getJSONObject(position);
            id=json.getString("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return id;
    }
}
