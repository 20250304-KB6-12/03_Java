package ch6.sec14;

public class CarExample {
  public static void main(String[] args) {

    Car car = new Car(100, true);
//    return;
    System.out.println("car.speed = " + car.getSpeed());

    // 반환형 void == 반환 값 없음 -> return 생략
    // -> return이 생략되면 컴파일러가 컴파일 단계에서 자동 추가
    return;
  }
}
