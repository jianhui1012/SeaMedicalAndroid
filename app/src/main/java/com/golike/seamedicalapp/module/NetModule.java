package com.golike.seamedicalapp.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.golike.seamedicalapp.api.support.HeaderInterceptor;
import com.golike.seamedicalapp.api.support.Logger;
import com.golike.seamedicalapp.api.support.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by admin on 2017/4/6.
 */
@Module
public class NetModule {

    public NetModule() {

    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
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




}
