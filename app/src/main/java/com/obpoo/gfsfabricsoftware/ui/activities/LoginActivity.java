package com.obpoo.gfsfabricsoftware.ui.activities;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.Datum;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.mvp.login.LoginPresenterImpl;
import com.obpoo.gfsfabricsoftware.mvp.login.LoginView;
import com.obpoo.gfsfabricsoftware.others.datamodels.login.LoginResponse;
import com.obpoo.gfsfabricsoftware.others.http.LoginHttpClient;
import com.obpoo.gfsfabricsoftware.utilities.Config;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.NotificationUtils;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;
import com.obpoo.gfsfabricsoftware.utilities.UiHelpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView,HttpReqResCallBack, ReportView {

    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_error)
    TextView tvError;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.btn_login)
    Button btnLogin;
    ArrayList<String> previledg = new ArrayList<>();
    List<Datum> data;
    ArrayList<String> list = new ArrayList<String>();


    LoginPresenterImpl presenter;
    ReportPresenterImpl reportPresenter;

    private NetworkDetection networkDetection;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    String regId,deviceId,tag="0";
    private static final String TAG = "LoginActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        deviceId= Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        networkDetection = new NetworkDetection();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        ButterKnife.bind(this);
        etPassword.setText("password");
        etUserName.setText("admin");
        presenter = new LoginPresenterImpl(this);
        reportPresenter = new ReportPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvError.setVisibility(View.INVISIBLE);
                String userName = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                serviceCallForLogin(userName,password);
                //presenter.validate(userName, password,LoginActivity.this);
            }
        });


        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                    Log.e("message",message);
                }
            }
        };
        displayFirebaseRegId();
    }

    private void displayFirebaseRegId() {
        regId = PreferenceConnector.readString(this, getString(R.string.regId),"");
        Log.e(TAG, "Firebase reg id: " + regId);
    }

    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onValidationFail(int type) {
        switch (type) {
            case 1:
                UiHelpers.shakeView(etUserName);
                tvError.setVisibility(View.VISIBLE);
                tvError.setText("Enter Valid Username");
                break;
            case 2:
                UiHelpers.shakeView(etPassword);
                tvError.setVisibility(View.VISIBLE);
                tvError.setText("Enter Valid Password");
        }
    }

    @Override
    public void onLogin(LoginResponse response) {

    }




    private void serviceCallForLogin(String userName, String password) {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.username, userName);
            mapOfRequestParams.put(Constants.password, password);
            mapOfRequestParams.put(Constants.token, regId);
            mapOfRequestParams.put(Constants.type, "android");
            mapOfRequestParams.put(Constants.device_id, deviceId);
            mapOfRequestParams.put(Constants.method, "login");

            LoginHttpClient loginHttpClient = new LoginHttpClient(this);
            loginHttpClient.callBack = this;
            loginHttpClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {
            case Constants.SERVICE_LOGIN:
              //  Log.e("loginResponse",jsonResponse.toString());
                if (jsonResponse != null) {
                   try
                   {
                       JSONObject jsonObject=new JSONObject(jsonResponse);
                       String success = jsonObject.getString("status").toLowerCase();
                       if (success.equals("success")) {
                           closeProgressbar();

                           String id = jsonObject.getJSONObject("user_data").getString("user_id");
                           String name = jsonObject.getJSONObject("user_data").getString("name");
                           String phone = jsonObject.getJSONObject("user_data").getString("phone");
                           String email = jsonObject.getJSONObject("user_data").getString("email");
                           String profile_pic = jsonObject.getJSONObject("user_data").getString("profile_pic");
                           String designation = jsonObject.getJSONObject("user_data").getString("designation");
                           String previledges = jsonObject.getJSONObject("user_data").getString("previledges");
                           String dept_id = jsonObject.getJSONObject("user_data").getString("dept_id");
                           String dept_name = jsonObject.getJSONObject("user_data").getString("dept_name");
                           String log_details_id = jsonObject.getJSONObject("user_data").getString("log_details_id");
                           Log.e("id", id);

                           JSONArray jsonArray = null;
                           try {
                               jsonArray = new JSONArray(previledges);
                               if (jsonArray != null) {
                                   for (int i = 0; i < jsonArray.length(); i++) {
                                       previledg.add(jsonArray.get(i).toString());
                                   }
                                   reportPresenter.onPreviledgesSearch("get_menu_by_roles", previledg);
                               }
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.admin_id), id);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.name), name);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.phone), phone);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.email), email);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.profile_pic), profile_pic);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.designation), designation);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.dept_id), dept_id);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.dept_name), dept_name);
                           PreferenceConnector.writeString(LoginActivity.this, getString(R.string.log_details_id), log_details_id);


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
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onGetReportResponse(DashResponse response) {

    }

    @Override
    public void onGetExchangerate(RateResponse response) {

    }

    @Override
    public void onGetStockAlert(Response response) {

    }

    @Override
    public void onGetDSCurve(CurveResponse response) {

    }

    @Override
    public void onGetSearchStock(Response response) {

    }

    @Override
    public void onGetPreviledgesStock(PreviledgesResponse response) {
        if (response.getStatus().equals("success")) {
            data = response.getData();
            for (int i = 0; i < data.size(); i++) {
                list.add(data.get(i).getMenuName());
            }
            PreferenceConnector.saveArrayList(list,getString(R.string.previledges),LoginActivity.this);
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("menulist", list);

            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
