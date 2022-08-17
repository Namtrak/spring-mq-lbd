package com.example.SpringRabbitMQ.comment;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class CommentListener {

    @Bean
    public Consumer<String> receiveCommentMessages() {
        return (message) -> {
            System.out.println(message);
        };
    }
}
