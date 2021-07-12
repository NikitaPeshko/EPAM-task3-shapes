package by.peshko.shape.exception;

public class BallException extends Exception {
    public BallException() {
    }

    public BallException(String message) {
        super(message);
    }

    public BallException(Throwable throwable) {
        super(throwable);
    }

    public BallException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
