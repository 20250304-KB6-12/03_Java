package ch07_exception_handling.basic.lecture.section02.exception;

public class NotEnoughMoneyException extends Exception{

    public NotEnoughMoneyException() {

    }
    public NotEnoughMoneyException(String message) {

        super(message);
    }
}
