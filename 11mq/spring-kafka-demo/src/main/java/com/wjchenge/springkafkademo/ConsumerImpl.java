package com.wjchenge.springkafkademo;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl implements Consumer {


    @KafkaListener(topics = "order-test1", groupId = "java1-kimmking")
    @Override
    public void consumeOrder(String message) {
        Order order = JSON.parseObject(message, Order.class);
        System.out.println(" order = " + order);
    }

}
