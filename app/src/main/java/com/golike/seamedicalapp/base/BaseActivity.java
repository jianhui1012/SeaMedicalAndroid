package com.golike.seamedicalapp.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.golike.seamedicalapp.SeaMedicalApplication;
import com.golike.seamedicalapp.component.AppComponent;

import butterknife.ButterKnife;

/**
 * Activity的基类
 * Created by admin on 2017/4/6.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ButterKnife.bind(this);
        setupActivityComponent(SeaMedicalApplication.getInstance().getAppComponent());
        initDatas();
        configViews();
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    public abstract int getLayoutId();

    public abstract void initToolBar();

    public abstract void initDatas();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
