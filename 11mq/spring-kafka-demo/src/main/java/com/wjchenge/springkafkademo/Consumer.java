package com.wjchenge.springkafkademo;

import org.springframework.kafka.annotation.KafkaListener;

public interface Consumer {

    void consumeOrder(String message);

    // add your interface method here

    // and then implement it

}
