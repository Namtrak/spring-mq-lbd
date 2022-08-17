package com.example.SpringRabbitMQ.user;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class UserListener {

    @StreamListener(target = Sink.INPUT)
    public void receiveUserMessages(String message) {
        System.out.println("(from userExchange.userQueue) " + message);
    }
}
