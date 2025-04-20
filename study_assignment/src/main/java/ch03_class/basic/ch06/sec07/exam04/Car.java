package ch03_class.basic.ch06.sec07.exam04;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // 생성자 선언

    // 1. 매개변수가 없는 생성자 (디폴트 생성자)
    Car() {
    }

    // 2. model만 가지는 생성자
    Car(String model) {
        this.model = model;
    }

    // 3. model과 color를 가지는 생성자
    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // 4. model, color, maxSpeed를 가지는 생성자
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
