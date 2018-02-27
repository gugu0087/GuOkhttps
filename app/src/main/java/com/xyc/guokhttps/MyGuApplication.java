package com.xyc.guokhttps;

import android.app.Application;

/**
 * Created by hasee on 2018/2/26.
 */

public class MyGuApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MyOkhttpUtils.initOkhttp(this);
    }
}
