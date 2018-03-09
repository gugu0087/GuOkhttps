package com.xyc.guokhttps;

import android.util.Log;
import com.xyc.okhttputils.builder.GetBuilder;
import com.xyc.okhttputils.builder.PostFileBuilder;
import com.xyc.okhttputils.builder.PostStringBuilder;
import com.xyc.okhttputils.callback.Callback;
import com.xyc.okhttputils.request.RequestCall;
import com.xyc.okhttputils.utils.OkHttpUtils;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

/**
 * Created by hasee on 2017/12/13.
 */

public class DataManager {

    public static DataManager instance = null;
    public final String MULTIPART_FORM_DATA = "image/*";       // 指明要上传的文件格式

    DataManager() {

    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private String getToken() {
        return PreferencesUtils.getString("token");

    }

    public RequestCall sendGetRequestData(String url, Map<String, String> params) {
        String token = getToken();
        GetBuilder getBuilder = OkHttpUtils.get().url(url);
        if (params != null) {
            getBuilder.params(params);
        }
        if (token != null) {
            getBuilder.addHeader("X-Authorization", "bearer " + token);
        }
        return getBuilder.build();
    }

    public RequestCall sendPostRequestData(String url, JSONObject params, MediaType mediaType) {
        String token = getToken();
        PostStringBuilder postStringBuilder = OkHttpUtils.postString().url(url);
        postStringBuilder.addHeader("X-Authorization", "bearer " + token);
        postStringBuilder.mediaType(mediaType);
        postStringBuilder.content(params.toString());
        return postStringBuilder.build();
    }

    public RequestCall sendPostRequestData(String url, JSONObject params) {
        String token = getToken();
        PostStringBuilder postStringBuilder = OkHttpUtils.postString().url(url);
        postStringBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
        postStringBuilder.addHeader("X-Authorization", "bearer " + token);
        postStringBuilder.content(params.toString());

        return postStringBuilder.build();
    }

    public void sendPostRequestData(String url, JSONObject params, final IGetResponseCodeListener listener) {
        String token = getToken();
        PostStringBuilder postStringBuilder = OkHttpUtils.postString().url(url);
        postStringBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
        postStringBuilder.addHeader("X-Authorization", "bearer " + token);
        postStringBuilder.content(params.toString());
        postStringBuilder.build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(final Response response, final int i) throws Exception {
                final int code = response.code();
                final String string = response.body().string();
                ApplicationHolder.getInstance().postMainRunnable(new Runnable() {
                    @Override
                    public void run() {
                        if(listener!=null){
                            listener.onSuccessResponse(code,string);
                        }
                    }
                });
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int i) {
                if(listener!=null){
                    listener.onFailedResponse(e.getMessage());
                }
            }

            @Override
            public void onResponse(Object o, int i) {

            }
        });
    }

    public void sendPostFileData(String url,File file, final IGetResponseCodeListener listener) {
        String token = getToken();
        PostFileBuilder postFileBuilder = OkHttpUtils.postFile();
        postFileBuilder.isFormSubmitFile = true;
        postFileBuilder.mediaType(MediaType.parse(MULTIPART_FORM_DATA));
        postFileBuilder.addHeader("X-Authorization", "bearer " + token);
        postFileBuilder.file(file);
        postFileBuilder.url(url);
        postFileBuilder.build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(final Response response, final int i) throws Exception {
                final int code = response.code();
                final String string = response.body().string();
                ApplicationHolder.getInstance().postMainRunnable(new Runnable() {
                    @Override
                    public void run() {
                        if(listener!=null){
                            listener.onSuccessResponse(code,string);
                        }
                    }
                });

                return null;
            }

            @Override
            public void onError(Call call, Exception e, int i) {
               if(listener!=null){
                   listener.onFailedResponse(e.getMessage());
               }
            }

            @Override
            public void onResponse(Object o, int i) {

            }
        });

    }
}
