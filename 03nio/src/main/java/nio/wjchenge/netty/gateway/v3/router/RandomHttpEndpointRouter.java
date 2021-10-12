package nio.wjchenge.netty.gateway.v3.router;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 随机算法
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(Map<String, Integer> endpoints) {
        List<String> urls = endpoints.keySet().stream().collect(Collectors.toList());
        int size = endpoints.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
