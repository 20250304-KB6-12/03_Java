package ch14.ex1;

import java.util.Random;

/**
 * 탐험가 클래스: 보물을 찾아다니는 탐험가를 나타냅니다.
 */
public class Explorer implements Runnable {
  private final String name;
  private int foundTreasures = 0;
  private final Random random = new Random();

  /**
   * 탐험가 생성자
   * @param name 탐험가 이름
   */
  public Explorer(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(name + "가 보물 찾기를 시작합니다!");

    while (TreasureHuntGame.gameRunning) {
      try {
        // 탐험하는 시간 (1~3초)
        Thread.sleep(random.nextInt(2000) + 1000);

        // 보물을 찾을 확률 (70%)
        boolean foundTreasure = random.nextDouble() < 0.7;

        if (foundTreasure) {
          // 보물을 찾은 경우, 남은 보물 수량 확인 및 감소
          synchronized (TreasureHuntGame.treasureLock) {
            if (TreasureHuntGame.remainingTreasures > 0) {
              TreasureHuntGame.remainingTreasures--;
              foundTreasures++;

              System.out.println(name + "가 보물을 발견했습니다! (남은 보물: "
                      + TreasureHuntGame.remainingTreasures + "개)");

              // 보물이 모두 발견되면 게임 종료
              if (TreasureHuntGame.remainingTreasures <= 0) {
                System.out.println("마지막 보물을 " + name + "가 발견했습니다!");
                TreasureHuntGame.gameRunning = false;
                break;
              }
            }
          }
        } else {
          // 보물을 찾지 못한 경우
          System.out.println(name + "가 탐색했지만 아무것도 발견하지 못했습니다.");
        }

      } catch (InterruptedException e) {
        System.out.println(name + "의 탐험이 중단되었습니다!");
        break;
      }
    }

    System.out.println(name + "가 탐험을 마쳤습니다. 총 " + foundTreasures + "개의 보물을 발견했습니다!");
  }

  /**
   * 탐험가 이름 반환
   * @return 탐험가 이름
   */
  public String getName() {
    return name;
  }

  /**
   * 발견한 보물 수 반환
   * @return 발견한 보물 수
   */
  public int getFoundTreasures() {
    return foundTreasures;
  }
}