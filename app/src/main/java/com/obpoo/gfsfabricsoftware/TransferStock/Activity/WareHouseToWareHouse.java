package com.obpoo.gfsfabricsoftware.TransferStock.Activity;import android.content.Intent;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.support.v7.widget.RecyclerView;import android.widget.TextView;import com.obpoo.gfsfabricsoftware.R;import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocData;import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;import com.obpoo.gfsfabricsoftware.utilities.AppConstants;import java.util.ArrayList;import butterknife.BindView;import butterknife.ButterKnife;import butterknife.OnClick;public class WareHouseToWareHouse extends BaseActivity {    @BindView(R.id.tv_stock_doc)    TextView tv_stock_doc;    @BindView(R.id.tv_warehouse)    TextView tv_warehouse;    @BindView(R.id.recycler_view)    RecyclerView recycler_view;    @BindView(R.id.move)    TextView move;    String docNo;    int position;    ArrayList<StockDocData> data = new ArrayList<>();    ArrayList<String> doclist = new ArrayList<>();    @Override    protected void onActivityResult(int requestCode, int resultCode, Intent data) {        if (requestCode == AppConstants.StockDoc) {            if (data != null) {                docNo = data.getStringExtra("selectdocumentNo");                position = data.getIntExtra("selectdocumentPosition",-1);                tv_stock_doc.setText(docNo);            }        }    }    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_ware_house_to_ware_house);        ButterKnife.bind(this);        data = getIntent().getParcelableArrayListExtra("data");        for (int i = 0; i < data.size(); i++) {            doclist.add(data.get(i).getDocument());        }    }    @OnClick(R.id.tv_stock_doc)    public void clickStockDoc() {        Intent in = new Intent(WareHouseToWareHouse.this, SelectStockDoc.class);        in.putExtra("doclist", doclist);        startActivityForResult(in, AppConstants.StockDoc);    }}