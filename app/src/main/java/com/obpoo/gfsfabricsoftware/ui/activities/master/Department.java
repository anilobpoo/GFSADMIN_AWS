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
import com.obpoo.gfsfabricsoftware.others.http.department.AddDepartmentClient;
import com.obpoo.gfsfabricsoftware.others.http.department.GetDepartmentClient;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.ui.adapters.DepartmentAdapter;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Department extends BaseActivity implements HttpReqResCallBack,IMethodCaller {

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
    private DepartmentAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;

    void filter(String text) {
        List<ShopItem> temp = new ArrayList();
        for (ShopItem d : cartList) {
            if (d.getName().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_master);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Department");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        ButterKnife.bind(this);
        name.setHint("Department");
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
        mAdapter = new DepartmentAdapter(this, cartList);
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



    private void addDeptService(String name) {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.name, name);
            mapOfRequestParams.put(Constants.method, "add_department");
            AddDepartmentClient addClient = new AddDepartmentClient(this);
            addClient.callBack = this;
            addClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    private void getDeptService() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "view_all");
            GetDepartmentClient getClient = new GetDepartmentClient(this);
            getClient.callBack = this;
            getClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {
            case Constants.ADD_DEPARTMENT:
                Log.e("addDept",jsonResponse.toString());
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

            case Constants.GET_DEPARTMENT:
                Log.e("getDept",jsonResponse.toString());
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
                                    String name=feedObj.getString("name");

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
                            Toast.makeText(this, "Department already exists!", Toast.LENGTH_SHORT).show();
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

    @Override
    public void yourDesiredMethod(String text) {
        Log.e("te","De");
        if (text.equals("deleted"))
        {
            cartList.clear();
            mShimmerViewContainer.startShimmerAnimation();
            mAdapter.notifyDataSetChanged();
            getDeptService();
        }

    }
}
