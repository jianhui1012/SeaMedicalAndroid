package com.golike.seamedicalapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.golike.seamedicalapp.R;
import com.golike.seamedicalapp.base.BaseActivity;
import com.golike.seamedicalapp.base.Const;
import com.golike.seamedicalapp.component.AppComponent;
import com.golike.seamedicalapp.component.DaggerAppComponent;
import com.golike.seamedicalapp.component.DaggerSeaMedicalComponent;
import com.golike.seamedicalapp.module.AppModule;
import com.golike.seamedicalapp.module.SeaMedicalApiModule;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        //设置融云url的app
        AppComponent seaComponent = DaggerAppComponent.builder()
                .seaMedicalApiModule(new SeaMedicalApiModule(Const.API_RONGYUN_URL))
                .appModule(new AppModule(this))
                .build();
        DaggerSeaMedicalComponent.builder().appComponent(seaComponent)
                .build()
                .inject(this);
    }

    public void turnPage(View v){
        startActivity(new Intent(this,ConversationListActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
