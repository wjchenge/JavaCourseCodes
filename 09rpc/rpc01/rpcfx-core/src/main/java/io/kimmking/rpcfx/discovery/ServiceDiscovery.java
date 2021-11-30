package io.kimmking.rpcfx.discovery;

/**
 * @Author wj
 * @Date 2021/11/30 19:13
 */
public interface ServiceDiscovery {

    /**
     * 服务发现接口
     * @param serviceClassName 服务接口全路径名称
     * @return
     */
    String discovery(String serviceClassName);

    /**
     * 监听服务接口
     * @param serviceClassName 服务接口全路径名称
     */
    void registryWatch(String serviceClassName);
}
