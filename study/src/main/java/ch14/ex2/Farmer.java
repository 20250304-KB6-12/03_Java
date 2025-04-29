package ch14.ex2;

import java.util.Random;

/**
 * 농부 클래스: 달걀과 우유를 수확합니다.
 */
public class Farmer implements Runnable {
  private final Random random = new Random();

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " 하루 일과 시작!");


    while (CooperativeFarm.runningCheck) {
      try {
        // 수확 작업 시간 (1~2초)
        Thread.sleep(random.nextInt(1000) + 1000);

        // 무엇을 수확할지 랜덤하게 결정 (0: 달걀, 1: 우유)
        int task = random.nextInt(2);

        if (task == 0) {
          // 달걀 수확
          synchronized (CooperativeFarm.eggLock) {
            if (CooperativeFarm.eggs > 0) {
              int collected = Math.min(CooperativeFarm.eggs, random.nextInt(2) + 1);
              CooperativeFarm.eggs -= collected;
              System.out.println(Thread.currentThread().getName() + ": " + collected + "개의 달걀을 수확했어요! (남은 달걀: " + CooperativeFarm.eggs + "개)");
            } else {
              System.out.println(Thread.currentThread().getName() + ": 수확할 달걀이 없네요. 기다려야겠어요.");
            }
          }
        } else {
          // 우유 수확
          synchronized (CooperativeFarm.milkLock) {
            if (CooperativeFarm.milk > 0) {
              int collected = Math.min(CooperativeFarm.milk, random.nextInt(3) + 1);
              CooperativeFarm.milk -= collected;
              System.out.println(Thread.currentThread().getName() + ": " + collected + "리터의 우유를 수확했어요! (남은 우유: " + CooperativeFarm.milk + "리터)");
            } else {
              System.out.println(Thread.currentThread().getName() + ": 수확할 우유가 없네요. 기다려야겠어요.");
            }
          }
        }

      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println(Thread.currentThread().getName() + ": 오늘 하루도 수고했어요!");
  }
}