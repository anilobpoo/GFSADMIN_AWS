package com.obpoo.gfsfabricsoftware.salesorder.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AddFabricOrdersSO;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersPresenterImpl;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Billing extends BaseActivity implements MyOrdersView {

    NetworkDetection networkDetection;
    @BindView(R.id.actualPrice) EditText actualPrice;
    @BindView(R.id.subtotal) EditText subtotal;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.months) EditText months;
    @BindView(R.id.advance) EditText advance;
    @BindView(R.id.leftover) EditText leftover;
    @BindView(R.id.monthOptions) ImageView monthOptions;
    @BindView(R.id.location) ImageView location;
    //@BindView(R.id.cross) ImageView cross;
    @BindView(R.id.radioStatus) RadioGroup radioStatus;
    @BindView(R.id.radioDelivery) RadioGroup radioDelivery;
    @BindView(R.id.checkout) Button checkout;
    @BindView(R.id.monthlayout) LinearLayout monthlayout;
    @BindView(R.id.cashlayout) LinearLayout cashlayout;
    RadioButton radioStatusButton,radioDeliveryButton;
    String id,customer_group;
    String ap,st,pay_mode="",lat,longs,delivery_type="";
    MyOrdersPresenterImpl myOrdersPresenter;
    String advancePaid,leftoverBalance,deliveryAddress,credit_time="0",discount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        Intent intent=getIntent();
        ap=intent.getStringExtra("ap");
        st=intent.getStringExtra("st");
        id=intent.getStringExtra("id");
        discount=intent.getStringExtra("discount");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Billing");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        myOrdersPresenter=new MyOrdersPresenterImpl(this);

        actualPrice.setText(ap);
        subtotal.setText(st);
        monthOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMonth();
            }
        });

        advance.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                try {

                    String q=advance.getText().toString().trim();
                    String p=subtotal.getText().toString().trim();
                    if (q.equals("")||p.equals(""))
                    {
                    }else
                    {
                        double advances= Double.parseDouble(advance.getText().toString());
                        double subtotals= Double.parseDouble(subtotal.getText().toString());
                        double q1= Double.parseDouble(new DecimalFormat("#.##").format((subtotals-advances)));
                        leftover.setText(""+q1);
                    }

                }catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }

            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(Billing.this,Maps.class),1);

            }

        });


        radioStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioStatusButton = (RadioButton)findViewById(checkedId);
                pay_mode=radioStatusButton.getText().toString().toLowerCase();
                if (pay_mode.equals("cash"))
                {
                    cashlayout.setVisibility(View.VISIBLE);
                    monthlayout.setVisibility(View.GONE);
                    months.setText("");
                    advance.setText("0");
                    leftover.setText(st);

                }else
                {
                    monthlayout.setVisibility(View.VISIBLE);
                    cashlayout.setVisibility(View.GONE);
                    advance.setText("0");
                    leftover.setText("0");
                }
            }
        });

        radioDelivery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioDeliveryButton = (RadioButton)findViewById(checkedId);
                delivery_type=radioDeliveryButton.getText().toString().toLowerCase();

            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                advancePaid=advance.getText().toString().trim();
                leftoverBalance=leftover.getText().toString().trim();
                deliveryAddress=address.getText().toString().trim();

                if (deliveryAddress.isEmpty())
                {
                    address.setError("required");
                    address.requestFocus();
                    return;
                }

                if (pay_mode.isEmpty())
                {
                    Snackbar.make(view,  "Choose mode of payment", Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (delivery_type.isEmpty())
                {
                    Snackbar.make(view,  "Choose mode of delivery", Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (pay_mode.equals("delivery"))
                {
                    credit_time=months.getText().toString().trim();
                    if (credit_time.equals("0")||credit_time.isEmpty()||credit_time.equals(""))
                    {
                        months.setError("required");
                        months.requestFocus();
                        return;
                    }
                }
                 myOrdersPresenter.update("update",advancePaid,
                    leftoverBalance,st,"0","0",deliveryAddress,pay_mode,credit_time,delivery_type,lat,longs,id,"1");
            }
        });
    }


    public void chooseMonth()
    {
        List<String> mMonth = new ArrayList<String>();
        mMonth.add("1 Month");
        mMonth.add("2 Months");
        mMonth.add("3 Months");
        mMonth.add("4 Months");
        mMonth.add("5 Months");
        mMonth.add("6 Months");
        mMonth.add("7 Months");
        mMonth.add("8 Months");
        mMonth.add("9 Months");
        mMonth.add("10 Months");
        mMonth.add("11 Months");
        mMonth.add("12 Months");

        final CharSequence[] Animals = mMonth.toArray(new String[mMonth.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setItems(Animals, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Animals[item].toString();
                months.setText(selectedText);

            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MyOrdersResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            Intent intent=new Intent(Billing.this, MyOrders.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
        }else
        {
            hideDialog();
            showError(response.getMessage().toString());
        }
    }

    @Override
    public void onAllSO(AllOrderRes response) {

    }

    @Override
    public void onAllSoStatus(AllOrderStatusRes response) {

    }

    @Override
    public void onAddFabricsSO(AddFabricOrdersSO response) {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == 1 && resultCode == RESULT_OK) {
            lat = data.getStringExtra("lat");
            longs = data.getStringExtra("longs");
            String ads = data.getStringExtra("address");
            address.setText(ads);

            Log.e("latitude", ""+lat);
            Log.e("longitude", ""+longs);


        }
    }

}
