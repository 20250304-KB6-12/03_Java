package ch17.exam3_optional;

import java.util.Optional;

public class OptionalExample2 {
  public static void main(String[] args) {


    /* 값 접근 메서드 */

    Optional<String> opt = Optional.of("Hello");  // null이 아닌 값으로 Optional 생성
    Optional<String> empty = Optional.empty();  // 비어있는 Optional 생성

    // 값이 존재하면 반환, 없으면 NoSuchElementException
    String value1 = opt.get();
    // String value2 = empty.get();
    System.out.println("value1 = " + value1);

    // 값이 존재하면 반환, 없으면 기본값 반환
    String defaultValue1 = opt.orElse("default");
    String defaultValue2 = empty.orElse("default");
    System.out.println("defaultValue1 = " + defaultValue1);
    System.out.println("defaultValue2 = " + defaultValue2);

    // 값이 존재하면 반환, 없으면 Supplier로부터 값 가져옴
    String computed1 = opt.orElseGet(() -> "Supplier Default Value");
    String computed2 = empty.orElseGet(() -> "Supplier Default Value");
    System.out.println("computed1 = " + computed1);
    System.out.println("computed2 = " + computed2);

    // 값이 존재하면 반환, 없으면 지정된 예외 발생
    String throwException1 = opt.orElseThrow(() -> new IllegalArgumentException("값 없음"));
    String throwException2 = empty.orElseThrow(() -> new IllegalArgumentException("값 없음"));
    System.out.println("throwException1 = " + throwException1);


  }
}

