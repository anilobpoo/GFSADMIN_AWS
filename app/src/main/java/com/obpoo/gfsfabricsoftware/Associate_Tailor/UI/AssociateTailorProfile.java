package com.obpoo.gfsfabricsoftware.Associate_Tailor.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATTailorInfo;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricTailorInfo;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociateTailorProfile extends BaseActivity {
    ATTailorInfo tailorInfo;
    AssoFabricTailorInfo fabricTailorInfo;
    @BindView(R.id.tp_email)
    TextView tp_email;
    @BindView(R.id.tp_name)
    TextView tp_name;
    @BindView(R.id.tp_storename)
    TextView tp_storename;
    @BindView(R.id.tp_storeemail)
    TextView tp_storeemail;
    @BindView(R.id.tp_storenum)
    TextView tp_storenum;
    @BindView(R.id.tp_storeadd)
    TextView tp_storeadd;
    @BindView(R.id.tp_storecity)
    TextView tp_storecity;
    @BindView(R.id.tp_country)
    TextView tp_country;
    @BindView(R.id.tp_facEmail)
    TextView tp_facEmail;
    @BindView(R.id.tp_currency)
    TextView tp_currency;
    @BindView(R.id.tp_pincode)
    TextView tp_pincode;
    @BindView(R.id.tp_image)
    ImageView tp_image;
    String associatefrom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associate_tailor_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tailors Profile");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        associatefrom=getIntent().getStringExtra("AssociateFrom");
        if(associatefrom.equals("TAILORREQUEST")){
        tailorInfo= (ATTailorInfo)getIntent().getSerializableExtra("AssociateProfile");
        Log.i("ATtailorInfo",tailorInfo.getAdminEmail());
        tp_email.setText(tailorInfo.getAdminEmail());
        tp_name.setText(tailorInfo.getAdminName());
        tp_storename.setText(tailorInfo.getStoreName());
        tp_storeemail.setText(tailorInfo.getStoreEmail());
        tp_storenum.setText(tailorInfo.getStoreNumber());
        tp_storeadd.setText(tailorInfo.getAddress());
        tp_storecity.setText(tailorInfo.getCity());
        tp_country.setText(tailorInfo.getCountry());
        tp_facEmail.setText(tailorInfo.getFatoryemail());
        tp_currency.setText(tailorInfo.getCurrency());
        tp_pincode.setText(tailorInfo.getPincode());
        Picasso.with(AssociateTailorProfile.this).load(AppConstants.Tailor_Img+tailorInfo.getStorePic()).into(tp_image);}
        else if(associatefrom.equals("FABRICREQUEST")){
            fabricTailorInfo= (AssoFabricTailorInfo)getIntent().getSerializableExtra("AssociateProfile");
            Log.i("ATtailorInfo",fabricTailorInfo.getAdminEmail());
            tp_email.setText(fabricTailorInfo.getAdminEmail());
            tp_name.setText(fabricTailorInfo.getAdminName());
            tp_storename.setText(fabricTailorInfo.getStoreName());
            tp_storeemail.setText(fabricTailorInfo.getStoreEmail());
            tp_storenum.setText(fabricTailorInfo.getStoreNumber());
            tp_storeadd.setText(fabricTailorInfo.getAddress());
            tp_storecity.setText(fabricTailorInfo.getCity());
            tp_country.setText(fabricTailorInfo.getCountry());
            tp_facEmail.setText(fabricTailorInfo.getFatoryemail());
            tp_currency.setText(fabricTailorInfo.getCurrency());
            tp_pincode.setText(fabricTailorInfo.getPincode());
            Picasso.with(AssociateTailorProfile.this).load(AppConstants.Tailor_Img+fabricTailorInfo.getAdminPic()).into(tp_image);
        }

    }
}
