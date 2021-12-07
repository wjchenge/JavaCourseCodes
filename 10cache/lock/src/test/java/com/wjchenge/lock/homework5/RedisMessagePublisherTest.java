package com.wjchenge.lock.homework5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author wj
 * @Date 2021/12/7 22:37
 */
@SpringBootTest
public class RedisMessagePublisherTest {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Test
    public void testOnMessage() throws Exception {
        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish(message);
        Thread.sleep(1000);
        assertTrue(RedisMessageSubscriber.messageList.get(0).contains(message));
    }

}