package ch03_class.basic.ch06.sec08.exam01;

public class Calculator {
    // 리턴값이 없는 메소드 선언
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    // 리턴값이 없는 메소드 선언
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    // 두 정수 값을 전달받고, 결과값 int를 리턴하는 메소드
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    // 두 정수 값을 전달받고, 결과값 double을 리턴하는 메소드
    double divide(int x, int y) {
        double result = (double) x / y;
        return result;
    }
}
