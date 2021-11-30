package io.kimmking.rpcfx.registry;

/**
 * @Author wj
 * @Date 2021/11/30 17:49
 */
public interface RegistryCenter {


    /**
     * 服务接口全路径名称和服务地址对应关系
     * @param serviceClassName 服务接口全路径名称
     * @param url 服务地址
     */
    void registry(String serviceClassName,String url);
}
