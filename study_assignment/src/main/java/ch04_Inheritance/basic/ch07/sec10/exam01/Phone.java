package ch04_Inheritance.basic.ch07.sec10.exam01;

//public class Phone {
//    String owner;
//
//    // 생성자
//    Phone(String owner) {
//        this.owner = owner;
//    }
//
//    // 전원 켜기
//    void turnOn() {
//        System.out.println("폰 전원을 켭니다.");
//    }
//
//    // 전원 끄기
//    void turnOff() {
//        System.out.println("폰 전원을 끕니다.");
//    }
//}

// 추상클래스로 변환

public abstract class Phone {
    String owner;

    // 생성자
    Phone(String owner) {
        this.owner = owner;
    }

    // 전원 켜기
    void turnOn() {
        System.out.println("폰 전원을 켭니다.");
    }

    // 전원 끄기
    void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
