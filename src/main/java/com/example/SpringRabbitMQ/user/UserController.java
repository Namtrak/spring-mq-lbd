//package com.example.SpringRabbitMQ.user;
//
//import com.example.SpringRabbitMQ.configuration.UserSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//@EnableBinding(UserSource.class)
//public class UserController {
//
//    @Autowired
//    private UserSource userSource;
//
//    @PostMapping
//    public void createUser() {
//        userSource.userExchange().send(MessageBuilder.withPayload("USER_CREATED").build());
//        System.out.println("(to userExchange.userQueue) USER_CREATED");
//    }
//}
