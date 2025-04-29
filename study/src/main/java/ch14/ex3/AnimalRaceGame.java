package ch14.ex3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 멀티스레드를 활용한 동물 경주 게임
 * 각 동물은 별도의 스레드로 동작하며 랜덤한 속도로 결승선을 향해 달립니다.
 */
public class AnimalRaceGame {

  // 경주에 참가하는 동물 수
  private static final int NUMBER_OF_ANIMALS = 2;
  // 결승선까지의 거리
  private static final int FINISH_LINE = 20;

  public static void main(String[] args) {
    System.out.println("🏁 동물 경주 게임을 시작합니다! 🏁");
    System.out.println("결승선까지의 거리: " + FINISH_LINE + "m\n");

    // 모든 스레드가 준비될 때까지 기다리는 래치
    CountDownLatch startSignal = new CountDownLatch(1);
    // 모든 동물이 경주를 마칠 때까지 기다리는 래치
    CountDownLatch finishSignal = new CountDownLatch(NUMBER_OF_ANIMALS);

    // 경주에 참여할 동물 배열
    // , "🐕 강아지", "🐱 고양이", "🐎 말"
    String[] animals = {"🐇 토끼", "🐢 거북이"};
    Thread[] racers = new Thread[NUMBER_OF_ANIMALS];

    // 각 동물에 대한 스레드 생성 및 시작
    for (int i = 0; i < NUMBER_OF_ANIMALS; i++) {
      racers[i] = new Thread(new AnimalRacer(animals[i], startSignal, finishSignal));
      racers[i].start();
    }

    // 3초 후에 경주 시작
    try {
      System.out.println("준비...");
      Thread.sleep(1000);
      System.out.println("준비...");
      Thread.sleep(1000);
      System.out.println("시작!");
      Thread.sleep(500);

      // 모든 동물들에게 시작 신호 보내기
      startSignal.countDown();

      // 모든 동물이 경주를 마칠 때까지 기다림
      finishSignal.await();
      System.out.println("\n모든 동물이 경주를 마쳤습니다!");

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 동물 경주자를 나타내는 Runnable 구현 클래스
   */
  static class AnimalRacer implements Runnable {
    private final String name;
    private final CountDownLatch startSignal;
    private final CountDownLatch finishSignal;
    private final Random random = new Random();

    public AnimalRacer(String name, CountDownLatch startSignal, CountDownLatch finishSignal) {
      this.name = name;
      this.startSignal = startSignal;
      this.finishSignal = finishSignal;
    }

    @Override
    public void run() {
      try {
        // 시작 신호를 기다림
        startSignal.await();

        // 경주 시작
        int position = 0;
        int totalTime = 0;

        while (position < FINISH_LINE) {
          // 각 동물은 랜덤한 속도로 움직임 (1~3m)
          int speed = random.nextInt(3) + 1;
          position += speed;

          // 결승선을 넘어가지 않도록 조정
          if (position > FINISH_LINE) {
            position = FINISH_LINE;
          }

          // 진행 상황 시각화
          StringBuilder progress = new StringBuilder("[");
          for (int i = 0; i < FINISH_LINE; i++) {
            if (i < position) {
              progress.append("=");
            } else if (i == position) {
              progress.append(name);
            } else {
              progress.append(" ");
            }
          }
          progress.append("] ").append(position).append("m");
          System.out.println(progress);

          // 0.1 ~ 0.5초 사이 대기 (각 동물의 속도 차이 표현)
          int sleepTime = random.nextInt(400) + 100;
          Thread.sleep(sleepTime);
          totalTime += sleepTime;
        }

        // 결승선 도착 메시지
        System.out.println(name + " 결승선 도착! 🎉 소요 시간: " + (totalTime / 1000.0) + "초");

      } catch (InterruptedException e) {
        System.out.println(name + "이(가) 경주 중 부상을 당했습니다!");
      } finally {
        // 경주를 마쳤음을 알림
        finishSignal.countDown();
      }
    }
  }
}
