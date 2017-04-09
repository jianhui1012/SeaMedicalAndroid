package com.golike.seamedicalapp.module;

import com.golike.seamedicalapp.api.RongYunApiService;
import com.golike.seamedicalapp.api.SeaMedicalApiService;
import com.golike.seamedicalapp.base.Const;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/4/6.
 */
@Module
public class RongYunApiModule {

    private final String baseurl;

    public RongYunApiModule(String baseurl){
        this.baseurl=baseurl;
    }



    @Provides  @Named("rongyun_retrofit")
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();

    }

    @Provides
    protected RongYunApiService provideRongYunService(@Named("rongyun_retrofit")  Retrofit retrofit) {
        return retrofit.create(RongYunApiService.class);
    }


}
