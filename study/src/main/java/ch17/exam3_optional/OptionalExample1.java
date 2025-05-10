package ch17.exam3_optional;

import java.util.Optional;

public class OptionalExample1 {
  public static void main(String[] args) {

    /* Optional 생성 */

    // 비어있는 Optional 생성
    Optional<String> empty = Optional.empty();

    // null이 아닌 값으로 Optional 생성
    Optional<String> opt = Optional.of("Hello");

    // null일 수도 있는 값으로 Optional 객체 생성(null이면 빈 Optional 반환)
    String maybeNull = null;
    Optional<String> nullable = Optional.ofNullable(maybeNull);

    System.out.println("empty = " + empty);
    System.out.println("opt = " + opt);
    System.out.println("nullable = " + nullable);
  }
}

