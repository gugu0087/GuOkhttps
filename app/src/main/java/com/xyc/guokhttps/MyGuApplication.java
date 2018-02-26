package com.xyc.guokhttps;

import com.xyc.okutils.MyApplication;

/**
 * Created by hasee on 2018/2/26.
 */

public class MyGuApplication extends MyApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        MyOkhttpUtils.initOkhttp();
    }
}
