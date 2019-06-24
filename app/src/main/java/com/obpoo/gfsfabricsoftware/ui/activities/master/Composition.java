package com.obpoo.gfsfabricsoftware.ui.activities.master;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.others.datamodels.master.ShopItem;
import com.obpoo.gfsfabricsoftware.others.http.composition.AddCompClient;
import com.obpoo.gfsfabricsoftware.others.http.composition.GetCompClient;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.ui.adapters.CompAdapter;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Composition extends BaseActivity implements HttpReqResCallBack{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private List<ShopItem> cartList;
    private CompAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Composition");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deptName=name.getText().toString().trim();

                if (deptName.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }

                addDeptService(deptName);
            }
        });

        cartList = new ArrayList<>();
        mAdapter = new CompAdapter(this, cartList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        getDeptService();
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cartList != null) {
                    filter(editable.toString());
                }

            }
        });
    }


    void filter(String text) {
        List<ShopItem> temp = new ArrayList();
        for (ShopItem d : cartList) {
            if (d.getName().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    private void addDeptService(String name) {
        if (networkDetection.isWifiAvailable(this)|| networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.composition, name);
            mapOfRequestParams.put(Constants.method, "add_composition");
            AddCompClient addClient = new AddCompClient(this);
            addClient.callBack = this;
            addClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    private void getDeptService() {
        if (networkDetection.isWifiAvailable(this)|| networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetCompClient getClient = new GetCompClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {
            case Constants.ADD_COMP:
                Log.e("add",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            closeProgressbar();
                            cartList.clear();
                            mShimmerViewContainer.startShimmerAnimation();
                            mAdapter.notifyDataSetChanged();
                            getDeptService();
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

            case Constants.GET_COMP:
                Log.e("get",jsonResponse.toString());
                if (jsonResponse != null) {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            JSONArray feedArray = jsonObject.getJSONArray("data");
                            if(feedArray==null||feedArray.length()==0)
                            {
                                // myorderslayout.setVisibility(View.VISIBLE);
                                mShimmerViewContainer.stopShimmerAnimation();
                                mShimmerViewContainer.setVisibility(View.GONE);


                            }
                            else {
                                for (int i = 0; i < feedArray.length(); i++) {
                                    JSONObject feedObj = (JSONObject) feedArray.get(i);
                                    String id=feedObj.getString("id");
                                    String name=feedObj.getString("composition");

                                    ShopItem orderItems=new ShopItem();
                                    orderItems.setId(id);
                                    orderItems.setName(name);

                                    cartList.add(orderItems);
                                    mAdapter.notifyDataSetChanged();
                                    mShimmerViewContainer.stopShimmerAnimation();
                                    mShimmerViewContainer.setVisibility(View.GONE);

                                }
                            }
                        }else
                        {
                            Toast.makeText(this, "Composition already exists!", Toast.LENGTH_SHORT).show();
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
}
