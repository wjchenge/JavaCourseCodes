package io.kimmking.rpcfx.annotation;

import io.kimmking.rpcfx.server.RpcfxServer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author wj
 * @Date 2021/11/30 17:40
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(RpcfxServer.class)
public @interface EnableWjchengeRpc {
}
