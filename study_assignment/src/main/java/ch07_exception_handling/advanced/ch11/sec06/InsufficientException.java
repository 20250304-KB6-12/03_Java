package ch07_exception_handling.advanced.ch11.sec06;

public class InsufficientException extends Exception {

    public InsufficientException() {
    }
    public InsufficientException(String message) {

        super(message);

    }

}