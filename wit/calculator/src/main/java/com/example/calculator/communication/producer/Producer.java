package com.example.calculator.communication.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import shared.Response;

@Component
public class Producer {
    private final RabbitTemplate mRabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        mRabbitTemplate = rabbitTemplate;
    }

    /**
     * Sends an object Response that contains the result of the operation to the exchange response.
     *
     * @param result the result of the operation.
     */
    public void send(double result) {
        System.out.println("Sending message...");
        System.out.println("Result: " + result);
        mRabbitTemplate.convertAndSend(ProducerConfig.TOPIC_EXCHANGE_RESPONSE, ProducerConfig.ROUTING_KEY, new Response(result));
    }
}
