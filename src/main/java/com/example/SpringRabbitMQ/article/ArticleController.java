package com.example.SpringRabbitMQ.article;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public void addArticle() {
        rabbitTemplate.convertAndSend("article_exchange", "article_routingKey", "ARTICLE_CREATED");
        System.out.println("(to article_queue) ARTICLE_CREATED");
    }

    @PutMapping
    public void updateArticle() {
        rabbitTemplate.convertAndSend("article_exchange", "article_routingKey", "ARTICLE_UPDATED");
        System.out.println("(to article_queue) ARTICLE_UPDATED");
    }
}
