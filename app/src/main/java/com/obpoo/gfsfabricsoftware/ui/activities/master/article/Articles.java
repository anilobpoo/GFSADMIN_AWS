package com.obpoo.gfsfabricsoftware.ui.activities.master.article;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.others.datamodels.ArticleItem;
import com.obpoo.gfsfabricsoftware.others.http.article.GetArticleClient;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.ui.adapters.ArticleAdapter;
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

public class Articles extends BaseActivity implements HttpReqResCallBack {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private List<ArticleItem> cartList;
    private ArticleAdapter mAdapter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    void filter(String text) {
        List<ArticleItem> temp = new ArrayList();
        for (ArticleItem d : cartList) {
            if (d.getArticleNo().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Articles");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();

        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Articles.this,AddArticle.class));
            }
        });
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

        cartList = new ArrayList<>();
        mAdapter = new ArticleAdapter(this, cartList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        cartList.clear();
        mShimmerViewContainer.startShimmerAnimation();
        mAdapter.notifyDataSetChanged();
        getShopService();

    }

    public void onPause(){
        super.onPause();
    }
    private void getShopService() {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "viewall");
            GetArticleClient getShopClient = new GetArticleClient(this);
            getShopClient.callBack = this;
            getShopClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {

        switch (requestType)
        {
            case Constants.GET_ARTICLE:
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
                                mShimmerViewContainer.stopShimmerAnimation();
                                mShimmerViewContainer.setVisibility(View.GONE);
                            }
                            else {
                                for (int i = 0; i < feedArray.length(); i++) {
                                    JSONObject feedObj = (JSONObject) feedArray.get(i);
                                    String id=feedObj.getString("id");
                                    String articleno=feedObj.getString("articleno");
                                    String note=feedObj.getString("note");
                                    String fabric_type=feedObj.getString("fabric_type_name");


                                    ArticleItem orderItems=new ArticleItem();
                                    orderItems.setId(id);
                                    orderItems.setArticleNo(articleno);
                                    orderItems.setNotes(note);
                                    orderItems.setFabric_type(fabric_type);

                                    cartList.add(orderItems);
                                    mAdapter.notifyDataSetChanged();
                                    mShimmerViewContainer.stopShimmerAnimation();
                                    mShimmerViewContainer.setVisibility(View.GONE);

                                }
                            }
                        }else
                        {
                            Toast.makeText(this, "Article already exists!", Toast.LENGTH_SHORT).show();
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
