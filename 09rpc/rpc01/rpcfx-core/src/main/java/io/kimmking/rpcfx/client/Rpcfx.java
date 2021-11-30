package io.kimmking.rpcfx.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.*;
import io.kimmking.rpcfx.discovery.ServiceDiscovery;
import io.kimmking.rpcfx.discovery.ZookeeperServiceDiscovery;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.aop.framework.ProxyFactory;
import sun.reflect.misc.ReflectUtil;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;

public final class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking");
    }

    public static <T, filters> T createFromRegistry(final Class<T> serviceClass, final String packageName, Filter... filter) {

        // 加filte之一

        // curator Provider list from zk
        List<String> invokers = new ArrayList<>();
        // 1. 简单：从zk拿到服务提供的列表
        ServiceDiscovery serviceDiscovery = new ZookeeperServiceDiscovery();
        String url = serviceDiscovery.discovery(serviceClass.getName());

        // 2. 挑战：监听zk的临时节点，根据事件更新这个list（注意，需要做个全局map保持每个服务的提供者List）
        serviceDiscovery.registryWatch(serviceClass.getName());
//        List<String> urls = router.route(invokers);
//
//        String url = loadBalance.select(urls); // router, loadbalance

        return (T) create(serviceClass, packageName, url, filter);

    }

    public static <T> T create(final Class<T> serviceClass, final String packageName, final String url, Filter... filters) {

        // 0. 替换动态代理 -> 字节码生成
        //return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(), new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, packageName, url, filters));

        // 替换为 ByteBuddy
        ByteBuddyParameterHolder.set(new ByteBuddyParameter(serviceClass, packageName, url, filters));
        Class<? extends T> cls = new ByteBuddy()
                .subclass(serviceClass)
                .method(ElementMatchers.isDeclaredBy(serviceClass))
                .intercept(MethodDelegation.to(new ByteBuddyUtil()))
                .make()
                .load(serviceClass.getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();

        try {
            return (T) ReflectUtil.newInstance(cls);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
