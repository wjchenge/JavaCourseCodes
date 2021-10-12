package nio.wjchenge.netty.gateway.v3.router;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 随机权重
 * @Author wj
 * @Date 2021/10/11 17:36
 */
public class WeightRandomHttpEndpointRouter implements HttpEndpointRouter {

    private static final RandomHttpEndpointRouter RANDOM_HTTP_ENDPOINT_ROUTER = new RandomHttpEndpointRouter();

    /**
     * 总权重
     */
    private static volatile Integer TOTAL_WEIGHT = -1;

    /**
     * 是否所有的权重配置都相同
     */
    private static boolean SAME_WEIGHT = false;

    @Override
    public String route(Map<String, Integer> endpoints) {

        // 如果权重配置不相同才执行权重算法的逻辑
        if (!SAME_WEIGHT) {
            Set<Integer> tmpSet = new HashSet<>();
            // 双重检查机制初始化 TOTAL_WEIGHT 和 SAME_WEIGHT
            if (TOTAL_WEIGHT < 0) {
                synchronized (TOTAL_WEIGHT) {
                    if (TOTAL_WEIGHT < 0) {
                        for (Integer value : endpoints.values()) {
                            TOTAL_WEIGHT += value;
                            tmpSet.add(value);
                        }
                        // 如果去重后权重值等于1则说明配置的权重相同
                        if (tmpSet.size() == 1) {
                            SAME_WEIGHT = true;
                        }
                    }
                }
            }

            int randomPos = new Random().nextInt(TOTAL_WEIGHT);
            for (Map.Entry<String, Integer> entry : endpoints.entrySet()) {
                Integer weight = entry.getValue();
                if (randomPos < weight) {
                    return entry.getKey();
                }
                // 继续比较下个区间
                randomPos -= weight;
            }
        }

        return RANDOM_HTTP_ENDPOINT_ROUTER.route(endpoints);

    }
}
