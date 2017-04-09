package com.golike.seamedicalapp.ui.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.golike.seamedicalapp.R;
import com.golike.seamedicalapp.base.BaseActivity;
import com.golike.seamedicalapp.component.AppComponent;
import com.golike.seamedicalapp.component.DaggerSeaMedicalComponent;
import com.golike.seamedicalapp.ui.contract.LoginContract;
import com.golike.seamedicalapp.ui.presenter.LoginPresenter;
import com.golike.seamedicalapp.widget.ClearWriteEditText;

import javax.inject.Inject;

import butterknife.Bind;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Bind(R.id.de_login_phone)
    public ClearWriteEditText de_login_phone;

    @Bind(R.id.de_login_password)
    public ClearWriteEditText de_login_password;

    @Inject
    LoginPresenter loginPresenter;

    private SharedPreferences.Editor editor;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSeaMedicalComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initDatas() {
        editor = sharedPreferences.edit();
    }

    @Override
    public void configViews() {
        loginPresenter.attachView(this);
    }

    public void setloginsign(View v) {
        loginPresenter.login(de_login_phone.getText().toString(), de_login_password.getText().toString(), "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void loginSuccess() {
        loginPresenter.gettoken(de_login_phone.getText().toString(), de_login_password.getText().toString());
    }

    @Override
    public void gettokenCompleted(String loginToken) {
        if (!TextUtils.isEmpty(loginToken)) {
            RongIM.connect(loginToken, new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {
                    Log.e("connect", "onTokenIncorrect");
                    //reGetToken();
                }

                @Override
                public void onSuccess(String s) {
                    Log.e("connect", "onSuccess userid:" + s);
                    //editor.putString(SealConst.SEALTALK_LOGIN_ID, s);
                    editor.apply();
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.e("connect", "onError errorcode:" + errorCode.getValue());
                }
            });
        }

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
