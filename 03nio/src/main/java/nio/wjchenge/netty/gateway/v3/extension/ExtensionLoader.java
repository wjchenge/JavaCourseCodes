package nio.wjchenge.netty.gateway.v3.extension;

import nio.wjchenge.netty.gateway.v3.filter.HttpRequestFilter;
import nio.wjchenge.netty.gateway.v3.router.HttpEndpointRouter;
import nio.wjchenge.netty.gateway.v3.router.RandomHttpEndpointRouter;

import java.util.*;

/**
 * @Author wj
 * @Date 2021/10/11 14:57
 */
public class ExtensionLoader {

    public static <T> List<T> getExtension(Class<T> clazz) {
        ServiceLoader<T> loader = ServiceLoader.load(clazz);
        Iterator<T> iterator = loader.iterator();
        List<T> list = new ArrayList<>();
        iterator.forEachRemaining(v -> list.add(v));
        return list;
    }

    public static <T> T getExtension(Class<T> clazz, T t) {
        List<T> list = getExtension(clazz);
        if (list == null || list.isEmpty()) {
            return t;
        }
        return list.get(0);
    }
}
