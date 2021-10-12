package nio.wjchenge.netty.gateway.v3.router;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author wj
 * @Date 2021/10/12 9:32
 */
class HttpEndpointRouterTest {

    public static final Map<String, Integer> WEIGHT_MAP = new HashMap<>();

    static {
        WEIGHT_MAP.put("server1", 20);
        WEIGHT_MAP.put("server2", 30);
        WEIGHT_MAP.put("server3", 50);
    }


    /**
     * 随机算法测试
     */
    @Test
    void RandomHttpEndpointRouterTest() {
        RandomHttpEndpointRouter router = new RandomHttpEndpointRouter();
        this.routerTest(router);

    }

    /**
     * 轮询算法测试
     */
    @Test
    void RoundRibbonHttpEndpointRouterTest() {
        RoundRibbonHttpEndpointRouter router = new RoundRibbonHttpEndpointRouter();
        this.routerTest(router);

    }

    /**
     * 随机权重算法测试
     */
    @Test
    void WeightRandomHttpEndpointRouterTest() {
        WeightRandomHttpEndpointRouter router = new WeightRandomHttpEndpointRouter();
        this.routerTest(router);

    }

    private void routerTest(HttpEndpointRouter router) {

        for (int i = 0; i < 10; i++) {
            Map<String, Integer> statisticMap = new HashMap<>();
            for (int j = 0; j < 10000; j++) {
                String server = router.route(WEIGHT_MAP);
                if (!statisticMap.containsKey(server)) statisticMap.put(server, 0);
                Integer count = statisticMap.get(server);
                statisticMap.put(server, count + 1);
            }

            System.out.println(statisticMap);
        }


    }


}