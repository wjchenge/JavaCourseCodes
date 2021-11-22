package io.kimmking.rpcfx.client;

import io.kimmking.rpcfx.api.ByteBuddyParameter;

/**
 * @Author wj
 * @Date 2021/11/22 16:00
 */
public class ByteBuddyParameterHolder {

    private static final ThreadLocal<ByteBuddyParameter> CONTEXT = new ThreadLocal<>();

    public static void set(ByteBuddyParameter byteBuddyParameter) {
        CONTEXT.set(byteBuddyParameter);
    }

    public static ByteBuddyParameter get() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }

}
