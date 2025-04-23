package adapter.adapter1;

/*
 * extends Banner(Adaptee) : 제공 받은 클래스 Banner를 상속 받음
 * implements Print(Target) : 클라이언트가 사용하고자 하는 Print 인터페이스를 구현
 *
 * class PrintBanner(Adapter) : Banner 클래스의 메서드를 Print 인터페이스에 맞추어 변환 == Adapter
 * */
public class PrintBanner extends Banner implements Print {
  public PrintBanner(String string) {
    super(string);
  }

  @Override
  public void printWeak() {
    showWithParen();
  }

  @Override
  public void printStrong() {
    showWithAster();
  }
}
