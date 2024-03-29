package com.obpoo.gfsfabricsoftware.others.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.UrlBuilder;


import java.util.Map;

import cz.msebera.android.httpclient.Header;



public class LoginHttpClient extends BaseHttpClient {

    public HttpReqResCallBack callBack;


    public LoginHttpClient(Context context) {
        super.context = context;
    }

    public void getJsonForType(Map<String, String> mapOfRequestParams) {
        HttpClient.context = context;
        HttpClient.post(UrlBuilder.formatRequestURLByRequestType(Constants.SERVICE_LOGIN, mapOfRequestParams), mapOfRequestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.SERVICE_LOGIN);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.SERVICE_LOGIN);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.SERVICE_LOGIN);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.SERVICE_LOGIN);
                }
            }
        }, Constants.CONTENT_TYPE_JSON, Constants.SERVICE_LOGIN);
    }
}
