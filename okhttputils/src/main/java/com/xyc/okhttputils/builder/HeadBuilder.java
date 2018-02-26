package com.xyc.okhttputils.builder;

import com.xyc.okhttputils.request.OtherRequest;
import com.xyc.okhttputils.request.RequestCall;
import com.xyc.okhttputils.utils.OkHttpUtils;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
