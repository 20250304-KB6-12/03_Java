package adapter.adapter2;

public class Main {
  public static void main(String[] args) {

    // Adapter 패턴 실행 코드는 상속, 위임 모두 똑같음!
    Print p = new PrintBanner("Hello");
    p.printWeak();
    p.printStrong();
  }
}
