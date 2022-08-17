package com.example.SpringRabbitMQ.comment;

import com.example.SpringRabbitMQ.configuration.CommentSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private StreamBridge streamBridge;

    public CommentController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public void addComment() {
        streamBridge.send("commentExchange-out-0", "COMMENT_CREATED");
        System.out.println("(to commentExchange.commentQueue) COMMENT_CREATED");
    }

    @PutMapping
    public void updateComment() {
        streamBridge.send("commentExchange", "COMMENT_UPDATED");
        System.out.println("(to commentExchange.commentQueue) COMMENT_UPDATED");
    }

    @DeleteMapping
    public void deleteComment() {
        streamBridge.send("commentExchange", "COMMENT_DELETED");
        System.out.println("(to commentExchange.commentQueue) COMMENT_DELETED");
    }
}
