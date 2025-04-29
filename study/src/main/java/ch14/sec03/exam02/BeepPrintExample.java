package ch14.sec03.exam02;

public class BeepPrintExample extends Thread {

  @Override
  public void run() {
    // 스레드가 실행할 코드
    for(int i=0; i<5; i++) {
      System.out.println(i + "초");
      try {
        Thread.sleep(1000); // 1초 일시 정지
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    // 사용
    Thread thread = new BeepPrintExample();
    thread.start();
  }
}
