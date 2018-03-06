package com.xyc.guokhttps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import com.xyc.okhttputils.builder.PostFileBuilder;
import com.xyc.okhttputils.callback.Callback;
import com.xyc.okhttputils.callback.GenericsCallback;
import com.xyc.okhttputils.request.JsonGenericsSerializator;
import com.xyc.okhttputils.utils.OkHttpUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public final String URL = "http://192.168.1.14:9010/";
    private TextView tvContent;
    private String url_login = URL + "sign/login";
    private String url_shop = URL + "shopinfo";
    public String url_upload = URL + "oss/files/upload";
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tvContent);

    }
    public void loginClick(View view) {
        login();
    }

    public void getNetData(View view) {
        // getShopInfo(0, -1, -1, null);
        // submitLocationData();
        okHttpUpload();

    }

    private void login() {
        JSONObject params = new JSONObject();
        try {
            params.put("loginName", "test0126BDM");
            params.put("password", "a123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpUtils.postString()
                .url(url_login)
                .content(params.toString())
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new GenericsCallback<User>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("xyc", "onError: e=" + e.getMessage());
                        Log.d("xyc", "onError: thread=" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onResponse(User response, int id) {
                        Log.d("xyc", "onResponse: thread=" + Thread.currentThread().getName());
                        Log.d("xyc", "onResponse: response=" + response);
                        tvContent.setText(response.toString());
                        token = response.getToken();
                    }
                });
    }

    public void getShopInfo(int pageNumber, int creatorIds, int statuses, String name) {
        Map<String, String> params = new HashMap<>();

        if (creatorIds != -1) {
            params.put("creatorIds", String.valueOf(creatorIds));
        }
        if (statuses != -1) {
            params.put("statuses", String.valueOf(statuses));
        }
        params.put("pageNumber", String.valueOf(pageNumber));
        params.put("name", name);
        params.put("pageSize", String.valueOf(20));
        OkHttpUtils.get().url(url_shop).params(params)
                .addHeader("X-Authorization", "bearer " + token)
                .build()
                .execute(new GenericsCallback<CommonModel>(new JsonGenericsSerializator() {
                }) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("xyc", "getShopInfo-onError: thread=" + e.getMessage());
                        Log.d("xyc", "getShopInfo-onError: id=" + id);
                    }

                    @Override
                    public void onResponse(CommonModel response, int id) {
                        tvContent.setText(response.toString());
                        Log.d("xyc", "getShopInfo-onResponse: response=" + response);
                    }
                });

    }

    //LocationModel{latitude=23.148732, longitude=113.330478, address='林和西路9号', remark='null', province='广东省', provinceId=0, city='广州市', cityId=257, direct='天河区', directId=440106, street='null', streetId=0}
    public void submitLocationData() {
        JSONObject params = new JSONObject();
        try {
            params.put("id", 10337);
            params.put("provinceName", "广东省");
            params.put("cityName", "广州市");
            params.put("directName", "天河区");
            params.put("address", "林和西路9号");
            params.put("latitude", 23.148732);
            params.put("longitude", 113.330478);
            params.put("province", 0);
            params.put("city", 257);
            params.put("direct", 440106);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = URL + "shopinfo/position";
        OkHttpUtils.postString().content(params.toString()).mediaType(MediaType.parse("application/json; charset=utf-8"))
                .url(url)
                .addHeader("X-Authorization", "bearer " + token)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        int code = response.code();
                        Log.d("xyc", "parseNetworkResponse: string=" + string);
                        Log.d("xyc", "parseNetworkResponse: code=" + code);

                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("xyc", "parseNetworkResponse: e=" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Object response, int id) {

                        Log.d("xyc", "parseNetworkResponse: response=" + response);
                    }
                });

    }

    public final String MULTIPART_FORM_DATA = "image/*";       // 指明要上传的文件格式

    public void okHttpUpload() {

        String path = "/storage/emulated/0/DCIM/camera/IMG_20180301_141314.jpg";
        File file = new File(path);
        String url = url_upload;
        PostFileBuilder postFileBuilder = OkHttpUtils.postFile();
        postFileBuilder.isFormSubmitFile = true;
        postFileBuilder.mediaType(MediaType.parse(MULTIPART_FORM_DATA));

        postFileBuilder.file(file);
        postFileBuilder
                .url(url)
                .addHeader("X-Authorization", "bearer " + token)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        Log.d("xyc", "parseNetworkResponse: " + Thread.currentThread().getName());
                        Log.d("xyc", "parseNetworkResponse: response-code=" + response.code());
                        Log.d("xyc", "parseNetworkResponse: response-body=" + response.body().string());

                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("xyc", "onError: " + Thread.currentThread().getName());
                        Log.d("xyc", "onError: response=" + e.getMessage());

                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        Log.d("xyc", "onResponse: response=" + response);
                    }
                });
    }


}
