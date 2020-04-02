package com.example.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerListener {

    //queue模式的消费者
/*    @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory = "queueListener")
    @SendTo("out.queqe")
    public String readActiveQueue(String message){
        System.out.println("queue接受到："+message);
        return "Ok";
    }


    @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory = "queueListener")
    @SendTo("out.queqe")
    public String readActiveQueueT(String message){
        System.out.println("queueT接受到："+message);
        return "Ok";
    }*/
}
