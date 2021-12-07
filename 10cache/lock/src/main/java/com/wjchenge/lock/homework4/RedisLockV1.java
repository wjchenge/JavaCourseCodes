package com.wjchenge.lock.homework4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author wj
 * @Date 2021/12/5 13:30
 */
@Component
public class RedisLockV1 {

    private static final String LOCK = "v1";

    private static final long TIMEOUT = 60;

    private static final TimeUnit UNIT = TimeUnit.SECONDS;

    private static String UN_LOCK_LUA = "if redis.call('get',KEYS[1]) == ARGV[1] then\n" +
            "    return redis.call('del',KEYS[1])\n" +
            "else\n" +
            "    return 0\n" +
            "end";

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 分布式锁通用方法
     * 默认超时时间 60 秒
     * @param value 获取锁和释放锁的唯一标识
     * @return
     */
    public boolean getLock(String value) {
        return this.getLock(value, TIMEOUT, UNIT);
    }


    /**
     * 分布式锁
     * @param value 获取锁和释放锁的唯一标识
     * @param timeout 超时时间
     * @param unit 超时时间单位
     * @return
     */
    public boolean getLock(String value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(LOCK, value, timeout, unit);
    }


    public boolean unLock(String value) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(UN_LOCK_LUA);
        redisScript.setResultType(Long.TYPE);
        Object result = redisTemplate.execute(redisScript, Arrays.asList(LOCK), value);
        return result.equals(Long.valueOf(1));
    }

}
