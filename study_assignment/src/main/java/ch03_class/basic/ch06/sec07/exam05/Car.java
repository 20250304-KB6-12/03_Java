package ch03_class.basic.ch06.sec07.exam05;


public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // model만 받는 생성자 → model, "은색", 250으로 초기화
    Car(String model) {
        this(model, "은색", 250);  // 20라인 호출
    }

    // model, color 받는 생성자 → maxSpeed는 250으로 설정
    Car(String model, String color) {
        this(model, color, 250);  // 20라인 호출
    }

    // 최종 필드 초기화용 생성자
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
