package com.example.SpringRabbitMQ.user;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public void createUser() {
        rabbitTemplate.convertAndSend("user_exchange", "user_routingKey", "USER_CREATED");
        System.out.println("(to user_queue) USER_CREATED");
    }
}
