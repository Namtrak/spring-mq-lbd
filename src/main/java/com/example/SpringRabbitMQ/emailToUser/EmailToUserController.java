package com.example.SpringRabbitMQ.emailToUser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/emailToUser")
public class EmailToUserController {

    @PostMapping
    public void sendEmailToUser() {
        System.out.println("command sendEmailToUser");
    }

}
