package ch14.ex0;

/**
 * 스레드 경주 게임
 * 각 레이서(스레드)가 결승선을 향해 달리는 경주 게임입니다.
 * 기본적인 자바 스레드 개념(Runnable, Thread, 주요 메서드들)을 배우기 위한 예제입니다.
 */
public class ThreadRaceGame {
  public static final int RACE_DISTANCE = 20; // 경주 거리
  public static boolean gameFinished = false;  // 게임 종료 여부

  public static void main(String[] args) {
    System.out.println("🏁 스레드 경주 게임을 시작합니다! 🏁");
    System.out.println("각 레이서가 " + RACE_DISTANCE + "칸의 거리를 달리는 경주입니다.\n");

    // 3명의 레이서 생성 (모두 같은 Racer 클래스 사용)
    Thread racer1 = new Thread(new Racer("토끼"), "토끼");
    Thread racer2 = new Thread(new Racer("공룡"), "공룡");
    Thread racer3 = new Thread(new Racer("사자"), "사자");

    // 모든 레이서 시작
    System.out.println("🔫 경주를 시작합니다!\n");

    racer1.start();
    racer2.start();
    racer3.start();

    try {
      // join()으로 모든 레이서가 경주를 마칠 때까지 대기
//      System.out.println("\n모든 레이서들의 경주가 끝날 때까지 기다립니다...");
      racer1.join();
      racer2.join();
      racer3.join();

      System.out.println("\n🏁 경주가 종료되었습니다! 🏁");

    } catch (InterruptedException e) {
      System.out.println("메인 스레드가 인터럽트 되었습니다: " + e.getMessage());
      Thread.currentThread().interrupt();
    }
  }

  // 경주 진행 상황 시각화
  public static synchronized void printRaceProgress(String name, int position) {
    int adjustedPosition = Math.min(position, RACE_DISTANCE);
    System.out.print(name + ": ");

    String icon = null;
    switch (name){
      case "사자" : icon = "🦁"; break;
      case "토끼" : icon = "🐰"; break;
      case "공룡" : icon = "🦖"; break;
    }

    for (int i = 0; i < RACE_DISTANCE; i++) {
      if (i <= adjustedPosition) {
        System.out.print(icon);  // 이동한 거리
      } else {
        System.out.print("⬜");  // 남은 거리
      }
    }

    System.out.println(" " + adjustedPosition + "/" + RACE_DISTANCE);
  }
}