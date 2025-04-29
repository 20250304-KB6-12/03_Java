package ch14.ex2;

import java.util.Random;

/**
 * 닭 클래스: 주기적으로 달걀을 생산합니다.
 */
public class Chicken implements Runnable {
  private final Random random = new Random();

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " 하루 일과 시작!");

    // 프로그램 실행 중인 경우
    while (CooperativeFarm.runningCheck) {
      try {
        // 달걀 생산 시간 (1~3초)
        Thread.sleep(random.nextInt(2000) + 1000);

        // 동기화(synchronized) 블럭 : 메서드 내 특정 코드에만 동기화 적용 시 사용하는 블럭
        // 달걀 생산
        synchronized (CooperativeFarm.eggLock) {
          CooperativeFarm.eggs++;
          System.out.println(Thread.currentThread().getName() + ": 꼬꼬댁! 달걀을 낳았어요! (현재 " + CooperativeFarm.eggs + "개)");
        }

      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println(Thread.currentThread().getName() + ": 오늘 일과 끝~");
  }
}