package com.example.SpringRabbitMQ.comment;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CommentListener {

    @RabbitListener(queues = "comment_queue")
    public void commentListener(String event) {
        System.out.println("(from comment_queue) " + event);
    }
}
