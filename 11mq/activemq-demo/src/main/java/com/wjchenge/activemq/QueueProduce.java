package com.wjchenge.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * @Author wj
 * @Date 2021/12/13 23:11
 */
@Service
public class QueueProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendQueue(String message) {
        jmsMessagingTemplate.convertAndSend(queue, message);
    }


}
