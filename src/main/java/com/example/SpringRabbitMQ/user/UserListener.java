package com.example.SpringRabbitMQ.user;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    @RabbitListener(queues = "user_queue")
    public void userListener(String event) {
        System.out.println("(from user_queue) " + event);
    }
}
