package ch08.sec01;

public class Main {
  public static void main(String[] args) {
    TempImpl obj = new TempImpl("테스트 객체");

    // 상수 사용
    System.out.println("상수 MAX_SIZE: " + Temp.MAX_SIZE);
    System.out.println("상수 DEFAULT_NAME: " + Temp.DEFAULT_NAME);

    // 추상 메서드 구현 테스트
    obj.process();
    System.out.println("getName() 결과: " + obj.getName());
    System.out.println("calculate(10, 20) 결과: " + obj.calculate(10, 20));

    // 디폴트 메서드 테스트
    obj.printInfo();
    System.out.println("기본값: " + obj.getDefaultValue());

    // 정적 메서드 테스트
    Temp.printVersion();
    System.out.println("isValid(50): " + Temp.isValid(50));
    System.out.println("isValid(150): " + Temp.isValid(150));
  }
}
