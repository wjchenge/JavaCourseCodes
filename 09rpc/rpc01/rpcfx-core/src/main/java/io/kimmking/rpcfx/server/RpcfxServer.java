package io.kimmking.rpcfx.server;

import io.kimmking.rpcfx.annotation.WjchengeService;
import io.kimmking.rpcfx.registry.RegistryCenter;
import io.kimmking.rpcfx.registry.ZookeeperRegistryCenter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @Author wj
 * @Date 2021/11/30 10:29
 */
public class RpcfxServer implements ApplicationContextAware,InitializingBean, DisposableBean {

    private static final String URL = "localhost:8080";
    
    private ApplicationContext applicationContext;

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> wjchengeServiceBean = applicationContext.getBeansWithAnnotation(WjchengeService.class);
        if (wjchengeServiceBean == null) return;
        for (Object bean : wjchengeServiceBean.values()) {
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            if (interfaces == null) continue;
            RegistryCenter center = new ZookeeperRegistryCenter();
            for (Class<?> anInterface : interfaces) {
                center.registry(anInterface.getName(), URL);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
