package com.obpoo.gfsfabricsoftware.others.http.FabricType;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.obpoo.gfsfabricsoftware.others.http.BaseHttpClient;
import com.obpoo.gfsfabricsoftware.others.http.HttpClient;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.UrlBuilder;

import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class AddFabricClient extends BaseHttpClient {

    public HttpReqResCallBack callBack;
    public AddFabricClient(Context context) {
        super.context = context;
    }

    public void getJsonForType(Map<String, String> mapOfRequestParams) {
        HttpClient.context = context;
        HttpClient.post(UrlBuilder.formatRequestURLByRequestType(Constants.ADD_FABRIC_TYPE, mapOfRequestParams), mapOfRequestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.ADD_FABRIC_TYPE);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.ADD_FABRIC_TYPE);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.ADD_FABRIC_TYPE);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.ADD_FABRIC_TYPE);
                }
            }
        }, Constants.CONTENT_TYPE_JSON, Constants.ADD_FABRIC_TYPE);
    }
}
