package ch09.example02;

public class Main {
  public static void main(String[] args) {
    System.out.println("===== 간단한 어댑터 패턴 예제 =====\n");

    // 메시지 매니저 생성
    SimpleAdapterExample.MessageManager messageManager = new SimpleAdapterExample.MessageManager();

    // 기본 메시지 프린터 사용
    System.out.println("--- 기본 콘솔 출력 사용 ---");
    messageManager.showMessage("안녕하세요!");
    messageManager.showError("오류가 발생했습니다.");

    // 외부 로거 생성
    System.out.println("\n--- 외부 파일 로거 사용 ---");
    SimpleAdapterExample.FileLogger fileLogger = new SimpleAdapterExample.FileLogger();

    // 외부 로거를 어댑터를 통해 등록
    messageManager.useLogger(fileLogger);

    // 이제 동일한 메소드 호출이 외부 로거를 통해 처리됨
    messageManager.showMessage("새로운 메시지입니다.");
    messageManager.showError("새로운 오류입니다.");
  }

}
