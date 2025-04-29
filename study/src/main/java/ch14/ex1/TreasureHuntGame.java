package ch14.ex1;

/**
 * 간단한 보물 찾기 게임
 * 여러 탐험가(스레드)가 보물을 찾아 경쟁합니다.
 */
public class TreasureHuntGame {

  // 게임 실행 여부
  public static boolean gameRunning = true;

  // 남은 보물 수량
  public static int remainingTreasures = 20;

  // 보물에 대한 접근을 동기화하기 위한 락 객체
  public static final Object treasureLock = new Object();

  public static void main(String[] args) {
    System.out.println("🎮 보물 찾기 게임을 시작합니다! 🎮");
    System.out.println("총 " + remainingTreasures + "개의 보물이 숨겨져 있습니다.\n");

    // 5명의 탐험가(스레드) 생성 및 시작
    // 탐험가 객체 배열 생성
    Explorer[] explorerObjects = new Explorer[5];
    Thread[] explorers = new Thread[5];

    for (int i = 0; i < explorers.length; i++) {
      // 탐험가 객체 생성 및 저장
      explorerObjects[i] = new Explorer("탐험가 " + (i+1));
      // 스레드 생성 시 탐험가 객체 전달
      explorers[i] = new Thread(explorerObjects[i], "탐험가 " + (i+1));
      explorers[i].start();
    }

    // 게임이 끝날 때까지 대기
    try {
      // 최대 30초 동안 게임 실행
      Thread.sleep(30000);

      // 보물이 모두 발견되었는지 확인
      if (remainingTreasures <= 0) {
        System.out.println("\n🎉 모든 보물이 발견되었습니다!");
      } else {
        System.out.println("\n⏰ 시간 제한에 도달했습니다!");
        System.out.println("아직 " + remainingTreasures + "개의 보물이 남아있습니다.");
      }

      // 게임 종료 신호
      gameRunning = false;

      // 모든 탐험가 스레드가 종료될 때까지 대기
      for (Thread explorer : explorers) {
        explorer.join();
      }

      // 최종 결과 출력
      System.out.println("\n🏁 게임 종료! 결과:");

      // 게임 종료 후 결과 출력 시
      for (int i = 0; i < explorers.length; i++) {
        Explorer explorer = explorerObjects[i];
        System.out.println(explorer.getName() + ": " + explorer.getFoundTreasures() + "개의 보물 발견!");
      }

    } catch (InterruptedException e) {
      System.out.println("게임이 예상치 못하게 중단되었습니다!");
    }
  }
}