package com.example.rest.communication.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
    public static final String TOPIC_EXCHANGE_REQUEST = "exchange-request";
    public static final String QUEUE_NAME = "queue-request";
    public static final String ROUTING_KEY = "request.foo.bar.#";

    /**
     * Returns a new AMQP queue.
     *
     * @return an object Queue for the requests.
     */
    @Bean
    Queue queueRequest() {
        return new Queue(QUEUE_NAME, false);
    }

    /**
     * Returns a new topic exchange.
     *
     * @return an object TopicExchange for the requests.
     */
    @Bean
    TopicExchange exchangeRequest() {
        return new TopicExchange(TOPIC_EXCHANGE_REQUEST);
    }

    /**
     * Binds the Queue Request and Exchange Request.
     *
     * @param queueRequest    the Queue for the requests.
     * @param exchangeRequest the Exchange for the requests.
     */
    @Bean
    Binding bindingRequest(Queue queueRequest, TopicExchange exchangeRequest) {
        return BindingBuilder.bind(queueRequest).to(exchangeRequest).with(ROUTING_KEY);
    }
}
