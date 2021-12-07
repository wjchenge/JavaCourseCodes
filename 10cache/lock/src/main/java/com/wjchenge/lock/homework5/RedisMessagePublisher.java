package com.wjchenge.lock.homework5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

/**
 * @Author wj
 * @Date 2021/12/7 21:59
 */
@Service
public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ChannelTopic topic;

    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
