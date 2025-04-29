package ch14.ex2;

/**
 * 간단한 멀티스레드 협동 농장 시뮬레이션
 * 닭은 달걀을 낳고, 소는 우유를 생산하고, 농부는 이를 수확합니다.
 */
public class CooperativeFarm {

  // 공유 자원
  public static int eggs = 0;
  public static int milk = 0;
  public static boolean runningCheck = true;

  // 자원에 대한 동기화를 위한 락 객체
  public static final Object eggLock = new Object();
  public static final Object milkLock = new Object();

  public static void main(String[] args) {
    System.out.println("🧑‍🌾 협동 농장 시뮬레이션을 시작합니다! 🧑‍🌾");

    // 닭 스레드 생성 및 시작
    Thread chickenThread = new Thread(new Chicken(), "🐔 닭");
    chickenThread.start();

    // 소 스레드 생성 및 시작
    Thread cowThread = new Thread(new Cow(), "🐄 소");
    cowThread.start();

    // 농부 스레드 생성 및 시작
    Thread farmerThread = new Thread(new Farmer(), "👨‍🌾 농부");
    farmerThread.start();

    // 10초 동안 게임 실행
    try {
      Thread.sleep(10000);

      // 게임 종료 신호
      runningCheck = false;

      // 모든 스레드가 종료될 때까지 대기
      chickenThread.join();
      cowThread.join();
      farmerThread.join();

      // 최종 점수 출력
      System.out.println("\n🎮 게임 종료! 최종 점수:");
      System.out.println("달걀: " + eggs + "개");
      System.out.println("우유: " + milk + "리터");
      System.out.println("총점: " + (eggs + milk) + "점");

    } catch (InterruptedException e) {
      System.out.println("게임이 일찍 종료되었습니다!");
    }
  }
}