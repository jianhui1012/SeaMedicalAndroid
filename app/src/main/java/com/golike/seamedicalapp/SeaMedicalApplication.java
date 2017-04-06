package com.golike.seamedicalapp;

import android.app.Application;
import android.content.Context;

import com.golike.seamedicalapp.component.AppComponent;
import com.golike.seamedicalapp.component.DaggerAppComponent;
import com.golike.seamedicalapp.module.AppModule;
import com.golike.seamedicalapp.module.SeaMedicalApiModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import io.rong.imkit.RongIM;

/**
 * Created by admin on 2017/4/5.
 */
public class SeaMedicalApplication extends Application {

    private AppComponent appComponent;

    private RefWatcher refWatcher;
    private static SeaMedicalApplication sinstance;

    //内存泄漏观测者
    public static RefWatcher getRefWatcher(Context context) {
        SeaMedicalApplication application = (SeaMedicalApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sinstance = this;
        //配置内存泄露
        refWatcher = LeakCanary.install(this);
        //初始化融云的sdk
        RongIM.init(this);
    }

    public static SeaMedicalApplication getInstance() {
        return sinstance;
    }

    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .seaMedicalApiModule(new SeaMedicalApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
