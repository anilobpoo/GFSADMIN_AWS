package com.obpoo.gfsfabricsoftware.shelfassignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleDetail;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;
import com.obpoo.gfsfabricsoftware.bundle.mvp.BundlePresenterImpl;
import com.obpoo.gfsfabricsoftware.bundle.mvp.BundleView;
import com.obpoo.gfsfabricsoftware.shelfassignment.adapter.BundleAdapter;
import com.obpoo.gfsfabricsoftware.shelfassignment.adapter.StockInAdapter;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInDetail;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInView;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeDetail;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;
import com.obpoo.gfsfabricsoftware.shelfbarcode.mvp.ShelfBarcodePresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfbarcode.mvp.ShelfBarcodeView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.FabricItem;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCallers;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShelfAssignment extends BaseActivity implements BundleView,ShelfBarcodeView,StockInView,IMethodCallers {


    @BindView(R.id.number) TextView wnumber;
    @BindView(R.id.wname) TextView wname;
    @BindView(R.id.zone) TextView zone;
    @BindView(R.id.stockin) Button stockin;
    @BindView(R.id.stockout) Button stockout;
    @BindView(R.id.view) Button view;
    @BindView(R.id.add) Button add;
    @BindView(R.id.scan) Button scan;
    @BindView(R.id.enter) Button enter;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container) ShimmerFrameLayout mShimmerViewContainer;
    @BindView(R.id.shelfId) EditText shelfId;
    @BindView(R.id.shelfDetails) LinearLayout shelfDetails;
    @BindView(R.id.bundles) CardView bundles;
    int BUNDLE=1,SHELFID=2;
    String bundleId,shelfIds;
    BundlePresenterImpl bundlePresenter;
    ShelfBarcodePresenterImpl shelfBarcodePresenter;
    StockInPresenterImpl stockInPresenter;
    ArrayList<BundleDetail> bundleDetails=new ArrayList<>();
    ArrayList<ShelfBarcodeDetail> shelfBarcodeDetails=new ArrayList<>();
    JSONObject items;
    JSONArray arr=new JSONArray();
    private List<FabricItem> cartList;
    BundleAdapter fabricAdapter;
    List<String> bundleArray=new ArrayList<>();
    String shelfid;
    String createdby,userid;
    Set<String> hs = new HashSet<>();
    private List<StockInDetail> stockInDetails=new ArrayList<>();
    StockInAdapter stockInAdapter;
    List<String> adapterUniqueCode=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Shelf");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        stockout.setEnabled(false);
        stockin.setEnabled(false);

        bundlePresenter=new BundlePresenterImpl(this);
        shelfBarcodePresenter=new ShelfBarcodePresenterImpl(this);
        stockInPresenter=new StockInPresenterImpl(this);

        shelfDetails.setVisibility(View.GONE);
        bundles.setVisibility(View.GONE);

        userid = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        createdby = PreferenceConnector.readString(this, getString(R.string.name), "");

        cartList = new ArrayList<>();
        shelfId.setText("1mbfzfn6gx");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stockin.setEnabled(true);
                stockout.setEnabled(false);
                startActivityForResult(new Intent(ShelfAssignment.this,Scanning.class),BUNDLE);
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(ShelfAssignment.this,Scanning.class),SHELFID);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String scancode=shelfId.getText().toString().trim();
                if (scancode.isEmpty())
                {
                    shelfId.setError("Required");
                    shelfId.requestFocus();
                    return;
                }
                showDialog();
                shelfBarcodePresenter.viewShelf("get_shelve_qr",scancode);

            }
        });

        stockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                hs.addAll(bundleArray);
                bundleArray.clear();
                bundleArray.addAll(hs);


                stockInPresenter.add(shelfid,"add_packets",bundleArray,userid,userid);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                stockin.setEnabled(false);
                stockout.setEnabled(true);
                arr = new JSONArray();
                stockInPresenter.view(shelfid,"view_by_shelf");
            }
        });

        stockout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stockInPresenter.move(shelfid,"move_packets",adapterUniqueCode);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == BUNDLE && resultCode == RESULT_OK) {
            bundleId=data.getStringExtra("id");
            Log.e("id",bundleId);
            bundlePresenter.viewAll("view_by_uniqueid",bundleId);

        }if (requestCode == SHELFID && resultCode == RESULT_OK) {
            shelfIds=data.getStringExtra("id");
            Log.e("id",shelfIds);
            shelfId.setText(shelfIds);
            showDialog();
            shelfBarcodePresenter.viewShelf("get_shelve_qr",shelfIds);
        }
    }


    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(StockInResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            {

               if (response.getMessage().toLowerCase().contains("added"))
               {
                   Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
               }else
               {
                   cartList.clear();
//                recyclerView.getAdapter().notifyDataSetChanged();
                   bundles.setVisibility(View.VISIBLE);
                   stockInDetails.clear();
                   stockInDetails = response.getDetail();
                   stockInAdapter = new StockInAdapter(this, stockInDetails);
                   RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                   recyclerView.setLayoutManager(mLayoutManager);
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
                   recyclerView.setAdapter(stockInAdapter);
                   mShimmerViewContainer.setVisibility(View.GONE);
                   stockInAdapter.notifyDataSetChanged();
               }



            }


        }else {
            closeProgressbar();
            showError(response.getMessage().toString());
        }

    }





    @Override
    public void onLoad(ShelfBarcodeResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {

            hideDialog();
            shelfBarcodeDetails = response.getDetail();
            for (int i = 0; i < shelfBarcodeDetails.size(); i++) {
                String warehouse_name = shelfBarcodeDetails.get(i).getWarehouse_name();
                String warehouse_no = shelfBarcodeDetails.get(i).getWarehouse_no();
                String shelve_name = shelfBarcodeDetails.get(i).getShelve_name();
                String zone_name = shelfBarcodeDetails.get(i).getZone_name();
                shelfid = shelfBarcodeDetails.get(i).getUnq_scan_code();

                wnumber.setText(warehouse_name);
                wname.setText(shelve_name);
                zone.setText(zone_name);
                shelfDetails.setVisibility(View.VISIBLE);
            }
        }else {
            hideDialog();
            showError(response.getMessage().toString());
        }

    }





    @Override
    public void onLoad(BundleResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {

            hideDialog();
           // stockInDetails.clear();
           // fabricAdapter.notifyDataSetChanged();
            bundleDetails = response.getDetail();

           // bundleArray.add(categoryItem.getUnique_id());




            for (int i = 0; i < bundleDetails.size(); i++) {
                String article_no = bundleDetails.get(i).getArticle_no();
                String meters = bundleDetails.get(i).getNet_meters();
                String pcsno = "Not Given";
                String bkno = bundleDetails.get(i).getBaikon_no();
                String color = bundleDetails.get(i).getColor_code();
                String ctno = "Not Given";
                String pono = bundleDetails.get(i).getPo_id();
                String cartonno = bundleDetails.get(i).getNo_of_carton();
                String id = bundleDetails.get(i).getId();
                String unique_id = bundleDetails.get(i).getUnique_id();
                String fab_id = bundleDetails.get(i).getFab_id();



                JsonEncodeDemo(article_no,meters,pcsno,bkno,ctno,pono,id,unique_id,fab_id,color,cartonno);
                /*
                Art No     PP001
                MTRS# 122.55     YARD# 134.00
                Col# 01     Pcsno#225494
                BK#PP001     CT/No-
                RequestedOrder# Po00002243-12     #OF CARTOON
               */


            }
        }else {
            hideDialog();
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void JsonEncodeDemo(String articleno,String meters,String pcsno,String bkno,String ctno,String pono,String id,String unique_id,String fab_id,String color,String cartonnumber) {
        JSONObject params = new JSONObject();
        double yards=Double.parseDouble(meters)*1.09361;

        items = new JSONObject();

        try {
            params.put("articleno", articleno);
            params.put("meters", meters);
            params.put("yards", ""+new DecimalFormat("#.##").format(yards));
            params.put("pcsno", pcsno);
            params.put("bkno", bkno);
            params.put("ctno", ctno);
            params.put("pono", pono);
            params.put("id", id);
            params.put("unique_id", unique_id);
            params.put("fab_id", fab_id);
            params.put("color", color);
            params.put("cartonnumber", cartonnumber);
            arr.put(params);
            items.put("data", arr);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("arr", "" + items);
        cartList.clear();
//        fabricAdapter.notifyDataSetChanged();
        parseAddedFabric(items);
    }



    private void parseAddedFabric(JSONObject response) {
        try {

            JSONArray feedArray = response.getJSONArray("data");

            if(feedArray==null||feedArray.length()==0)
            {
                recyclerView.setVisibility(View.GONE);
            }
            else {
                for (int i = 0; i < feedArray.length(); i++) {
                    JSONObject feedObj = (JSONObject) feedArray.get(i);

                    stockInDetails.clear();
//                    recyclerView.getAdapter().notifyDataSetChanged();
                    adapterUniqueCode.clear();
                    bundleArray.clear();


                 /*   String articleno=feedObj.getString("articleno");
                    String meters=feedObj.getString("meters");
                    String yards=feedObj.getString("yards");
                    String pcsno=feedObj.getString("pcsno");
                    String bkno=feedObj.getString("bkno");
                    String ctno=feedObj.getString("ctno");
                    String pono=feedObj.getString("pono");
                    String id=feedObj.getString("id");
                    String unique_id=feedObj.getString("unique_id");
                    String fab_id=feedObj.getString("fab_id");
                    String color=feedObj.getString("color");
                    String cartonnumber=feedObj.getString("cartonnumber");*/


                    FabricItem categoryItem=new FabricItem(feedObj.getString("articleno"),feedObj.getString("meters"),feedObj.getString("yards"),feedObj.getString("pcsno"),feedObj.getString("bkno"),feedObj.getString("ctno"),feedObj.getString("pono"),feedObj.getString("id"),feedObj.getString("unique_id"),feedObj.getString("fab_id"),feedObj.getString("color"),feedObj.getString("cartonnumber"));
                    /*categoryItem.setArticleno(articleno);
                    categoryItem.setMeters(meters);
                    categoryItem.setYard(yards);
                    categoryItem.setCartonnumber(cartonnumber);
                    categoryItem.setPcsno(pcsno);
                    categoryItem.setBkno(bkno);
                    categoryItem.setCtno(ctno);
                    categoryItem.setPono(pono);
                    categoryItem.setId(id);
                    categoryItem.setUnique_id(unique_id);
                    categoryItem.setFab_id(fab_id);
                    categoryItem.setColor(color);*/
                    cartList.add(categoryItem);

                    fabricAdapter = new BundleAdapter(this, cartList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(fabricAdapter);
                    fabricAdapter.notifyDataSetChanged();
                    bundles.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    mShimmerViewContainer.setVisibility(View.GONE);

                    Log.e("ArrayDetail",bundleArray.toString());

                    bundleArray.add(categoryItem.getUnique_id());





                }


            }
        }catch (JSONException e)
        {
            e.printStackTrace();

        }
    }

    @Override
    public void yourDesiredMethod(List<String> text) {
        adapterUniqueCode=text;
    }
}
