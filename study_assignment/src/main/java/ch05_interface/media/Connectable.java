package ch05_interface.media;

// 기기 간 연결 기능을 정의하는 인터페이스
public interface Connectable {
    
    // 추상 메서드
    void connect(String device);
    void disconnect();
    
    // 디폴트 메서드
    default boolean isSupported(String deviceType) {
        // 지원하는 기기 유형 확인 (예시)
        return "speaker".equalsIgnoreCase(deviceType) || 
               "headphone".equalsIgnoreCase(deviceType) || 
               "tv".equalsIgnoreCase(deviceType);
    }
}