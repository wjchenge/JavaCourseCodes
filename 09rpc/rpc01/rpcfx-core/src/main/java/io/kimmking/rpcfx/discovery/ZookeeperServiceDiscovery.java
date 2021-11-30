package io.kimmking.rpcfx.discovery;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wj
 * @Date 2021/11/30 19:17
 */
public class ZookeeperServiceDiscovery implements ServiceDiscovery {

    private static final String connectString = "localhost:2181";

    private static CuratorFramework curatorFramework;

    private static  final Map<String, String> serviceRepos = new HashMap<>(); //服务地址的本地缓存

    {
        curatorFramework = CuratorFrameworkFactory.builder().
                connectString(connectString).sessionTimeoutMs(2000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("registry")
                .build();
        curatorFramework.start();
    }

    @Override
    public String discovery(String serviceClassName) {
        String path = "/" + serviceClassName;
        if(!serviceRepos.containsKey(serviceClassName)) {
            try {
                List<String> list = curatorFramework.getChildren().forPath(path);
                if (list == null || list.isEmpty()) return null;
                // 如果存在多个则取第一个
                serviceRepos.put(serviceClassName, list.get(0));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        return serviceRepos.get(serviceClassName);
    }

    public void registryWatch(final String serviceClassName) {
        String path = "/" + serviceClassName;
        PathChildrenCache nodeCache=new PathChildrenCache(curatorFramework, path,true);
        PathChildrenCacheListener nodeCacheListener= (curatorFramework1, pathChildrenCacheEvent) -> {
            System.out.println("客户端收到节点变更的事件");
            List<String> list = curatorFramework1.getChildren().forPath(path);// 再次更新本地的缓存地址
            if (list == null || list.isEmpty()) {
                serviceRepos.remove(serviceClassName);
            } else {
                // 如果存在多个则取第一个
                serviceRepos.put(serviceClassName, list.get(0));
            }

        };
        nodeCache.getListenable().addListener(nodeCacheListener);
        try {
            nodeCache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
