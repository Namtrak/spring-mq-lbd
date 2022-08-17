package com.example.SpringRabbitMQ.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ArticleSource {
    @Output("articleChannel")
    MessageChannel articleExchange();
}
