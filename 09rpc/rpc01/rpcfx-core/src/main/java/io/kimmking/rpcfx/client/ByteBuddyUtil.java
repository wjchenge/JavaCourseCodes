package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.ByteBuddyParameter;
import io.kimmking.rpcfx.api.Filter;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.netty.NettyClient;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.This;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author wj
 * @Date 2021/11/22 15:48
 */
public class ByteBuddyUtil {


    @RuntimeType
    public Object invoke(@This Object proxy, @Origin Method method, @AllArguments @RuntimeType Object[] params) throws Throwable {

        ByteBuddyParameter buddyParameter = ByteBuddyParameterHolder.get();
        ByteBuddyParameterHolder.clear();

        // 加filter地方之二
        // mock == true, new Student("hubao");

        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(buddyParameter.getServiceClass().getName());
        request.setPackageName(buddyParameter.getPackageName());
        request.setMethod(method.getName());
        request.setParams(params);
        Filter[] filters = buddyParameter.getFilters();

        if (null!=filters) {
            for (Filter filter : filters) {
                if (!filter.filter(request)) {
                    return null;
                }
            }
        }

        RpcfxResponse response = post(request, buddyParameter.getUrl());

        // 加filter地方之三
        // Student.setTeacher("cuijing");

        // 这里判断response.status，处理异常\

        // 考虑封装一个全局的RpcfxException

        return JSON.parse(response.getResult().toString());
    }

    private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: "+reqJson);

        // 1.可以复用client
        // 2.尝试使用httpclient或者netty client
        String respJson = NettyClient.send(url, reqJson);
        System.out.println("resp json: "+respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }

}
