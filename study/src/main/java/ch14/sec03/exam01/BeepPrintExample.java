package ch14.sec03.exam01;

public class BeepPrintExample {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      try {
        System.out.println(i + "초");
        Thread.sleep(1000); //1초간일시정지
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
