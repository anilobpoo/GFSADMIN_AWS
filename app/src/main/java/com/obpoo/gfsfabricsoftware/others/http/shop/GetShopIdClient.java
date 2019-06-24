package com.obpoo.gfsfabricsoftware.others.http.shop;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.obpoo.gfsfabricsoftware.others.http.BaseHttpClient;
import com.obpoo.gfsfabricsoftware.others.http.HttpClient;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.UrlBuilder;

import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class GetShopIdClient extends BaseHttpClient {

    public HttpReqResCallBack callBack;


    public GetShopIdClient(Context context) {
        super.context = context;
    }

    public void getJsonForType(Map<String, String> mapOfRequestParams) {
        HttpClient.context = context;
        HttpClient.post(UrlBuilder.formatRequestURLByRequestType(Constants.GET_SHOP_ID, mapOfRequestParams), mapOfRequestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.GET_SHOP_ID);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.GET_SHOP_ID);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.GET_SHOP_ID);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.GET_SHOP_ID);
                }
            }
        }, Constants.CONTENT_TYPE_JSON, Constants.GET_SHOP_ID);
    }
}
