package ch05_interface.media;

// 추가 기능을 정의하는 인터페이스
public interface Downloadable {
    
    // 추상 메서드
    void download();
    
    // 디폴트 메서드
    default void showDownloadInfo() {
        System.out.println("다운로드 기능이 지원됩니다.");
    }
}