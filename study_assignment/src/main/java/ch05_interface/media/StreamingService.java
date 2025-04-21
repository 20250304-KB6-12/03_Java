package ch05_interface.media;

// 스트리밍 서비스 클래스 - 세 개의 인터페이스 모두 구현
public class StreamingService implements Playable, Downloadable, Connectable {
    private String serviceName;
    private String currentMedia;
    private boolean isPremium;
    private boolean isPlaying;
    private String connectedDevice;

    public StreamingService() {
    }

    public StreamingService(String serviceName, boolean isPremium) {
        this.serviceName = serviceName;
        this.isPremium = isPremium;
        this.isPlaying = false;
        this.connectedDevice = null;
    }
    
    public void selectMedia(String mediaName) {
        this.currentMedia = mediaName;
        System.out.println(serviceName + "에서 '" + mediaName + "'를 선택했습니다.");
    }

    @Override
    public void play() {
        if (currentMedia == null) {
            System.out.println("재생할 미디어를 먼저 선택해주세요.");
            return;
        }
        this.isPlaying = true;
        System.out.println(serviceName + "에서 '" + currentMedia + "'를 스트리밍합니다.");
    }

    @Override
    public void pause() {
        if (isPlaying && currentMedia != null) {
            this.isPlaying = false;
            System.out.println(currentMedia + " 스트리밍을 일시 정지합니다.");
        }
    }

    @Override
    public void stop() {
        if (isPlaying && currentMedia != null) {
            this.isPlaying = false;
            System.out.println(currentMedia + " 스트리밍을 정지합니다.");
            this.currentMedia = null;
        }
    }

    @Override
    public void download() {
        if (currentMedia == null) {
            System.out.println("다운로드할 미디어를 먼저 선택해주세요.");
            return;
        }

        if (isPremium) {
            System.out.println(currentMedia + "를 다운로드합니다. (프리미엄 사용자)");
        } else {
            System.out.println("프리미엄 사용자만 다운로드할 수 있습니다.");
        }
    }

    @Override
    public void connect(String device) {
        if (isSupported(device)) {
            this.connectedDevice = device;
            System.out.println(serviceName + "가 " + device + "에 연결되었습니다.");
        } else {
            System.out.println(device + "는 지원되지 않는 기기입니다.");
        }
    }

    @Override
    public void disconnect() {
        if (connectedDevice != null) {
            System.out.println(connectedDevice + "과/와 의 연결을 해제합니다.");
            this.connectedDevice = null;
        } else {
            System.out.println("연결된 기기가 없습니다.");
        }
    }

    // Connectable 인터페이스의 디폴트 메서드를 재정의
    @Override
    public boolean isSupported(String deviceType) {
        // 기본 지원 기기에 "smartphone"을 추가
        return Connectable.super.isSupported(deviceType) ||
               "smartphone".equalsIgnoreCase(deviceType);
    }

    public String getServiceInfo() {
        return serviceName + " 스트리밍 서비스 (" + (isPremium ? "프리미엄" : "무료") + " 요금제)";
    }
}