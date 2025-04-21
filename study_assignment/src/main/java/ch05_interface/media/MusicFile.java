package ch05_interface.media;

// 음악 파일 클래스 - Playable 단일 인터페이스 구현
public class MusicFile implements Playable {
    private String title;
    private String artist;
    private boolean isPlaying;
    
    public MusicFile(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.isPlaying = false;
    }

    @Override
    public void play() {
        this.isPlaying = true;
        System.out.println(artist + "의 '" + title + "' 음악을 재생합니다.");
    }

    @Override
    public void pause() {
        if (isPlaying) {
            this.isPlaying = false;
            System.out.println(title + " 음악을 일시 정지합니다.");
        }
    }

    @Override
    public void stop() {
        if (isPlaying) {
            this.isPlaying = false;
            System.out.println(title + " 음악을 정지합니다.");
        }
    }

    public String getInfo() {
        return "음악: " + title + " (아티스트: " + artist + ")";
    }
}