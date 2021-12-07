package com.wjchenge.lock.homework4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author wj
 * @Date 2021/12/6 21:14
 */
@Service
public class RedisStockServiceImpl implements StockService{

    private static final String STOCK_SIZE_KEY = "stock_size";

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    public void init(long size) {
        redisTemplate.opsForValue().set(STOCK_SIZE_KEY, size);
    }

    @Override
    public long getAndDecrement() {
        return redisTemplate.opsForValue().decrement(STOCK_SIZE_KEY);
    }
}
