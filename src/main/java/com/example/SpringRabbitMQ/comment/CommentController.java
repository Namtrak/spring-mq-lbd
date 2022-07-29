package com.example.SpringRabbitMQ.comment;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public void addComment() {
        rabbitTemplate.convertAndSend("comment_exchange", "comment_routingKey", "COMMENT_CREATED");
        System.out.println("(to comment_queue) COMMENT_CREATED");
    }

    @PutMapping
    public void updateComment() {
        rabbitTemplate.convertAndSend("comment_exchange", "comment_routingKey", "COMMENT_UPDATED");
        System.out.println("(to comment_queue) COMMENT_UPDATED");
    }

    @DeleteMapping
    public void deleteComment() {
        rabbitTemplate.convertAndSend("comment_exchange", "comment_routingKey", "COMMENT_DELETED");
        System.out.println("(to comment_queue) COMMENT_DELETED");
    }
}
