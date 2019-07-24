package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TransferScanAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_data;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_fabric;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInView;
import com.obpoo.gfsfabricsoftware.shelfassignment.ui.Scanning;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeDetail;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;
import com.obpoo.gfsfabricsoftware.shelfbarcode.mvp.ShelfBarcodePresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfbarcode.mvp.ShelfBarcodeView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class TransferStockIn extends BaseActivity implements ShelfBarcodeView,StockInView {
    ArrayList<Ts_data> ts_dataArrayList;
    int index_ts_fabric;
    @BindView(R.id.etSearch)
    EditText etSearch;
    ArrayList<Ts_fabric> ts_fabricArrayList = new ArrayList<>();
    int fabricScanCode = 8;
    int ShelfScanCode = 10;
    @BindView(R.id.rv_ts_fab_in)
    RecyclerView rv_ts_fab_in;
    @BindView(R.id.cardView5)
    CardView cardView5;
    @BindView(R.id.scanClick)
    ImageView scanClick;
    ShelfBarcodePresenterImpl shelfBarcodePresenter;
    @BindView(R.id.shopname)
    TextView shopname;
    @BindView(R.id.shopno)
    TextView shopno;
    @BindView(R.id.warename)
    TextView warename;
    @BindView(R.id.wareno)
    TextView wareno;
    @BindView(R.id.zonename)
    TextView zonename;
    @BindView(R.id.zoneno)
    TextView zoneno;
    @BindView(R.id.shelvename)
    TextView shelvename;
    @BindView(R.id.shelveno)
    TextView shelveno;
    @BindView(R.id.cardView6)
    CardView cardView6;
    @BindView(R.id.cardView7)
    CardView cardView7;
    @BindView(R.id.cardView10)
    CardView cardView10;
    ArrayList<String> uniqueArray=new ArrayList<>();
    TransferScanAdp  adapter;
    @BindView(R.id.submit_moveIn)
    Button submit_moveIn;
    StockInPresenterImpl stockInPresenter;
    String getShelfId;

    @BindView(R.id.ware_spin)
    Spinner ware_spin;

    int menuitemON=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_stock_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ts_dataArrayList=(ArrayList<Ts_data>)getIntent().getSerializableExtra("tsFabricArray");
        Log.i("ts_dataArrayListSize",ts_dataArrayList.size()+"");
        index_ts_fabric = getIntent().getIntExtra("index_ts_fabric",0);
        toolbar.setTitle(ts_dataArrayList.get(index_ts_fabric).getDocument());
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

//        ts_fabricArrayList=ts_dataArrayList.get(index_ts_fabric).getFabrics();
        shelfBarcodePresenter=new ShelfBarcodePresenterImpl(this);
        stockInPresenter=new StockInPresenterImpl(this);


        ArrayAdapter<Ts_data> ware_adapter = new ArrayAdapter<Ts_data>(this, R.layout.spinner_text, ts_dataArrayList);
        ware_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ware_spin.setAdapter(ware_adapter);


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                    if(ts_fabricArrayList!=null){
                        if(s.length()>0){
                        filter(s.toString());
                            rv_ts_fab_in.setVisibility(View.VISIBLE);}
                        if(s.length()==0){
                            menuitemON=0;
                            invalidateOptionsMenu();
                            rv_ts_fab_in.setVisibility(View.GONE);
                            cardView5.setVisibility(View.GONE);             //scanshelf
                            cardView6.setVisibility(View.GONE);             //ShelveDetail heading
                            cardView7.setVisibility(View.GONE);             //shelve detail in grid
                            cardView10.setVisibility(View.GONE);            //packet detail heading

                        }

                }

            }
        });

    }

    void filter(String text) {

        ArrayList<Ts_data> temp = new ArrayList();
        temp.clear();

            for (Ts_data d : ts_dataArrayList) {
                if (d.getDocument()!=null && d.getWhName().toLowerCase().contains(text.toLowerCase())) {
                    temp.add(d);
                }
            }
            Log.i("TEMPSize", temp.size() + "");

            if(temp.size()>0){
                menuitemON=0;
                invalidateOptionsMenu();
            cardView5.setVisibility(View.VISIBLE);
            cardView10.setVisibility(View.VISIBLE);}
        if(temp.size()==0){
            menuitemON=0;
            invalidateOptionsMenu();
            submit_moveIn.setVisibility(View.GONE);
            rv_ts_fab_in.setVisibility(View.GONE);
            cardView5.setVisibility(View.GONE);             //scanshelf
            cardView6.setVisibility(View.GONE);             //ShelveDetail heading
            cardView7.setVisibility(View.GONE);             //shelve detail in grid
            cardView10.setVisibility(View.GONE);
        }

//        adapter= new TransferScanAdp(temp,TransferStockIn.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_ts_fab_in.setLayoutManager(lm);
        rv_ts_fab_in.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scan,menu);
        if(menuitemON == 1){
            menu.getItem(0).setVisible(true);
        }
        if(menuitemON == 0){
            menu.getItem(0).setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_scan){

            startActivityForResult(new Intent(TransferStockIn.this,Scanning.class),fabricScanCode);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == fabricScanCode && resultCode ==RESULT_OK){
            String fabricid = data.getStringExtra("id");
            Log.i("FabricInId",fabricid);
            for(Ts_fabric tsf : ts_fabricArrayList){
                if(tsf.getUniqueCode() != null && tsf.getUniqueCode().contains(fabricid)){

                    tsf.setCheckScan(true);
                    uniqueArray.add(tsf.getUniqueCode());
                    break;
                }
                if(!tsf.getUniqueCode().contains(fabricid)){
                    callAlertDialog(fabricid);
                    break;
                }
            }
            adapter.notifyDataSetChanged();

            if(uniqueArray.size()>0){
                submit_moveIn.setVisibility(View.VISIBLE);
            }
            else{
                submit_moveIn.setVisibility(View.GONE);
            }


        }
        if(requestCode == ShelfScanCode && resultCode ==RESULT_OK){
            String shelfid = data.getStringExtra("id");
            Log.i("ShelfInId",shelfid);
            shelfBarcodePresenter.viewShelf("get_shelve_qr",shelfid);
        }
    }

    @OnClick(R.id.scanClick)
    public void onScanClick(){
        startActivityForResult(new Intent(TransferStockIn.this,Scanning.class),ShelfScanCode);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(StockInResponse response) {
        Log.i("StockInResponse",response.getStatus());

      for(int i =0; i<uniqueArray.size();i++){
          for(int j =0;j<ts_fabricArrayList.size();j++){
              if(ts_fabricArrayList.get(j).getUniqueCode() != null && ts_fabricArrayList.get(j).getUniqueCode().contains(uniqueArray.get(i))){
//                     ts_fabricArrayList.remove(ts_fabricArrayList.get(j));
//                     adapter.notifyItemRemoved(j);
//                     adapter.notifyItemRangeChanged(j, ts_fabricArrayList.size());


                    adapter.removeItem(j);

              }

          }

      }
//      adapter.notifyDataSetChanged();



    }

    @Override
    public void onLoad(ShelfBarcodeResponse response) {
        cardView5.setVisibility(View.GONE);
        menuitemON=1;
        invalidateOptionsMenu();

        Log.i("ShelfBarcodeResponse",response.getMessage());
        ArrayList<ShelfBarcodeDetail> shelfBarcodeDetailArrayList = response.getDetail();
        cardView6.setVisibility(View.VISIBLE);
        cardView7.setVisibility(View.VISIBLE);


        getShelfId= shelfBarcodeDetailArrayList.get(0).getUnq_scan_code();

        shopname.setText("Name: "+shelfBarcodeDetailArrayList.get(0).getShopname());
        shopno.setText("No: "+shelfBarcodeDetailArrayList.get(0).getShopNo());

        warename.setText("Name: "+shelfBarcodeDetailArrayList.get(0).getWarehouse_name());
        wareno.setText("No: "+shelfBarcodeDetailArrayList.get(0).getWarehouse_no());

        zonename.setText("Name: "+shelfBarcodeDetailArrayList.get(0).getZone_name());
        zoneno.setText("No: "+shelfBarcodeDetailArrayList.get(0).getZone_id());

        shelvename.setText("Name: "+shelfBarcodeDetailArrayList.get(0).getShelve_name());
        shelveno.setText("No: "+shelfBarcodeDetailArrayList.get(0).getShelve_name());



    }

    private void callAlertDialog(String getScannedUniqueCode) {
        final android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(TransferStockIn.this);
        alertBuilder.setMessage(Html.fromHtml("The scanned unique Id"+getScannedUniqueCode+" is not available in the current selected document "));
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        android.app.AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }
    @OnClick(R.id.submit_moveIn)
    public void onMoveIn(){
        String  userid = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        stockInPresenter.add(getShelfId,"add_packets",uniqueArray,userid,userid);
    }

    @OnItemSelected(R.id.ware_spin)
    public void onWareSelected(int position){
        Toast.makeText(getApplicationContext(),ts_fabricArrayList.get(position).getToWarehouse(),Toast.LENGTH_SHORT).show();
        ArrayList<Ts_data> temp = new ArrayList();
        temp.clear();

        for (Ts_data d : ts_dataArrayList) {
            if (d.getDocument().toLowerCase().contains(ts_dataArrayList.get(position).getDocument())) {
                    temp.add(d);
            }
        }
        Log.i("TEMPSize", temp.size() + "");

        if(temp.size()>0){
            rv_ts_fab_in.setVisibility(View.VISIBLE);
            cardView5.setVisibility(View.VISIBLE);
            cardView10.setVisibility(View.VISIBLE);}
        if(temp.size()==0){
            rv_ts_fab_in.setVisibility(View.GONE);
            cardView5.setVisibility(View.GONE);             //scanshelf
            cardView6.setVisibility(View.GONE);             //ShelveDetail heading
            cardView7.setVisibility(View.GONE);             //shelve detail in grid
            cardView10.setVisibility(View.GONE);
        }

//        adapter= new TransferScanAdp(temp,TransferStockIn.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_ts_fab_in.setLayoutManager(lm);
        rv_ts_fab_in.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
