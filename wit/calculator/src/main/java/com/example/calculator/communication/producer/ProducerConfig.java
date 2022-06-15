package com.example.calculator.communication.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProducerConfig {
    public static final String TOPIC_EXCHANGE_RESPONSE = "exchange-response";
    public static final String QUEUE_NAME = "queue-response";
    public static final String ROUTING_KEY = "response.foo.bar.#";

    /**
     * Returns a new AMQP queue.
     *
     * @return an object Queue for the responses.
     */
    @Bean
    Queue queueResponse() {
        return new Queue(QUEUE_NAME, false);
    }

    /**
     * Returns a new topic exchange.
     *
     * @return an object TopicExchange for the responses.
     */
    @Bean
    TopicExchange exchangeResponse() {
        return new TopicExchange(TOPIC_EXCHANGE_RESPONSE);
    }

    /**
     * Binds the Queue Response and Exchange Response.
     *
     * @param queueResponse    the Queue for the responses.
     * @param exchangeResponse the Exchange for the responses.
     */
    @Bean
    Binding bindingResponse(Queue queueResponse, TopicExchange exchangeResponse) {
        return BindingBuilder.bind(queueResponse).to(exchangeResponse).with(ROUTING_KEY);
    }
}
