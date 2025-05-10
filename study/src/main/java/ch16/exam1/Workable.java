package ch16.exam1;

// 함수형 인터페이스 : 추상 메서드가 1개인 인터페이스

// 함수형 인터페이스가 맞는지 검사하는 어노테이션
@FunctionalInterface
public interface Workable {
  void work();
}
