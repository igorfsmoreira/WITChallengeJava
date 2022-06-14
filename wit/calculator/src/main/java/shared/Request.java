package shared;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 12345L;
    private final double mOperand1;
    private final double mOperand2;
    private final String mOperation;

    public Request(double operand1, double operand2, String operation) {
        mOperand1 = operand1;
        mOperand2 = operand2;
        mOperation = operation;
    }

    public double getOperand1() {
        return mOperand1;
    }

    public double getOperand2() {
        return mOperand2;
    }

    public String getOperation() {
        return mOperation;
    }
}
