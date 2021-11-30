package io.kimmking.rpcfx.registry;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Author wj
 * @Date 2021/11/30 17:53
 */
public class ZookeeperRegistryCenter implements RegistryCenter {

    private static final String connectString = "localhost:2181";

    private static CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder().
                connectString(connectString).sessionTimeoutMs(2000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("registry")
                .build();
        curatorFramework.start();
    }

    @Override
    public void registry(String serviceClassName, String url) {
        String servicePath = "/" + serviceClassName;
        try {
            //判断节点是否存在
            if(curatorFramework.checkExists().forPath(servicePath)==null){
                curatorFramework.create().creatingParentsIfNeeded().
                        withMode(CreateMode.PERSISTENT).forPath(servicePath);
            }
            // servicePath/ip:port
            String addressPath = servicePath + "/" + url;
            curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(addressPath);
            System.out.println("服务注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
