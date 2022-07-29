package com.example.SpringRabbitMQ.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    /*ARTICLE ENDPOINT CONFIGURATION*/
    @Bean
    public Queue article_queue() {
        return new Queue("article_queue");
    }

    @Bean
    public TopicExchange article_exchange() {
        return new TopicExchange("article_exchange");
    }

    @Bean
    public Binding article_binding(Queue article_queue, TopicExchange article_exchange) {
        return BindingBuilder
                .bind(article_queue)
                .to(article_exchange)
                .with("article_routingKey");
    }

    /*COMMENT ENDPOINT CONFIGURATION*/
    @Bean
    public Queue comment_queue() {
        return new Queue("comment_queue");
    }

    @Bean
    public TopicExchange comment_exchange() {
        return new TopicExchange("comment_exchange");
    }

    @Bean
    public Binding comment_binding(Queue comment_queue, TopicExchange comment_exchange) {
        return BindingBuilder
                .bind(comment_queue)
                .to(comment_exchange)
                .with("comment_routingKey");
    }

    /*USER ENDPOINT CONFIGURATION*/
    @Bean
    public Queue user_queue() {
        return new Queue("user_queue");
    }

    @Bean
    public TopicExchange user_exchange() {
        return new TopicExchange("user_exchange");
    }

    @Bean
    public Binding user_binding(Queue user_queue, TopicExchange user_exchange) {
        return BindingBuilder
                .bind(user_queue)
                .to(user_exchange)
                .with("user_routingKey");
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
