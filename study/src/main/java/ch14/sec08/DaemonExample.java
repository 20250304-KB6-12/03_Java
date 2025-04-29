package ch14.sec08;

/**
 * 데몬 스레드(Daemon Thread)의 사용법을 보여주는 예제 클래스
 * 
 * 데몬 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드로,
 * 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료됩니다.
 * 이 예제는 자동 저장 기능을 수행하는 데몬 스레드를 생성하고 실행하는 방법을 보여줍니다.
 */
public class DaemonExample {
	public static void main(String[] args) {
		// AutoSaveThread 객체 생성 (자동 저장 기능을 수행하는 스레드)
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		
		// 데몬 스레드로 설정
		// setDaemon(true)는 반드시 start() 메소드 호출 전에 설정해야 함
		autoSaveThread.setDaemon(true);
		
		// 스레드 시작
		// 이 시점부터 AutoSaveThread는 백그라운드에서 자동 저장 작업 수행
		autoSaveThread.start();
		
		// 메인 스레드 3초 동안 일시 정지
		// 이 동안 데몬 스레드인 autoSaveThread는 계속 실행됨
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// 스레드가 interrupt될 경우의 예외 처리 (여기서는 아무 작업도 하지 않음)
		}
		
		// 메인 스레드 종료 메시지 출력
		// 메인 스레드가 종료되면 데몬 스레드인 autoSaveThread도 함께 종료됨
		System.out.println("메인 스레드 종료");
		
		// 프로그램 종료
		// 메인 스레드가 종료되면 데몬 스레드는 자동으로 종료되므로
		// AutoSaveThread가 계속 실행 중이더라도 JVM은 종료됨
	}
}