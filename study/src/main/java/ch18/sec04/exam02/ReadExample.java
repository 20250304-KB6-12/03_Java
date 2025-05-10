package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 문자 입력 스트림(Reader)을 사용한 파일 읽기 예제
 * 
 * 이 클래스는 문자 기반 입력 스트림인 FileReader를 사용하여 
 * 텍스트 파일을 두 가지 방식으로 읽는 방법을 보여줍니다:
 * 1. 한 문자씩 읽기
 * 2. 문자 배열로 읽기
 * 
 * 문자 기반 스트림은 텍스트 파일을 읽을 때 적합하며, 
 * 바이트 기반 스트림과 달리 문자 인코딩을 자동으로 처리합니다.
 */
public class ReadExample {
	public static void main(String[] args) {
		try {
			Reader reader = null;

			/**
			 * 방법 1: 한 문자씩 읽기
			 * 
			 * 1. FileReader 객체 생성 - 문자 입력 스트림 (파일에서 문자를 읽기 위한 스트림)
			 * 2. reader.read()로 한 문자씩 읽기
			 *    - 반환값: 읽은 문자의 유니코드 값 (int 타입)
			 *    - 파일 끝에 도달하면 -1 반환
			 * 3. 읽은 문자를 char로 캐스팅하여 출력
			 * 4. reader.close()로 스트림 닫기 (리소스 해제)
			 */
			reader = new FileReader("C:/Temp/test.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;  // 파일 끝에 도달하면 루프 종료
				System.out.print((char)data);  // int를 char로 변환하여 출력
			}
			reader.close();
			System.out.println();

			/**
			 * 방법 2: 문자 배열로 읽기
			 * 
			 * 1. FileReader 객체 생성 - 문자 입력 스트림
			 * 2. char 배열 생성 - 읽어온 문자를 저장할 버퍼
			 * 3. reader.read(data)로 문자 배열에 데이터 읽기
			 *    - 반환값: 실제로 읽은 문자 수
			 *    - 파일 끝에 도달하면 -1 반환
			 * 4. 읽은 문자 수만큼 배열에서 문자를 출력
			 * 5. reader.close()로 스트림 닫기 (리소스 해제)
			 * 
			 * 문자 배열로 읽는 방식은 한 문자씩 읽는 것보다 효율적입니다.
			 * 한 번에 여러 문자를 읽어 처리하므로 I/O 작업 횟수가 줄어듭니다.
			 */
			reader = new FileReader("C:/Temp/test.txt");
			char[] data = new char[100];  // 최대 100개 문자를 저장할 수 있는 버퍼
			while(true) {
				int num = reader.read(data);  // 배열에 문자들을 읽어서 저장하고, 읽은 문자 수 반환
				if(num == -1) break;  // 파일 끝에 도달하면 루프 종료
				for(int i=0; i<num; i++) {
					System.out.print(data[i]);  // 읽은 문자 수만큼 출력
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// 파일을 찾을 수 없을 때 발생하는 예외 처리
			e.printStackTrace();
		} catch (IOException e) {
			// 입출력 작업 중 오류가 발생했을 때의 예외 처리
			e.printStackTrace();
		}
	}
}
