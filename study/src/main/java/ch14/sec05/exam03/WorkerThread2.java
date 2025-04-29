package ch14.sec05.exam03;

public class WorkerThread2 implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      if (i % 2 == 0) {
        Thread.yield(); // 다른 스레드에게 실행 양보
      }
      System.out.println(Thread.currentThread().getName() + ": " + i);
    }
  }
}