package ch05_interface.media;

import java.util.ArrayList;
import java.util.List;

// 여러 종류의 미디어를 관리하는 플레이어 클래스
public class MediaPlayer {
    private String playerName;
    private List<Playable> playlist;
    private int currentIndex;

    public MediaPlayer() {
    }

    public MediaPlayer(String playerName) {
        this.playerName = playerName;
        this.playlist = new ArrayList<>();
        this.currentIndex = -1;
    }
    
    // Playable 인터페이스를 구현한 모든 객체 추가 가능
    public void addMedia(Playable media) {
        playlist.add(media);
        System.out.println("재생 목록에 미디어가 추가되었습니다. (현재 총 " + playlist.size() + "개)");
    }
    
    public void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("재생 목록이 비어 있습니다.");
            return;
        }
        
        currentIndex = (currentIndex + 1) % playlist.size();
        System.out.println("다음 미디어를 재생합니다...");
        playlist.get(currentIndex).play();
    }
    
    public void playPrevious() {
        if (playlist.isEmpty()) {
            System.out.println("재생 목록이 비어 있습니다.");
            return;
        }
        
        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        System.out.println("이전 미디어를 재생합니다...");
        playlist.get(currentIndex).play();
    }
    
    public void stopCurrent() {
        if (currentIndex >= 0 && currentIndex < playlist.size()) {
            playlist.get(currentIndex).stop();
        }
    }
    
    // 다운로드 가능한 미디어만 다운로드
    public void downloadCurrent() {
        if (currentIndex >= 0 && currentIndex < playlist.size()) {
            Playable currentMedia = playlist.get(currentIndex);

            // Playable, Downloadable 을 상속 받은 클래스인 경우
            if (currentMedia instanceof Downloadable) {
                ((Downloadable) currentMedia).download();
            } else {
                System.out.println("현재 미디어는 다운로드할 수 없습니다.");
            }
        }
    }
    
    // 연결 가능한 미디어만 기기에 연결
    public void connectToDevice(String deviceName) {
        if (currentIndex >= 0 && currentIndex < playlist.size()) {
            Playable currentMedia = playlist.get(currentIndex);
            
            if (currentMedia instanceof Connectable) {
                ((Connectable) currentMedia).connect(deviceName);
            } else {
                System.out.println("현재 미디어는 외부 기기에 연결할 수 없습니다.");
            }
        }
    }
    
    public String getPlayerInfo() {
        return playerName + " 미디어 플레이어 (재생 목록: " + playlist.size() + "개)";
    }
}