package nio.wjchenge.netty.gateway.v3.extension;

import nio.wjchenge.netty.gateway.v3.filter.HttpRequestFilter;

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

    public static void main(String[] args) {
        List<HttpRequestFilter> extension = ExtensionLoader.getExtension(HttpRequestFilter.class);
        System.out.println(Arrays.toString(extension.toArray()));
    }

}
