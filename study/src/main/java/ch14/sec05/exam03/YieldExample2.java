package ch14.sec05.exam03;

public class YieldExample2 {
  public static void main(String[] args) {
    // 첫 번째 스레드 생성
    Thread thread1 = new Thread(new WorkerThread2(), "Thread-1");
    // 두 번째 스레드 생성
    Thread thread2 = new Thread(new WorkerThread2(), "Thread-2");

    // 스레드 시작
    thread1.start();
    thread2.start();
  }
}
