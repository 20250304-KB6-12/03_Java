package ch08.sec014;

public class MediaPlayerDemo {
  public static void main(String[] args) {
    System.out.println("=== 자바 인터페이스 학습: 미디어 플레이어 예제 ===\n");

    // 1. 다양한 미디어 객체 생성
    MusicFile song1 = new MusicFile("Dynamite", "BTS");
    MusicFile song2 = new MusicFile("Blueming", "IU");
    VideoFile movie1 = new VideoFile("기생충", "봉준호", 132);
    StreamingService streamingService = new StreamingService("넷플릭스", true);

    // 2. 미디어 플레이어 생성
    MediaPlayer player = new MediaPlayer("MyPlayer");

    // 3. 인터페이스를 통한 다형성 보여주기
    System.out.println("\n=== 미디어 정보 ===");
    System.out.println(song1.getInfo());
    System.out.println(song2.getInfo());
    System.out.println(movie1.getInfo());
    System.out.println(streamingService.getServiceInfo());
    System.out.println(player.getPlayerInfo());

    // 4. 플레이리스트에 다양한 미디어 추가 (매개변수의 다형성)
    System.out.println("\n=== 플레이리스트 구성 ===");
    player.addMedia(song1);
    player.addMedia(song2);
    player.addMedia(movie1);

    // 스트리밍 서비스에 미디어 선택 후 플레이리스트에 추가
    streamingService.selectMedia("오징어 게임");
    player.addMedia(streamingService);

    // 5. 플레이어 기능 테스트
    System.out.println("\n=== 미디어 재생 테스트 ===");
    player.playNext(); // 첫 번째 미디어 (song1) 재생
    player.playNext(); // 두 번째 미디어 (song2) 재생

    // 6. 볼륨 조절 (디폴트 메서드 사용)
    System.out.println("\n=== 볼륨 조절 테스트 ===");
    song1.adjustVolume(80);
    song2.adjustVolume(120); // 최대값 초과
    System.out.println("볼륨 50은 유효한가? " + Playable.isValidVolume(50));
    System.out.println("볼륨 -10은 유효한가? " + Playable.isValidVolume(-10));

    // 7. 다운로드 기능 테스트
    System.out.println("\n=== 다운로드 기능 테스트 ===");
    player.playNext(); // 세 번째 미디어 (movie1) 재생
    player.downloadCurrent(); // 다운로드 가능 (VideoFile)
    movie1.showDownloadInfo(); // 재정의된 디폴트 메서드

    player.playNext(); // 네 번째 미디어 (streamingService) 재생
    player.downloadCurrent(); // 다운로드 가능 (StreamingService)

    player.playNext(); // 다시 첫 번째 미디어 (song1) 재생
    player.downloadCurrent(); // 다운로드 불가능 (MusicFile)

    // 8. 연결 기능 테스트
    System.out.println("\n=== 외부 기기 연결 테스트 ===");
    player.playNext(); // 두 번째 미디어 (song2) 재생
    player.connectToDevice("speaker"); // 연결 불가능 (MusicFile)

    player.playNext(); // 세 번째 미디어 (movie1) 재생
    player.connectToDevice("tv"); // 연결 불가능 (VideoFile)

    player.playNext(); // 네 번째 미디어 (streamingService) 재생
    player.connectToDevice("smartphone"); // 연결 가능 (StreamingService)

    // StreamingService 객체에 직접 접근
    System.out.println("\n=== 스트리밍 서비스 추가 테스트 ===");
    streamingService.disconnect();
    streamingService.selectMedia("마블 영화");
    streamingService.play();
    streamingService.connect("tv");

    // 9. 플레이어 정지
    System.out.println("\n=== 재생 종료 ===");
    player.stopCurrent();


  /*
    ## 인터페이스의 중요성과 장점

    1. **다형성(Polymorphism)**: `MediaPlayer` 클래스는 `Playable` 인터페이스를 구현한 어떤 객체든 재생 목록에 추가할 수 있습니다.
    2. **코드 재사용과 유연성**: 다양한 미디어 타입(음악, 비디오, 스트리밍)이 공통 인터페이스를 구현하여 일관된 방식으로 처리됩니다.
    3. **타입 안전성**: 인터페이스를 통해 객체의 기능을 명확히 정의하고, 적절한 기능만 사용할 수 있습니다.
    4. **확장성**: 새로운 미디어 타입이 추가되어도 기존 코드 수정 없이 `Playable` 인터페이스만 구현하면 시스템에 통합될 수 있습니다.
    5. **다중 인터페이스 구현**: 자바 클래스는 여러 인터페이스를 구현할 수 있어, 다양한 기능 조합이 가능합니다.
    6. **표준화**: 인터페이스는 개발자 간에 표준 계약을 정의하여 일관된 구현을 보장합니다.
  */
  }
}