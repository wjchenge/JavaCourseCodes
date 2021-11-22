package io.kimmking.rpcfx.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author wj
 * @Date 2021/11/22 16:03
 */
@Data
@AllArgsConstructor
public class ByteBuddyParameter {

    private final Class<?> serviceClass;
    private final String packageName;
    private final String url;
    private final Filter[] filters;
}
