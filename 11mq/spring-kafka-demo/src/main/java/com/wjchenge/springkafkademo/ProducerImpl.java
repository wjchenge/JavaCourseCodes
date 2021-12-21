package com.wjchenge.springkafkademo;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerImpl implements Producer {

    private final String topic = "order-test1";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(Order order) {
        ProducerRecord record = new ProducerRecord(topic, order.getId().toString(), JSON.toJSONString(order));
        kafkaTemplate.send(record);

    }
}