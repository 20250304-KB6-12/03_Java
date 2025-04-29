package ch14.ex2;

import java.util.Random;

/**
 * 소 클래스: 주기적으로 우유를 생산합니다.
 */
public class Cow implements Runnable {
  private final Random random = new Random();

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " 하루 일과 시작!");


    while (CooperativeFarm.runningCheck) {
      try {
        // 우유 생산 시간 (2~4초)
        Thread.sleep(random.nextInt(2000) + 2000);

        // 우유 생산
        synchronized (CooperativeFarm.milkLock) {
          CooperativeFarm.milk += 2; // 소는 한 번에 2리터 생산
          System.out.println(Thread.currentThread().getName() + ": 음메~! 우유를 만들었어요! (현재 " + CooperativeFarm.milk + "리터)");
        }

      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println(Thread.currentThread().getName() + ": 목초지로 돌아갑니다~");
  }
}