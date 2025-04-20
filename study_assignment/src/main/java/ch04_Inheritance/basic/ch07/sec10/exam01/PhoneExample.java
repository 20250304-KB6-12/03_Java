package ch04_Inheritance.basic.ch07.sec10.exam01;

public class PhoneExample {
    public static void main(String[] args) {
        // 추상클래스는 객체생성 X
        //Phone phone = new Phone();
        SmartPhone smartPhone = new SmartPhone("홍길동");
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}