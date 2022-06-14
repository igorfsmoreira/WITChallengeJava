package com.example.calculator.communication.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    public static final String TOPIC_EXCHANGE_REQUEST = "exchange-request";
    public static final String QUEUE_NAME = "queue-request";
    public static final String ROUTING_KEY = "request.foo.bar.#";

    @Bean
    Queue queueRequest() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchangeRequest() {
        return new TopicExchange(TOPIC_EXCHANGE_REQUEST);
    }

    @Bean
    Binding bindingRequest(Queue queueRequest, TopicExchange exchangeRequest) {
        return BindingBuilder.bind(queueRequest).to(exchangeRequest).with(ROUTING_KEY);
    }
}
