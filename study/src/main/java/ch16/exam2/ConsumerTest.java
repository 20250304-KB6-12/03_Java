package ch16.exam2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
  public static void main(String[] args) {
    
    // Consumer 계열 : 매개 변수 O, 반환형 X
    // - 매개변수를 소비

    // 익명 클래스
    Consumer<String> printString = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println("s = " + s);
      }
    };

    printString.accept("지금은 2시 11분");


    // 람다식으로 변경
    Consumer<String> printString2 = (s2) -> {
      System.out.println("s2 = " + s2);
    };

    printString2.accept("람다식으로 변경 성공!!");


    // BiConsumer<T, U> : 매개변수 T, U 두개 소비
    BiConsumer<String, Integer> printNameAge
      = (s, age) -> System.out.println("s = " + s + ", age = " + age);

    printNameAge.accept("홍길동", 25);
  }
}
