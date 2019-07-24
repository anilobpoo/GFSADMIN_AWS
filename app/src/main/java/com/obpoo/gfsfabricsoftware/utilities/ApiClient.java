package com.obpoo.gfsfabricsoftware.utilities;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        return new Retrofit
                .Builder()
                .baseUrl(AppConstants.BASEURL_new)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRates() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();

        return new Retrofit
                .Builder()
                .baseUrl(AppConstants.RATEBASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRetrofit2() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .connectTimeout(3, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .readTimeout(3, TimeUnit.MINUTES)
                .connectionPool(new ConnectionPool(0, 1, TimeUnit.MINUTES))
                .build();

        return new Retrofit
                .Builder()
                .baseUrl(AppConstants.BASEURL_new)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getoldRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        return new Retrofit
                .Builder()
                .baseUrl(AppConstants.BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
