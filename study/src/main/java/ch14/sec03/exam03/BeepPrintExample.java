package ch14.sec03.exam03;

public class BeepPrintExample {

  public static void main(String[] args) {

    // Runnable 인터페이스 구현 객체 사용
    Thread thread = new Thread(new Runnable() { // 익명 객체 구현
      @Override
      public void run() {
        // 스레드가 실행할 코드
        for (int i = 0; i < 5; i++) {
          System.out.println(i + "초");
          try {
            Thread.sleep(1000); // 0.5초 일시 정지
          } catch (Exception e) {
          }
        }
      }
    });
    
    thread.start(); // 작업 스레드 실행
  }
}
