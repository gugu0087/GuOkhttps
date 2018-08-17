package com.xyc.guokhttps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import com.xyc.okhttputils.callback.Callback;
import com.xyc.okhttputils.callback.GenericsCallback;
import com.xyc.okhttputils.eventbus.InterceptCodeEvent;
import com.xyc.okhttputils.request.JsonGenericsSerializator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    public final String URL = "http://192.168.1.14:9010/";
    private TextView tvContent;
    private String url_login = URL + "sign/login";
    private String url_shop = URL + "shopinfo";
    public String url_upload = URL + "files/upload";
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginOutEvent(InterceptCodeEvent event) {
        int code = event.getCode();
        Log.d("xyc", "onLoginOutEvent: code=" + code);
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
        //okHttpUpload();
        getMyVerifyData();
    }

    private void login() {
        JSONObject params = new JSONObject();
        try {
            params.put("loginName", "test0117BDM");
            params.put("password", "a123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DataManager.getInstance().sendPostRequestData(url_login, params)
                .execute(new GenericsCallback<User>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Response response, Call call, Exception e, int id) {
                        Log.d("xyc", "onError: e=" + e.getMessage());
                    }

                    @Override
                    public void onResponse(User response, int id) {

                        PreferencesUtils.putString("token", response.getToken());
                        Log.d("xyc", "onResponse: response=" + response);
                        tvContent.setText(response.toString());
                    }
                });

    }

    public final String getMyVerifyData = URL + "shopinfo/myaudit";

    public void getMyVerifyData() {
        Map<String, String> map = new HashMap<>();
        map.put("status", String.valueOf(1));
        map.put("pageNumber", String.valueOf(0));
        map.put("pageSize", String.valueOf(20));
        DataManager.getInstance().sendGetRequestData(getMyVerifyData, map)
                .execute(new GenericsCallback<GetMyVerifyDataModel>(new JsonGenericsSerializator()) {
                            @Override
                            public void onError(Response response, Call call, Exception e, int i) {

                            }

                            @Override
                            public void onResponse(GetMyVerifyDataModel myVerifyDataModel, int i) {
                                // EventBus.getDefault().post(new MyVerifyEvent(myVerifyDataModel));
                                Log.d("xyc", "onResponse: myVerifyDataModel=" + myVerifyDataModel);

                                tvContent.setText(myVerifyDataModel.toString());

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
        DataManager.getInstance().sendGetRequestData(url_shop, params)
                .execute(new GenericsCallback<CommonModel>(new JsonGenericsSerializator() {
                }) {
                    @Override
                    public void onError(Response response, Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(CommonModel response, int id) {
                        tvContent.setText(response.toString());
                        Log.d("xyc", "getShopInfo-onResponse: response=" + response);
                    }

                });
    }

    public void okHttpUpload() {

        String path = "/storage/emulated/0/DCIM/camera/IMG_20180301_141314.jpg";
        File file = new File(path);
        String url = url_upload;
        DataManager.getInstance().sendPostFileData(url, file, new IGetResponseCodeListener() {
            @Override
            public void onSuccessResponse(int code, String response) {

            }

            @Override
            public void onFailedResponse(String msg) {

            }
        });
    }


}
