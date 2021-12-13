package com.wjchenge.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

/**
 * @Author wj
 * @Date 2021/12/13 23:38
 */
@Service
public class TopicProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    public void sendTopic(String message) {
        jmsMessagingTemplate.convertAndSend(topic, message);
    }
}
