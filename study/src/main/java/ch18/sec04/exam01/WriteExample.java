package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 문자 출력 스트림(Writer)을 사용한 파일 쓰기 예제
 * 
 * 이 클래스는 문자 기반 출력 스트림인 FileWriter를 사용하여 
 * 텍스트 파일에 데이터를 쓰는 세 가지 방식을 보여줍니다:
 * 1. 한 문자씩 쓰기
 * 2. 문자 배열로 쓰기
 * 3. 문자열로 쓰기
 * 
 * 문자 기반 스트림은 텍스트 파일을 쓸 때 적합하며,
 * 바이트 기반 스트림과 달리 문자 인코딩을 자동으로 처리합니다.
 */
public class WriteExample {
	public static void main(String[] args) {
		try {
			/**
			 * 문자 기반 출력 스트림 생성
			 * 
			 * FileWriter: 텍스트 파일에 문자 데이터를 쓰기 위한 스트림
			 * - 파일이 존재하지 않으면 새로 생성
			 * - 파일이 이미 존재하면 기존 내용을 덮어씀
			 * - 두 번째 매개변수로 true를 전달하면 기존 내용에 추가(append) 가능
			 */
			Writer writer = new FileWriter("C:/Temp/test.txt");

			/**
			 * 방법 1: 한 문자씩 출력
			 * 
			 * writer.write(int c) 메소드 사용
			 * - 매개변수: 출력할 문자의 유니코드 값(int)
			 * - char 타입은 자동으로 int로 변환됨
			 */
			char a = 'A';
			writer.write(a);			
			char b = 'B';
			writer.write(b);

			/**
			 * 방법 2: 문자 배열로 출력
			 * 
			 * writer.write(char[] cbuf) 메소드 사용
			 * - 매개변수: 출력할 문자들이 저장된 배열
			 * - 배열의 모든 문자가 한 번에 출력됨
			 * - 배열의 일부만 출력하려면 writer.write(cbuf, off, len) 사용
			 */
			char[] arr = { 'C', 'D', 'E' };
			writer.write(arr);

			/**
			 * 방법 3: 문자열로 출력
			 * 
			 * writer.write(String str) 메소드 사용
			 * - 매개변수: 출력할 문자열
			 * - 문자열의 모든 문자가 한 번에 출력됨
			 * - 문자열의 일부만 출력하려면 writer.write(str, off, len) 사용
			 */
			writer.write("FGH");

			/**
			 * 버퍼에 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
			 * 
			 * Writer는 내부적으로 버퍼를 사용하여 데이터를 모았다가 한 번에 출력함
			 * flush()를 호출하지 않으면 버퍼에 있는 데이터가 출력되지 않을 수 있음
			 * 특히 프로그램이 정상적으로 종료되지 않는 경우 데이터 손실 가능성 있음
			 */
			writer.flush();

			/**
			 * 출력 스트림을 닫고 메모리 해제
			 * 
			 * close() 메소드는 내부적으로 flush()를 호출한 후 자원을 해제함
			 * 스트림을 더 이상 사용하지 않을 때는 반드시 close()를 호출해야 함
			 * 그렇지 않으면 자원 누수(resource leak)가 발생할 수 있음
			 */
			writer.close();
		} catch (IOException e) {
			// 입출력 작업 중 오류가 발생했을 때의 예외 처리
			e.printStackTrace();
		}
	}
}
