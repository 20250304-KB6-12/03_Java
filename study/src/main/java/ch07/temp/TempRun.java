package ch07.temp;

public class TempRun {
  public static void main(String[] args) {

    Parent p = new Child(); // 다형성(업캐스팅)

    p.method();
    // 컴파일 단계 : p.method() -> Parent
    // == 정적 바인딩

    // 런타임 단계 : p.method() -> Child (실제 참조 중인 객체)
    // == 동적 바인딩
  }
}
