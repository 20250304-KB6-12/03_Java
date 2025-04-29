package ch14.sec05.exam03;

/**
 * 스레드 양보(yield) 기능을 시연하는 WorkThread 클래스
 * Thread.yield()를 사용하여 다른 스레드에게 실행 기회를 양보하는 방법을 보여줍니다.
 */
public class WorkThread extends Thread {
	// 필드: 작업 상태를 제어하는 플래그
	public boolean work = true;
	
	/**
	 * 생성자: 스레드의 이름을 설정함
	 * @param name 스레드의 이름
	 */
	public WorkThread(String name) {
		setName(name);
	}
	
	/**
	 * 스레드의 실행 코드를 포함하는 오버라이드된 run() 메소드
	 * work 변수의 값에 따라 다음과 같이 동작합니다:
	 * - true: 작업을 계속 처리하고 메시지 출력
	 * - false: Thread.yield()를 호출하여 다른 스레드에게 실행 기회를 양보
	 * 
	 * Thread.yield(): 
	 * - 현재 실행 중인 스레드는 다른 스레드에게 실행을 양보함
	 * - 실행 대기 상태로 전환되어 동일한 우선순위 이상의 다른 스레드가 실행될 기회를 제공
	 * - 다른 스레드의 실행이 끝나면 다시 실행 대기열에서 CPU를 할당받아 실행됨
	 */
	@Override
	public void run() {
		while(true) {
			if(work) {
				// work가 true이면 작업 처리
				System.out.println(getName() + ": 작업처리");
			} else {
				// work가 false이면 다른 스레드에게 실행 양보
				Thread.yield(); 
			}
		}
	}
}