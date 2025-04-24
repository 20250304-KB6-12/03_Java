package ch07_exception_handling.basic.lecture.section02.exception;

public class MoneyNegativeException extends NegativeException{

    public MoneyNegativeException(String message) {
        super(message);
    }
}
