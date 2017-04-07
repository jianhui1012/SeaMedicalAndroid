package com.golike.seamedicalapp.module;

import com.golike.seamedicalapp.api.SeaMedicalApi;
import com.golike.seamedicalapp.api.support.HeaderInterceptor;
import com.golike.seamedicalapp.api.support.Logger;
import com.golike.seamedicalapp.api.support.LoggingInterceptor;
import com.golike.seamedicalapp.base.Const;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by admin on 2017/4/6.
 */
@Module
public class SeaMedicalApiModule {

    private final String baseurl;

    public SeaMedicalApiModule(String baseurl){
       this.baseurl=baseurl;
    }

    //默认为本应用api接口
    public SeaMedicalApiModule(){
        this.baseurl= Const.API_BASE_URL;
    }


    @Provides
    public OkHttpClient provideOkHttpClient() {
        LoggingInterceptor logging = new LoggingInterceptor(new Logger());
        logging.setLevel(LoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected SeaMedicalApi provideSeaService(OkHttpClient okHttpClient) {
        return SeaMedicalApi.getInstance(okHttpClient,this.baseurl);
    }


}
