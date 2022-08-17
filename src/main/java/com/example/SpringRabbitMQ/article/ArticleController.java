package com.example.SpringRabbitMQ.article;

import com.example.SpringRabbitMQ.configuration.ArticleSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private StreamBridge streamBridge;

    public ArticleController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public void addArticle() {
        streamBridge.send("articleExchange", "ARTICLE_CREATED");
        System.out.println("(to articleExchange.articleQueue) ARTICLE_CREATED");
    }

    @PutMapping
    public void updateArticle() {
        streamBridge.send("articleExchange", "ARTICLE_UPDATED");
        System.out.println("(to articleExchange.articleQueue) ARTICLE_UPDATED");
    }
}
