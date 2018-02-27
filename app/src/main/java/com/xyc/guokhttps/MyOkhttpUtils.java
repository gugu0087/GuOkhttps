package com.xyc.guokhttps;

import android.content.Context;

import com.xyc.okhttputils.https.HttpsUtils;
import com.xyc.okhttputils.log.LoggerInterceptor;
import com.xyc.okhttputils.utils.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by hasee on 2018/2/26.
 */

public class MyOkhttpUtils {
    public static final long CONNECT_TIMEOUT = 10000L;
    public static final long READ_TIMEOUT = 10000L;
    public static final String TAG = "xyc";

    public static void initOkhttp(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor(TAG,true,context))
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static void initHttpsOkHttp(Context context) {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .addInterceptor(new LoggerInterceptor(TAG,true,context))
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
