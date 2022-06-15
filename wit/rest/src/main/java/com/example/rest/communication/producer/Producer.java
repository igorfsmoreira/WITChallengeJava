package com.example.rest.communication.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import shared.Request;

/**
 * The Producer class is responsible for sending messages for the Queue Request.
 */
@Component
public class Producer {
    private final RabbitTemplate mRabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        mRabbitTemplate = rabbitTemplate;
    }

    /**
     * Sends a Request object to the exchange request.
     *
     * @param operand1  the first operand.
     * @param operand2  the second operand.
     * @param operation the operation.
     */
    public void send(double operand1, double operand2, String operation) {
        System.out.println("Sending request...");
        System.out.println("Operand1: " + operand1 + " | Operand2: " + operand2 + " | Operation: " + operation);
        Request request = new Request(operand1, operand2, operation);
        mRabbitTemplate.convertAndSend(ProducerConfig.TOPIC_EXCHANGE_REQUEST, ProducerConfig.ROUTING_KEY, request);
    }
}
