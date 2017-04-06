package com.golike.seamedicalapp.util;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by admin on 2017/4/6.
 */
public class RongYunHelper {

    private RongYunHelper() {

    }


    /***
     * 连接融云服务器
     *
     * @param context
     * @param token
     * @param connectCallback
     */
    public static void connect(Context context, String token, RongIMClient.ConnectCallback connectCallback) {
        if (context.getApplicationInfo().packageName.equals(getCurProcessName(context))) {
            RongIM.connect(token, connectCallback);
        }
    }

    /***
     * 获取当前应用的进程名
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
