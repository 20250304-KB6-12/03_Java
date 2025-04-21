package ch05_interface.media;

// 미디어 파일 재생 기능을 정의하는 기본 인터페이스
public interface Playable {
  // 상수 정의
  int MAX_VOLUME = 100;
  int MIN_VOLUME = 0;

  // 추상 메서드
  void play();
  void pause();
  void stop();

  // 디폴트 메서드
  default void adjustVolume(int volume) {
    if (volume < MIN_VOLUME) {
      System.out.println("볼륨이 최소값으로 설정되었습니다: " + MIN_VOLUME);
    } else if (volume > MAX_VOLUME) {
      System.out.println("볼륨이 최대값으로 설정되었습니다: " + MAX_VOLUME);
    } else {
      System.out.println("볼륨이 " + volume + "으로 설정되었습니다.");
    }
  }

  // 정적 메서드
  static boolean isValidVolume(int volume) {
    return volume >= MIN_VOLUME && volume <= MAX_VOLUME;
  }
}