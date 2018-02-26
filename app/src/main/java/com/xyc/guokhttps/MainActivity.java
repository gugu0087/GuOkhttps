package com.xyc.guokhttps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import com.xyc.okhttputils.callback.GenericsCallback;
import com.xyc.okhttputils.request.JsonGenericsSerializator;
import com.xyc.okhttputils.utils.OkHttpUtils;
import com.xyc.okutils.views.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

public class MainActivity extends BaseActivity {
    public final String URL = "http://192.168.1.14:9010/";
    private TextView tvContent;
    private String url_login = URL + "sign/login";
    private String url_shop = URL + "shopinfo";
    private String token;

    @Override
    protected void initHeader() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCenterView(R.layout.activity_main);
        initView();
        MyGuApplication.getApp().addActivity(this);
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tvContent);

    }

    /**
     * login
     * post 请求
     * MediaType  application/json; charset=utf-8
     *
     * @param view
     */
    public void getNetData(View view) {
        getShopInfo(0, -1, -1, null);
        Activity currentActivity = MyGuApplication.getApp().getCurrentActivity();
        Log.d("xyc", "getNetData: currentActivity="+currentActivity);
    }

    public void loginClick(View view) {
        login();
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
                        Log.d("xyc", "onError: id=" + id);
                    }

                    @Override
                    public void onResponse(User response, int id) {
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
        OkHttpUtils.get()
                .url(url_shop)
                .params(params)
                .addHeader("X-Authorization", "bearer " + token)
                .build()
                .execute(new GenericsCallback<CommonModel>(new JsonGenericsSerializator() {
                }) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("xyc", "getShopInfo-onError: e=" + e.getMessage());
                        Log.d("xyc", "getShopInfo-onError: id=" + id);
                    }

                    @Override
                    public void onResponse(CommonModel response, int id) {
                        tvContent.setText(response.toString());
                        Log.d("xyc", "getShopInfo-onResponse: response=" + response);
                    }
                });

    }

}
