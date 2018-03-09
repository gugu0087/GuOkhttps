package com.xyc.guokhttps;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * Created by hasee on 2017/12/19.
 */

public class ApplicationHolder {

    private static Context mContext;
    private static final Handler mainHandler = new Handler();
    public static ApplicationHolder instance = null;

    private ApplicationHolder() {

    }

    public static ApplicationHolder getInstance() {
        if (instance == null) {
            instance = new ApplicationHolder();
        }
        return instance;
    }

    public static void setAppContext(Context context) {
        if (context == null) {
            Log.e("ApplicationHolder", "try to set null application, return");
            return;
        }
        mContext = context;
    }

    public static Context getAppContext() {
        if (mContext == null) {
            Log.e("ApplicationHolder",
                    "Global ApplicationContext is null, Please call ApplicationHolder.setmApplication(application) at the onCreate() method of Activity and Application");
        }
        return mContext;
    }

    // 获取主线程
    public void postMainRunnable(Runnable runnable) {
        mainHandler.post(runnable);
    }

}
