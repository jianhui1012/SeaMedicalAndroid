package com.golike.seamedicalapp.api.support;


import android.util.Log;

/**
 * @author yuyh.
 * @date 2016/12/13.
 */
public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        Log.d("Logger","http : " + message);
    }
}
