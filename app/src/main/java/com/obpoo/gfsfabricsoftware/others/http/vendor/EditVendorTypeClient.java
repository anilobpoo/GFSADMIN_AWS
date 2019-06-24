package com.obpoo.gfsfabricsoftware.others.http.vendor;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.obpoo.gfsfabricsoftware.others.http.BaseHttpClient;
import com.obpoo.gfsfabricsoftware.others.http.HttpClient;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.UrlBuilder;

import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class EditVendorTypeClient extends BaseHttpClient {

    public HttpReqResCallBack callBack;


    public EditVendorTypeClient(Context context) {
        super.context = context;
    }

    public void getJsonForType(Map<String, String> mapOfRequestParams) {
        HttpClient.context = context;
        HttpClient.post(UrlBuilder.formatRequestURLByRequestType(Constants.EDIT_VENDOR_TYPE, mapOfRequestParams), mapOfRequestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.EDIT_VENDOR_TYPE);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.EDIT_VENDOR_TYPE);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.EDIT_VENDOR_TYPE);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.EDIT_VENDOR_TYPE);
                }
            }
        }, Constants.CONTENT_TYPE_JSON, Constants.EDIT_VENDOR_TYPE);
    }
}
