package com.obpoo.gfsfabricsoftware.others.http;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.obpoo.gfsfabricsoftware.utilities.Constants;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.Map;

import cz.msebera.android.httpclient.entity.StringEntity;


public class HttpClient {

    public  static Context context;
    public static AsyncHttpClient client = new AsyncHttpClient();



    public static void post(String url, Map<String, String> mapOfRequestParams, AsyncHttpResponseHandler responseHandler, String contentType, int requestType) {
         Log.e("Get Info", url + mapOfRequestParams);

        client.setTimeout(500 * 1000);
        JSONObject jsonParams = new JSONObject();
        try {
            switch (requestType) {
                case Constants.SERVICE_LOGIN:
                    jsonParams.put(Constants.username, mapOfRequestParams.get(Constants.username));
                    jsonParams.put(Constants.password, mapOfRequestParams.get(Constants.password));
                    jsonParams.put(Constants.token, mapOfRequestParams.get(Constants.token));
                    jsonParams.put(Constants.type, mapOfRequestParams.get(Constants.type));
                    jsonParams.put(Constants.device_id, mapOfRequestParams.get(Constants.device_id));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.ADD_SHOP:
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.min_max_type, mapOfRequestParams.get(Constants.min_max_type));
                    jsonParams.put(Constants.location, mapOfRequestParams.get(Constants.location));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_SHOP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_SHOP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_SHOP_ID:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_SHOP:
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.min_max_type, mapOfRequestParams.get(Constants.min_max_type));
                    jsonParams.put(Constants.location, mapOfRequestParams.get(Constants.location));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                    //department

                case Constants.ADD_DEPARTMENT:
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_DEPARTMENT:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_DEPARTMENT:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.EDIT_DEPARTMENT:
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                //customertype

                case Constants.ADD_CUSTOMER_TYPE:
                    jsonParams.put(Constants.customer_type, mapOfRequestParams.get(Constants.customer_type));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_CUSTOMER_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_CUSTOMER_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.EDIT_CUSTOMER_TYPE:
                    jsonParams.put(Constants.customer_type, mapOfRequestParams.get(Constants.customer_type));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                //customertype

                case Constants.VENDOR_TYPE:
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_VENDOR_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.DELETE_VENDOR_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_VENDOR_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                    //Customer
                case Constants.GET_CUSTOMER:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.user_id, mapOfRequestParams.get(Constants.user_id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.DELETE_CUSTOMER:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.CUSTOMER:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.customer_name, mapOfRequestParams.get(Constants.customer_name));
                    jsonParams.put(Constants.shop_id, mapOfRequestParams.get(Constants.shop_id));
                    jsonParams.put(Constants.customer_type_id, mapOfRequestParams.get(Constants.customer_type_id));
                    jsonParams.put(Constants.user_id, mapOfRequestParams.get(Constants.user_id));
                    jsonParams.put(Constants.user_name, mapOfRequestParams.get(Constants.user_name));
                    jsonParams.put(Constants.customer_group, mapOfRequestParams.get(Constants.customer_group));
                    jsonParams.put(Constants.password, mapOfRequestParams.get(Constants.password));
                    jsonParams.put(Constants.vat_name, mapOfRequestParams.get(Constants.vat_name));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.country, mapOfRequestParams.get(Constants.country));
                    jsonParams.put(Constants.phone, mapOfRequestParams.get(Constants.phone));
                    jsonParams.put(Constants.fax, mapOfRequestParams.get(Constants.fax));
                    jsonParams.put(Constants.email, mapOfRequestParams.get(Constants.email));
                    jsonParams.put(Constants.zipcode, mapOfRequestParams.get(Constants.zipcode));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.UPDATE_CUSTOMER:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.customer_name, mapOfRequestParams.get(Constants.customer_name));
                    jsonParams.put(Constants.shop_id, mapOfRequestParams.get(Constants.shop_id));
                    jsonParams.put(Constants.customer_type_id, mapOfRequestParams.get(Constants.customer_type_id));
                    jsonParams.put(Constants.user_id, mapOfRequestParams.get(Constants.user_id));
                    jsonParams.put(Constants.user_name, mapOfRequestParams.get(Constants.user_name));
                    jsonParams.put(Constants.customer_group, mapOfRequestParams.get(Constants.customer_group));
                    jsonParams.put(Constants.password, mapOfRequestParams.get(Constants.password));
                    jsonParams.put(Constants.vat_name, mapOfRequestParams.get(Constants.vat_name));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.country, mapOfRequestParams.get(Constants.country));
                    jsonParams.put(Constants.phone, mapOfRequestParams.get(Constants.phone));
                    jsonParams.put(Constants.fax, mapOfRequestParams.get(Constants.fax));
                    jsonParams.put(Constants.email, mapOfRequestParams.get(Constants.email));
                    jsonParams.put(Constants.zipcode, mapOfRequestParams.get(Constants.zipcode));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.GET_ID_CUSTOMER:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_ID_VENDORS:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.GET_VENDORS:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_VENDORS:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.ADD_VENDORS:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.vendorno, mapOfRequestParams.get(Constants.vendorno));
                    jsonParams.put(Constants.vendortype, mapOfRequestParams.get(Constants.vendortype));
                    jsonParams.put(Constants.vendor, mapOfRequestParams.get(Constants.vendor));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.country, mapOfRequestParams.get(Constants.country));
                    jsonParams.put(Constants.telephone, mapOfRequestParams.get(Constants.telephone));
                    jsonParams.put(Constants.fax, mapOfRequestParams.get(Constants.fax));
                    jsonParams.put(Constants.email, mapOfRequestParams.get(Constants.email));
                    jsonParams.put(Constants.zipcode, mapOfRequestParams.get(Constants.zipcode));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.UPDATE_VENDORS:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.vendorno, mapOfRequestParams.get(Constants.vendorno));
                    jsonParams.put(Constants.vendortype, mapOfRequestParams.get(Constants.vendortype));
                    jsonParams.put(Constants.vendor, mapOfRequestParams.get(Constants.vendor));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.country, mapOfRequestParams.get(Constants.country));
                    jsonParams.put(Constants.telephone, mapOfRequestParams.get(Constants.telephone));
                    jsonParams.put(Constants.fax, mapOfRequestParams.get(Constants.fax));
                    jsonParams.put(Constants.email, mapOfRequestParams.get(Constants.email));
                    jsonParams.put(Constants.zipcode, mapOfRequestParams.get(Constants.zipcode));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.ADD_WAREHOUSE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.warehouse_name, mapOfRequestParams.get(Constants.warehouse_name));
                    jsonParams.put(Constants.warehouse_no, mapOfRequestParams.get(Constants.warehouse_no));
                    jsonParams.put(Constants.can_sell_part, mapOfRequestParams.get(Constants.can_sell_part));
                    jsonParams.put(Constants.shopNo, mapOfRequestParams.get(Constants.shopNo));
                    jsonParams.put(Constants.locality, mapOfRequestParams.get(Constants.locality));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.Available_status, mapOfRequestParams.get(Constants.Available_status));


                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.EDIT_WAREHOUSE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.warehouse_name, mapOfRequestParams.get(Constants.warehouse_name));
                    jsonParams.put(Constants.warehouse_no, mapOfRequestParams.get(Constants.warehouse_no));
                    jsonParams.put(Constants.can_sell_part, mapOfRequestParams.get(Constants.can_sell_part));
                    jsonParams.put(Constants.shopNo, mapOfRequestParams.get(Constants.shopNo));
                    jsonParams.put(Constants.locality, mapOfRequestParams.get(Constants.locality));
                    jsonParams.put(Constants.address, mapOfRequestParams.get(Constants.address));
                    jsonParams.put(Constants.Available_status, mapOfRequestParams.get(Constants.Available_status));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());

                case Constants.DELETE_WAREHOUSE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.GET_WAREHOUSE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.GET_WAREHOUSE_ID:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.ADD_BANK:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.bankname, mapOfRequestParams.get(Constants.bankname));

                    Log.e("json",jsonParams.toString());
                case Constants.EDIT_BANK:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.bankname, mapOfRequestParams.get(Constants.bankname));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_BANK:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;


                case Constants.ADD_FABRIC_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.fabric_type, mapOfRequestParams.get(Constants.fabric_type));

                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.EDIT_FABRIC_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.fabric_type, mapOfRequestParams.get(Constants.fabric_type));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_FABRIC_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_FABRIC_TYPE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;


                case Constants.ADD_MINMAX:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.title, mapOfRequestParams.get(Constants.title));

                    Log.e("json",jsonParams.toString());
                case Constants.EDIT_MINMAX:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.title, mapOfRequestParams.get(Constants.title));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_MINMAX:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_MINMAX:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;


                case Constants.ADD_COMP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.composition, mapOfRequestParams.get(Constants.composition));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_COMP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());

                    break;
                case Constants.DELETE_COMP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_COMP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    jsonParams.put(Constants.composition, mapOfRequestParams.get(Constants.composition));
                    Log.e("json",jsonParams.toString());
                    break;

                case Constants.ADD_COLOR:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.color_code, mapOfRequestParams.get(Constants.color_code));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_COLOR:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_COLOR:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_COLOR:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    jsonParams.put(Constants.color_code, mapOfRequestParams.get(Constants.color_code));
                    Log.e("json",jsonParams.toString());
                    break;


                case Constants.ADD_ARTICLE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.fabrictype, mapOfRequestParams.get(Constants.fabrictype));
                    jsonParams.put(Constants.articleno, mapOfRequestParams.get(Constants.articleno));
                    jsonParams.put(Constants.note, mapOfRequestParams.get(Constants.note));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_ARTICLE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_ARTICLE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_ARTICLE_ID:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_ARTICLE:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    jsonParams.put(Constants.fabrictype, mapOfRequestParams.get(Constants.fabrictype));
                    jsonParams.put(Constants.articleno, mapOfRequestParams.get(Constants.articleno));
                    jsonParams.put(Constants.note, mapOfRequestParams.get(Constants.note));
                    Log.e("json",jsonParams.toString());
                    break;



                case Constants.ADD_GROUP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));

                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.GET_GROUP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.DELETE_GROUP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    Log.e("json",jsonParams.toString());
                    break;
                case Constants.EDIT_GROUP:
                    jsonParams.put(Constants.method, mapOfRequestParams.get(Constants.method));
                    jsonParams.put(Constants.id, mapOfRequestParams.get(Constants.id));
                    jsonParams.put(Constants.name, mapOfRequestParams.get(Constants.name));
                    Log.e("json",jsonParams.toString());
                    break;
                default:
                    break;
            }


            StringEntity entity = null;
            try {
                entity = new StringEntity(jsonParams.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            CustomSSLSocketFactory sslSocketFactory = trustAllSSLCertificates();
            if (sslSocketFactory != null)
                client.setSSLSocketFactory(sslSocketFactory);
            if (contentType.equalsIgnoreCase(Constants.CONTENT_TYPE_EMPTY_STRING))
                client.post(context, url, entity, null, responseHandler);
            else
                client.post(context, url, entity, contentType, responseHandler);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private static CustomSSLSocketFactory trustAllSSLCertificates() {
        KeyStore trustStore;
        CustomSSLSocketFactory sslSocketFactory = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            sslSocketFactory = new CustomSSLSocketFactory(trustStore);
            sslSocketFactory.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception exception) {
            Log.d("exception", exception.getMessage());
        }
        return sslSocketFactory;
    }



}
