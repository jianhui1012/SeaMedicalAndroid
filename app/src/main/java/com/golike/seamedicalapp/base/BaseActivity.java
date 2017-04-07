package com.golike.seamedicalapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.golike.seamedicalapp.SeaMedicalApplication;
import com.golike.seamedicalapp.component.AppComponent;

/**
 * Activity的基类
 * Created by admin on 2017/4/6.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(SeaMedicalApplication.getInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 监测内存泄露
        SeaMedicalApplication.getRefWatcher(this).watch(this);
    }
}
