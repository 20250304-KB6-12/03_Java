package adapter.adapter2;

/* 외부에서 제공되는 클래스 - 코드 변경 불가*/
public class Banner {

  private String string;

  public Banner(String string) {
    this.string = string;
  }

  public void showWithParen(){
    System.out.println("(" + string + ")");
  }

  public void showWithAster(){
    System.out.println("*" + string + "*");
  }
}
