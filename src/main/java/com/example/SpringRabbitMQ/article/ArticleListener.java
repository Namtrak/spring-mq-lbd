package com.example.SpringRabbitMQ.article;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ArticleListener {

    @RabbitListener(queues = "article_queue")
    public void articleListener(String event) {
        System.out.println("(from article_queue) " + event);
    }
}
