package com.example.rest.controller;

import com.example.rest.communication.consumer.Consumer;
import com.example.rest.communication.producer.Producer;
import com.example.rest.model.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rest.model.Operation.*;

/**
 * Controller to manage HTTP requests for a specific end point.
 */
@RestController
public class Controller {
    private static final String ENDPOINT_ADDITION = "/addition";
    private static final String ENDPOINT_SUBTRACTION = "/subtraction";
    private static final String ENDPOINT_MULTIPLICATION = "/multiplication";
    private static final String ENDPOINT_DIVISION = "/division";
    private static final int WAIT_MILLISECONDS = 100;
    private Producer mProducer;
    private Consumer mConsumer;

    public Controller(Producer producer, Consumer consumer) {
        mProducer = producer;
        mConsumer = consumer;
    }

    /**
     * Returns an Operation object that contains the result of the addition of two operands.
     *
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the result for the addition.
     * <p>
     * Example: localhost:8080/addition?operand1=100&operand2=250
     */
    @GetMapping(ENDPOINT_ADDITION)
    public Operation addition(@RequestParam(value = "operand1", defaultValue = "0") String operand1,
                              @RequestParam(value = "operand2", defaultValue = "0") String operand2) {
        double value1 = stringToDouble(operand1);
        double value2 = stringToDouble(operand2);

        mProducer.send(value1, value2, ADDITION);

        try {
            Thread.sleep(WAIT_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Operation(mConsumer.getResponse().getResult());
    }

    /**
     * Returns an Operation object that contains the result of the subtraction of two operands.
     *
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the result for the subtraction.
     * <p>
     * Example: localhost:8080/subtraction?operand1=100&operand2=250
     */
    @GetMapping(ENDPOINT_SUBTRACTION)
    public Operation subtraction(@RequestParam(value = "operand1", defaultValue = "0") String operand1,
                                 @RequestParam(value = "operand2", defaultValue = "0") String operand2) {
        double value1 = stringToDouble(operand1);
        double value2 = stringToDouble(operand2);

        mProducer.send(value1, value2, SUBTRACTION);

        try {
            Thread.sleep(WAIT_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Operation(mConsumer.getResponse().getResult());
    }

    /**
     * Returns an Operation object that contains the result of the multiplication of two operands.
     *
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the result for the multiplication.
     * <p>
     * Example: localhost:8080/multiplication?operand1=100&operand2=250
     */
    @GetMapping(ENDPOINT_MULTIPLICATION)
    public Operation multiplication(@RequestParam(value = "operand1", defaultValue = "0") String operand1,
                                    @RequestParam(value = "operand2", defaultValue = "0") String operand2) {
        double value1 = stringToDouble(operand1);
        double value2 = stringToDouble(operand2);

        mProducer.send(value1, value2, MULTIPLICATION);

        try {
            Thread.sleep(WAIT_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Operation(mConsumer.getResponse().getResult());
    }

    /**
     * Returns an Operation object that contains the result of the division of two operands.
     *
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the result for the division.
     * <p>
     * Example: localhost:8080/division?operand1=100&operand2=250
     */
    @GetMapping(ENDPOINT_DIVISION)
    public Operation division(@RequestParam(value = "operand1", defaultValue = "0") String operand1,
                              @RequestParam(value = "operand2", defaultValue = "0") String operand2) {
        double value1 = stringToDouble(operand1);
        double value2 = stringToDouble(operand2);

        mProducer.send(value1, value2, DIVISION);

        try {
            Thread.sleep(WAIT_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Operation(mConsumer.getResponse().getResult());
    }

    /**
     * Converts a string to double.
     *
     * @param operand the value to convert.
     * @return the value converted.
     */
    private double stringToDouble(String operand) {
        double value = 0;

        try {
            value = Double.parseDouble(operand);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return value;
    }
}

