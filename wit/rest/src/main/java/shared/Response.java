package shared;

import java.io.Serializable;

public class Response implements Serializable {
    private static final long serialVersionUID = 12345L;
    private final double mResult;

    public Response(double result) {
        mResult = result;
    }

    public double getResult() {
        return mResult;
    }
}
