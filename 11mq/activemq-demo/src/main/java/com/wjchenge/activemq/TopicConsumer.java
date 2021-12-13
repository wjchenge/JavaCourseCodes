package com.wjchenge.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author wj
 * @Date 2021/12/13 23:28
 */
@Component
public class TopicConsumer {


    @JmsListener(destination = "${topic.name}", containerFactory = "topicListenerFactory")
    public void receiveMessage(TextMessage textMessage) throws JMSException {
        System.out.println("topic 订阅 :" + textMessage.getText());
    }

}
