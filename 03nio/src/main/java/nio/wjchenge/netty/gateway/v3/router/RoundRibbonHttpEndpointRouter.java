package nio.wjchenge.netty.gateway.v3.router;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 轮询算法
 * @Author wj
 * @Date 2021/10/11 17:26
 */
public class RoundRibbonHttpEndpointRouter implements HttpEndpointRouter{

    // 当前位置
    private static int POS = 0;

    @Override
    public synchronized String route(Map<String, Integer> endpoints) {
        List<String> urls = endpoints.keySet().stream().collect(Collectors.toList());
        if (POS >= endpoints.size()) {
            POS = 0;
        }

        return urls.get(POS++);
    }
}
