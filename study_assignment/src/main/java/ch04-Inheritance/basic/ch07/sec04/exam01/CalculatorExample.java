package basic.ch07.sec04.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        int r = 7;

        Calculator calculator = new Calculator();
        System.out.println("Calculator 테스트");
        System.out.println("반지름: " + r);
        System.out.println("원 면적: " + calculator.areaCircle(r));
    }
}