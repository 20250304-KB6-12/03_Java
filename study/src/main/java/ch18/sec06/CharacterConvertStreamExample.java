package ch18.sec06;

import java.io.FileInputStream;      // 파일에서 바이트 단위로 데이터를 읽기 위한 클래스
import java.io.FileOutputStream;     // 파일에 바이트 단위로 데이터를 쓰기 위한 클래스
import java.io.InputStream;          // 바이트 입력 스트림의 최상위 추상 클래스
import java.io.InputStreamReader;    // 바이트 스트림을 문자 스트림으로 변환하는 브릿지 클래스
import java.io.OutputStream;         // 바이트 출력 스트림의 최상위 추상 클래스
import java.io.OutputStreamWriter;   // 문자 스트림을 바이트 스트림으로 변환하는 브릿지 클래스
import java.io.Reader;               // 문자 입력 스트림의 최상위 추상 클래스
import java.io.Writer;               // 문자 출력 스트림의 최상위 추상 클래스

/**
 * 문자 변환 스트림 사용 예제
 * - 바이트 스트림과 문자 스트림 간의 변환을 보여주는 클래스
 * - InputStreamReader와 OutputStreamWriter를 활용한 인코딩 처리 방법 소개
 */
public class CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		// 문자열을 파일에 쓰고, 다시 읽어와서 콘솔에 출력
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);  // 파일에서 읽어온 문자열 출력
	}
	
	/**
	 * 문자열을 파일에 쓰는 메소드
	 * @param str 파일에 쓸 문자열
	 * @throws Exception 입출력 예외 발생 가능
	 */
	public static void write(String str) throws Exception {
		// 1. 바이트 출력 스트림 생성 (파일에 바이트를 쓰기 위한 스트림)
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		
		// 2. 바이트 출력 스트림을 문자 출력 스트림으로 변환 (UTF-8 인코딩 사용)
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		
		// 3. 문자열 쓰기 (UTF-8로 인코딩되어 파일에 저장됨)
		writer.write(str);
		
		// 4. 버퍼에 남아있는 데이터를 모두 출력
		writer.flush();
		
		// 5. 사용한 자원 해제 (스트림 닫기)
		writer.close(); // OutputStreamWriter를 닫으면 내부의 OutputStream도 함께 닫힘
	}
	
	/**
	 * 파일에서 문자열을 읽는 메소드
	 * @return 파일에서 읽은 문자열
	 * @throws Exception 입출력 예외 발생 가능
	 */
	public static String read() throws Exception {
		// 1. 바이트 입력 스트림 생성 (파일에서 바이트를 읽기 위한 스트림)
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		
		// 2. 바이트 입력 스트림을 문자 입력 스트림으로 변환 (UTF-8 인코딩으로 해석)
		Reader reader = new InputStreamReader(is, "UTF-8");		
		
		// 3. 문자 데이터를 저장할 배열 생성 (최대 100자까지 읽을 수 있음)
		char[] data = new char[100];
		
		// 4. 파일에서 문자들을 읽어 배열에 저장하고, 실제로 읽은 문자 수를 반환
		int num = reader.read(data);
		
		// 5. 사용한 자원 해제 (스트림 닫기)
		reader.close(); // InputStreamReader를 닫으면 내부의 InputStream도 함께 닫힘
		
		// 6. char 배열을 문자열로 변환 (실제로 읽은 문자 수만큼만 변환)
		String str = new String(data, 0, num);
		
		// 7. 변환된 문자열 반환
		return str;
	}
}
