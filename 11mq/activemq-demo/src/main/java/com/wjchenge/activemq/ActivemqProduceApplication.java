package com.wjchenge.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqProduceApplication {

    private static QueueProduce queueProduce;

    private static TopicProduce topicProduce;

    @Autowired
    public void setQueueProduce(QueueProduce queueProduce) {
        ActivemqProduceApplication.queueProduce = queueProduce;
    }

    @Autowired
    public void setTopicProduce(TopicProduce topicProduce) {
        ActivemqProduceApplication.topicProduce = topicProduce;
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivemqProduceApplication.class, args);
        for (int i = 0; i < 10; i++) {
            queueProduce.sendQueue(i + " queue message .");
            topicProduce.sendTopic(i + " topic message .");
        }
    }

}
