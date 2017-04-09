package com.golike.seamedicalapp.ui.activity;

import com.golike.seamedicalapp.R;
import com.golike.seamedicalapp.SeaMedicalApplication;
import com.golike.seamedicalapp.base.BaseActivity;
import com.golike.seamedicalapp.component.AppComponent;
import com.golike.seamedicalapp.component.DaggerSeaMedicalComponent;

public class HomeActivity extends BaseActivity {

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSeaMedicalComponent.builder().appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        // 监测内存泄露
//        SeaMedicalApplication.getRefWatcher(this).watch(this);
    }
}
