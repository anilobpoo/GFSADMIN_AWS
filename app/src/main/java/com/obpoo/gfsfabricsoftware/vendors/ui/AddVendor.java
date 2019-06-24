package com.obpoo.gfsfabricsoftware.vendors.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeDetail;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;
import com.obpoo.gfsfabricsoftware.vendortype.mvp.VendorTypePresenterImpl;
import com.obpoo.gfsfabricsoftware.vendortype.mvp.VendorTypeView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddVendor extends BaseActivity implements VendorsView,VendorTypeView {
    NetworkDetection networkDetection;
    @BindView(R.id.fullName) EditText fullName;
    @BindView(R.id.shortName) EditText shortName;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.fax) EditText fax;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.telephone) EditText telephone;
    @BindView(R.id.zipcode) EditText zipcode;
    @BindView(R.id.country)
    AutoCompleteTextView country;
    @BindView(R.id.type) EditText type;
    @BindView(R.id.options) ImageView options;
    @BindView(R.id.submit) Button submit;
    List<String> typeList;
    JSONArray typeArray;
    CharSequence[] types;
    String typeId;
    VendorsPresenterImpl presenter;
    VendorTypePresenterImpl vendorTypePresenter;
    ArrayList<VendorTypeDetail> lists=new ArrayList<>();
    String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
            "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
            "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
            "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia",
            "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
            "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the",
            "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark",
            "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
            "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of",
            "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia","Scotland", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Vendors");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        typeList=new ArrayList<>();
        presenter = new VendorsPresenterImpl(this);
        vendorTypePresenter = new VendorTypePresenterImpl(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname=fullName.getText().toString().trim();
                String shortname=shortName.getText().toString().trim();
                String add=address.getText().toString().trim();
                String faxs=fax.getText().toString().trim();
                String emails=email.getText().toString().trim();
                String tel=telephone.getText().toString().trim();
                String zipcodes=zipcode.getText().toString().trim();
                String types=type.getText().toString().trim();
                String co=country.getText().toString().trim();

                if (shortname.isEmpty())
                {
                    shortName.setError("Required");
                    shortName.requestFocus();
                    return;
                }
                if (fullname.isEmpty())
                {
                    fullName.setError("Required");
                    fullName.requestFocus();
                    return;
                }


                if (types.isEmpty())
                {
                    type.setError("Required");
                    type.requestFocus();
                    return;
                }

                if (emails.isEmpty())
                {
                    email.setError("Required");
                    email.requestFocus();
                    return;
                }


                if (tel.isEmpty())
                {
                    telephone.setError("Required");
                    telephone.requestFocus();
                    return;
                }
                if (faxs.isEmpty())
                {
                    fax.setError("Required");
                    fax.requestFocus();
                    return;
                }

                if (add.isEmpty())
                {
                    address.setError("Required");
                    address.requestFocus();
                    return;
                }

                if (co.isEmpty())
                {
                    country.setError("Required");
                    country.requestFocus();
                    return;
                }

                if (zipcodes.isEmpty())
                {
                    zipcode.setError("Required");
                    zipcode.requestFocus();
                    return;
                }

                presenter.add("add_vendor",shortname,fullname,typeId,add,co,zipcodes,tel,faxs,emails);
            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeList.clear();
                showDialog();
                vendorTypePresenter.viewAll("view_all");
                //getVendor();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,countries);

        country.setAdapter(adapter);
        country.setThreshold(1);

    }




    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Vendor type");
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

            id=lists.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(VendorTypeResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            lists=response.getDetail();
            for (int i = 0; i < lists.size(); i++) {
                String name=lists.get(i).getVendortype();
                typeList.add(name);
            }
            types();

        }else
        {
            hideDialog();
            showError(response.toString());
        }



    }

    @Override
    public void onLoad(VendorsResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {

            closeProgressbar();
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }else
        {
            closeProgressbar();
            showError(response.toString());
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
}
