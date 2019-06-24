package com.obpoo.gfsfabricsoftware.customers.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeDetail;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;
import com.obpoo.gfsfabricsoftware.customertype.mvp.CustomerTypePresenterImpl;
import com.obpoo.gfsfabricsoftware.customertype.mvp.CustomerTypeView;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupDetail;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupPresenterImpl;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupView;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopDetail;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopPresenterImpl;
import com.obpoo.gfsfabricsoftware.shop.mvp.ShopView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddCustomers extends BaseActivity implements CustomersView,ShopView,CustomerTypeView,GroupView {

    NetworkDetection networkDetection;
    @BindView(R.id.fullName) EditText fullName;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.fax) EditText fax;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.telephone) EditText telephone;
    @BindView(R.id.zipcode) EditText zipcode;
    @BindView(R.id.group) EditText group;
    @BindView(R.id.vat) EditText vat;
    @BindView(R.id.country)
    AutoCompleteTextView country;
    @BindView(R.id.type) EditText type;
    @BindView(R.id.shop) EditText shop;
    @BindView(R.id.options) ImageView options;
    @BindView(R.id.showPassword) ImageView showPassword;
    @BindView(R.id.shopOption) ImageView shopOption;
    @BindView(R.id.groupOption) ImageView groupOption;
    @BindView(R.id.submit) Button submit;
    List<String> typeList,shopList,groupList;
    CharSequence[] types,shops,groups;
    String typeId,shopId,tag="0",groupId;
    String user_id,user_name;

    CustomersPresenterImpl presenter;
    ShopPresenterImpl shopPresenter;
    CustomerTypePresenterImpl customerTypePresenter;
    GroupPresenterImpl groupPresenter;

    ArrayList<CustomerTypeDetail> lists=new ArrayList<>();
    ArrayList<GroupDetail> groupLists=new ArrayList<>();
    ArrayList<ShopDetail> shopLists=new ArrayList<>();

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
        setContentView(R.layout.activity_add_customers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Customers");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        typeList=new ArrayList<>();
        groupList=new ArrayList<>();
        shopList=new ArrayList<>();
        user_id = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        user_name = PreferenceConnector.readString(this, getString(R.string.name), "");

        presenter=new CustomersPresenterImpl(this);
        shopPresenter=new ShopPresenterImpl(this);
        groupPresenter=new GroupPresenterImpl(this);
        customerTypePresenter=new CustomerTypePresenterImpl(this);


        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tag.equals("0"))
                {
                    tag="1";
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPassword.setBackground(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                }else if (tag.equals("1"))
                {
                    tag="0";
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPassword.setBackground(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                }

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,countries);

        country.setAdapter(adapter);
        country.setThreshold(1);


        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                typeList.clear();
                customerTypePresenter.viewAll("view_all");
            }
        });

        shopOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

                shopList.clear();
                shopPresenter.viewAll("view_all");
            }
        });

        groupOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

                groupList.clear();
                groupPresenter.viewAll("view_all",user_id);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fullname=fullName.getText().toString().trim();
                String add=address.getText().toString().trim();
                String faxs=fax.getText().toString().trim();
                String emails=email.getText().toString().trim();
                String tel=telephone.getText().toString().trim();
                String zipcodes=zipcode.getText().toString().trim();
                String types=type.getText().toString().trim();
                String co=country.getText().toString().trim();
                String groups=group.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String vats=vat.getText().toString().trim();
                String shops=shop.getText().toString().trim();


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

                if (pass.isEmpty())
                {
                    password.setError("Required");
                    password.requestFocus();
                    return;
                }

                if (vats.isEmpty())
                {
                    vat.setError("Required");
                    vat.requestFocus();
                    return;
                }

                if (groups.isEmpty())
                {
                    group.setError("Required");
                    group.requestFocus();
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
                showProgressBar();
                presenter.add("add_customer",user_id,fullname,typeId,vats,pass,shopId,groupId,add,user_name,co,zipcodes,tel,faxs,emails);


            }
        });


    }



    public void types()
    {

        types = typeList.toArray(new String[typeList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Customer type");
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

    public void shops()
    {

        shops = shopList.toArray(new String[shopList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Shop");
        dialogBuilder.setItems(shops, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = shops[item].toString();
                shopId=getShopId(item);
                shop.setText(selectedText);
                Log.e("id",shopId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getShopId(int position){
        String id="";
        try {
            id=shopLists.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void groups()
    {

        groups = groupList.toArray(new String[groupList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose group");
        dialogBuilder.setItems(groups, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = groups[item].toString();
                groupId=getGroupId(item);
                group.setText(selectedText);
                Log.e("id",groupId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getGroupId(int position){
        String id="";
        try {
            id=groupLists.get(position).getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(GroupResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            groupLists=response.getDetail();
            for (int i = 0; i < groupLists.size(); i++) {
                String name=groupLists.get(i).getName();
                groupList.add(name);
            }
            groups();

        }else
        {
            hideDialog();
            showError(response.toString());
        }


    }

    @Override
    public void onLoad(ShopResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            shopLists=response.getDetail();
            for (int i = 0; i < shopLists.size(); i++) {
                String name=shopLists.get(i).getName();
                shopList.add(name);
            }
            shops();

        }else
        {
            hideDialog();
            showError(response.toString());
        }

    }

    @Override
    public void onLoad(CustomerTypeResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            lists=response.getDetail();
            for (int i = 0; i < lists.size(); i++) {
               String name=lists.get(i).getCustomer_type();
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
    public void onLoad(CustomersResponse response) {

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
