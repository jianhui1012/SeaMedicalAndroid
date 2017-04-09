package com.golike.seamedicalapp.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.golike.seamedicalapp.R;

import io.rong.imkit.MainActivity;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class SplashActivity extends AppCompatActivity {
    private Context context;
    private android.os.Handler handler = new android.os.Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        String cacheToken = sp.getString("loginToken", "");
        if (!TextUtils.isEmpty(cacheToken)) {
            RongIM.connect(cacheToken, new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {

                }

                @Override
                public void onSuccess(String s) {

                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }
            });
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToMain();
                }
            }, 800);
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToLogin();
                }
            }, 800);
        }
    }

    private void goToMain() {
        startActivity(new Intent(context, MainActivity.class));
        finish();
    }

    private void goToLogin() {
        startActivity(new Intent(context, LoginActivity.class));
        finish();
    }

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }
}
