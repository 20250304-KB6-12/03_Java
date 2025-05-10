package ch16.exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
  public static void main(String[] args) {

    /* 정적(static) 메서드 참조 - 절대 값 구하기 */

    // 1) 익명 클래스
    Function<Integer, Integer> abs1 = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer integer) {
        return Math.abs(integer); // static 메서드
      }
    };

    System.out.println("abs1.apply(-10) = " + abs1.apply(-10));


    // 2) 람다식으로 변경
    Function<Integer, Integer> abs2 = integer -> Math.abs(integer);
    System.out.println("abs2.apply(-10) = " + abs2.apply(-10));

    // 3) 정적 메서드 참조로 변경
    // int Math.abs(integer) : 정수를 1개 전달 받아 정수 1개(절대값) 반환
    // == integer -> Math.abs(integer) 와 같은 모양, 같은 동작하는 메서드
    Function<Integer, Integer> abs3 = Math::abs;
    System.out.println("abs3.apply(-10) = " + abs3.apply(-10));



    /* 인스턴스 메서드 참조 - 문자열 소문자로 변경하기 */
    String str = "Hello World";

    // 1) 익명 클래스
    Supplier<String> lower1 = new Supplier<String>() {
      @Override
      public String get() {
        return str.toLowerCase();
      }
    };

    // 2) 람다식으로 변경
    Supplier<String> lower2 = () -> { return str.toLowerCase(); };

    // 3) 인스턴스 메서드 참조로 변경
    Supplier<String> lower3 = str::toLowerCase;

    System.out.println("lower1.get() = " + lower1.get());
    System.out.println("lower2.get() = " + lower2.get());
    System.out.println("lower3.get() = " + lower3.get());


    /* 특정 타입의 인스턴스 메서드 참조 - 문자열 길이 반환 
    * 
    * - 인스턴스 고정 x
    * - 같은 타입 (String)이 매개변수로 전달되어 오면
    *   해당 타입의 공통된 메서드(String.length())를 참조해서 수행
    * */

    // 람다식: (String s) -> s.length();
    // 람다식: String::length;
    Function<String, Integer> strLength = String::length;
    System.out.println("strLength : " + strLength.apply(str));

    System.out.println(strLength.apply("12345"));
    System.out.println(strLength.apply("hello!!!"));


    /* List 순차 접근 후 출력 */
    List<String> nameList = new ArrayList<>();
    nameList.add("John");
    nameList.add("Jane");
    nameList.add("Bob");
    nameList.add("Mary");

    // nameList 요소를 하나씩 꺼내 item에 저장 --> 출력
    nameList.forEach( item -> System.out.println(item) );
    System.out.println("---------------------------------");
    nameList.forEach(System.out::println);
    // System.out == PrintStream 타입 객체
    // println == void println(String str) 형태의 PrintStream 메서드
    // :: == 메서드 참조

    // System.out::println  ==  전달 받은 String 객체 출력

    // nameList.forEach(System.out::println);
    // == nameList의 모든 요소를 순차 접근 하면서
    //    각 요소를 System.out(PrintStream)의
    //    println(String str)의 매개변수로 전달하여 수행



    /* 매개변수 메서드 참조 */

    // 람다식
    BinaryOperator<Integer> operator1 = (a, b) -> a + b;
    System.out.println("sum1 : " + sumTwoNumbers(operator1, 10, 20));

    System.out.println("sum2 : " + sumTwoNumbers((a, b) -> a + b, 10, 20));

    // 내가 만든 정적 메서드 참조
    System.out.println("sum3 : " + sumTwoNumbers(MethodRefTest::sum, 10, 20));

    // Java 제공 int 2개 더하기 메서드
    System.out.println("sum4 : " + sumTwoNumbers(Integer::sum, 10, 20));

  }


  // BinaryOperator<T> : T 매개변수 2개 -> T 1개로 반환
  public static int sumTwoNumbers(BinaryOperator<Integer> op, int a, int b) {
    // (a, b) -> a + b
    return op.apply(a, b);
  }

  // 내가 만든 더하기 메서드(int 매개변수 2개 -> int 1개로 반환)
  public static int sum(int num1, int num2){
    return num1 + num2;
  }

}
