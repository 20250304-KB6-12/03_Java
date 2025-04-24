package ch07_exception_handling.basic.lecture.section02.exception;

public class PriceNegativeException extends NegativeException{

    public PriceNegativeException(String message) {
        super(message);
    }

}
