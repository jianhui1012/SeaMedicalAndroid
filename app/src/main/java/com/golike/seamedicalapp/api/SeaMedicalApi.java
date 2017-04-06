package com.golike.seamedicalapp.api;

import com.golike.seamedicalapp.base.Const;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供海上医疗App的api服务
 * Created by admin on 2017/4/5.
 */
public class SeaMedicalApi {

    private static SeaMedicalApi seaMedicalApi;

    private static Object lock = new Object();

    private SeaMedicalApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        seaMedicalApi = retrofit.create(SeaMedicalApi.class);
    }

    private SeaMedicalApi(OkHttpClient okHttpClient,String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        seaMedicalApi = retrofit.create(SeaMedicalApi.class);
    }

    public static SeaMedicalApi getInstance(OkHttpClient okHttpClient) {
        if (seaMedicalApi == null) {
            synchronized (lock) {
                if (seaMedicalApi == null) {
                    seaMedicalApi = new SeaMedicalApi(okHttpClient);
                }
            }
        }
        return seaMedicalApi;
    }

    public static SeaMedicalApi getInstance(OkHttpClient okHttpClient,String baseurl) {
        if (seaMedicalApi == null) {
            synchronized (lock) {
                if (seaMedicalApi == null) {
                    seaMedicalApi = new SeaMedicalApi(okHttpClient,baseurl);
                }
            }
        }
        return seaMedicalApi;
    }
}
