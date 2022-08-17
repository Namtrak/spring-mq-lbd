package com.example.SpringRabbitMQ.article;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ArticleListener {

    @Bean
    public Consumer<String> receiveArticleMessages() {
        return (message) -> {
            System.out.println(message);
        };
    }
}
