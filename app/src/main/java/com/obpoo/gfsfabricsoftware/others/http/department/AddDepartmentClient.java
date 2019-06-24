package com.obpoo.gfsfabricsoftware.others.http.department;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.obpoo.gfsfabricsoftware.others.http.BaseHttpClient;
import com.obpoo.gfsfabricsoftware.others.http.HttpClient;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.UrlBuilder;

import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class AddDepartmentClient extends BaseHttpClient {

    public HttpReqResCallBack callBack;


    public AddDepartmentClient(Context context) {
        super.context = context;
    }

    public void getJsonForType(Map<String, String> mapOfRequestParams) {
        HttpClient.context = context;
        HttpClient.post(UrlBuilder.formatRequestURLByRequestType(Constants.ADD_DEPARTMENT, mapOfRequestParams), mapOfRequestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.ADD_DEPARTMENT);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.ADD_DEPARTMENT);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody != null) {
                    callBack.jsonResponseReceived(new String(responseBody), statusCode, Constants.ADD_DEPARTMENT);
                } else {
                    callBack.jsonResponseReceived(null, statusCode, Constants.ADD_DEPARTMENT);
                }
            }
        }, Constants.CONTENT_TYPE_JSON, Constants.ADD_DEPARTMENT);
    }
}
