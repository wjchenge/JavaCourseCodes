package com.wjchenge.lock.homework4;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author wj
 * @Date 2021/12/5 14:45
 */
@Component
public class RedisLockV2 {



    private static final String LOCK = "v2";

    private static final long TIMEOUT = 60;

    private static final TimeUnit UNIT = TimeUnit.SECONDS;

    @Autowired
    private RedissonClient redissonClient;


    /**
     * 分布式锁通用方法
     * 默认超时时间 60 秒
     * @return
     */
    public RLock getLock() {
        return this.getLock(TIMEOUT, UNIT);
    }


    /**
     * 分布式锁
     * @param timeout 超时时间
     * @param unit 超时时间单位
     * @return
     */
    public RLock getLock(long timeout, TimeUnit unit) {
        RLock lock = redissonClient.getLock(LOCK);
        lock.lock(timeout, unit);
        return lock;
    }


    public void unLock(RLock lock) {
        lock.unlock();
    }

}
