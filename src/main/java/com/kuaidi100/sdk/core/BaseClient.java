package com.kuaidi100.sdk.core;

import com.kuaidi100.sdk.pojo.HttpResult;
import com.kuaidi100.sdk.request.BaseRequest;
import com.kuaidi100.sdk.response.BaseResponse;
import com.kuaidi100.sdk.utils.HttpUtils;

import java.util.Map;

/**
 * @Author: api.kuaidi100.com
 * @Date: 2020-11-25 16:02
 */
public abstract class BaseClient implements IBaseClient{

    private int connectTimeout = 3000;

    private int socketTimeout = 3000;

    public HttpResult execute(BaseRequest request, Map<String, String> header) throws Exception{

        return HttpUtils.doPost(getApiUrl(request),request,connectTimeout,socketTimeout, header);
    }

    public BaseResponse executeToObject(BaseRequest request) throws Exception{

        return null;
    }

    public void setTimeOut(int connectTimeout, int socketTimeout) {
        this.connectTimeout = connectTimeout;
        this.socketTimeout = socketTimeout;
    }

    public abstract String getApiUrl(BaseRequest request);

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }
}
