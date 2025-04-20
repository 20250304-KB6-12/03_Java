package ch03_class.basic.ch06.sec10.exam01;

public class CalculatorExample {
    public static void main(String[] args) {

        // 클래스명.(정적변수)으로 바로 사용가능
        double result1 = 10 * 10 * Calculator.PI;

        // 클래스명.(정적메서드)로 바로 사용가능
        int result2 = Calculator.plus(10, 5);

        int result3 = Calculator.minus(10, 5);
        Calculator cal = new Calculator();

        cal.PI = 15;
        System.out.println(Calculator.PI);
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}