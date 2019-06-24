package com.obpoo.gfsfabricsoftware.ui.activities.master.article;

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
import com.obpoo.gfsfabricsoftware.others.http.FabricType.GetFabricClient;
import com.obpoo.gfsfabricsoftware.others.http.article.AddArticleClient;
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
import butterknife.ButterKnife;

public class AddArticle extends BaseActivity implements HttpReqResCallBack {

    @BindView(R.id.name) EditText name;
    @BindView(R.id.notes) EditText notes;
    @BindView(R.id.type) EditText type;
    @BindView(R.id.submit) Button add;
    @BindView(R.id.options) ImageView options;
    NetworkDetection networkDetection;
    List<String> typeList;
    JSONArray typeArray;
    CharSequence[] types;
    String typeId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Article");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        typeList=new ArrayList<>();
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeList.clear();
                getFabricType();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ano=name.getText().toString().trim();
                String no=notes.getText().toString().trim();
                String ty=type.getText().toString().trim();


                if (ano.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }

                if (no.isEmpty())
                {
                    notes.setError("Required");
                    notes.requestFocus();
                    return;
                }
                if (ty.isEmpty())
                {
                    type.setError("Required");
                    type.requestFocus();
                    return;
                }



                addService(ano,no,typeId);
            }
        });

    }


    private void addService(String ano,final String no,final String typeId) {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.articleno, ano);
            mapOfRequestParams.put(Constants.note, no);
            mapOfRequestParams.put(Constants.fabrictype, typeId);
            mapOfRequestParams.put(Constants.method, "insert");
            AddArticleClient addShopClient = new AddArticleClient(this);
            addShopClient.callBack = this;
            addShopClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {
            case Constants.ADD_ARTICLE:
                Log.e("add",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            closeProgressbar();
                            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
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

            case Constants.GET_FABRIC_TYPE:
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
                                    String name=feedObj.getString("fabric_type");
                                    typeList.add(name);

                                }
                                types();
                            }
                        }else
                        {
                            Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show();
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

    private void getFabricType() {
        if (networkDetection.isWifiAvailable(this)|| networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetFabricClient getClient = new GetFabricClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }
    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Fabric type");
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
