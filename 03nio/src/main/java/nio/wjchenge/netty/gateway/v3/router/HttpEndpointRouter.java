package nio.wjchenge.netty.gateway.v3.router;

import java.util.Map;

public interface HttpEndpointRouter {

    /**
     * 路由策略
     * @param endpoints key 具体服务url, value 服务配置的权重
     * @return
     */
    String route(Map<String, Integer> endpoints);
    
    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50
    
}
