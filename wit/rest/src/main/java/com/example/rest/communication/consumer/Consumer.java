package com.example.rest.communication.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import shared.Response;

@Component
public class Consumer {
    private Response mResponse;

    /**
     * Registers a listener to retrieve messages from the queue response.
     *
     * @param response the object retrieved from the queue. Contains the result of the operation.
     */
    @RabbitListener(queues = ConsumerConfig.QUEUE_NAME)
    public void receiveMessage(Response response) {
        System.out.println("Message received...");
        System.out.println("Result: " + response.getResult());
        mResponse = response;
    }

    public Response getResponse() {
        return mResponse;
    }
}