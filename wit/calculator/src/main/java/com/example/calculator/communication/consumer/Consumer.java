package com.example.calculator.communication.consumer;

import com.example.calculator.communication.producer.Producer;
import com.example.calculator.model.Calculator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import shared.Request;

/**
 * The Consumer class is responsible for retrieving messages from the Queue Request.
 */
@Component
public class Consumer {
    private Producer mProducer;

    public Consumer(Producer producer) {
        mProducer = producer;
    }

    /**
     * Registers a listener to retrieve messages from the queue request.
     *
     * @param request the object retrieved from the queue. Contains the two operands and the operation.
     */
    @RabbitListener(queues = ConsumerConfig.QUEUE_NAME)
    public void receiveMessage(Request request) {
        System.out.println("Message received...");
        System.out.println("Operand1: " + request.getOperand1() + " | Operand2: " + request.getOperand2() + " | Operation: " + request.getOperation());
        double result = Calculator.getResult(request.getOperand1(), request.getOperand2(), request.getOperation());
        mProducer.send(result);
    }
}
