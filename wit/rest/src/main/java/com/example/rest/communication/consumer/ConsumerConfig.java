package com.example.rest.communication.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConsumerConfig {
    public static final String TOPIC_EXCHANGE_RESPONSE = "exchange-response";
    public static final String QUEUE_NAME = "queue-response";
    public static final String ROUTING_KEY = "response.foo.bar.#";

    @Bean
    Queue queueResponse() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchangeResponse() {
        return new TopicExchange(TOPIC_EXCHANGE_RESPONSE);
    }

    @Bean
    Binding bindingResponse(Queue queueResponse, TopicExchange exchangeResponse) {
        return BindingBuilder.bind(queueResponse).to(exchangeResponse).with(ROUTING_KEY);
    }
}
