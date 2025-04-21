package ch05_interface.media;

// 비디오 파일 클래스 - Playable, Downloadable 다중 인터페이스 구현
public class VideoFile implements Playable, Downloadable {
  private String title;
  private String director;
  private int duration; // 분 단위
  private boolean isPlaying;

  public VideoFile() {
  }

  public VideoFile(String title, String director, int duration) {
    this.title = title;
    this.director = director;
    this.duration = duration;
    this.isPlaying = false;
  }

  @Override
  public void play() {
    this.isPlaying = true;
    System.out.println("'" + title + "' 비디오를 재생합니다. (감독: " + director + ")");
  }

  @Override
  public void pause() {
    if (isPlaying) {
      this.isPlaying = false;
      System.out.println(title + " 비디오를 일시 정지합니다.");
    }
  }

  @Override
  public void stop() {
    if (isPlaying) {
      this.isPlaying = false;
      System.out.println(title + " 비디오를 정지합니다.");
    }
  }

  @Override
  public void download() {
    System.out.println(title + " 비디오를 다운로드합니다. (" + duration + "분)");
  }

  // 디폴트 메서드 재정의
  @Override
  public void showDownloadInfo() {
    System.out.println("이 비디오는 다운로드 가능합니다. 용량: " + (duration * 15) + "MB (추정)");
  }

  public String getInfo() {
    return "비디오: " + title + " (감독: " + director + ", 재생 시간: " + duration + "분)";
  }
}