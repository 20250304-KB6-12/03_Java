package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;       // NIO.2 파일 작업을 위한 유틸리티 클래스
import java.nio.file.Path;        // 파일 시스템 경로를 추상화한 인터페이스
import java.nio.file.Paths;       // Path 객체 생성을 위한 정적 메서드 제공 클래스

public class FilesExample {
	public static void main(String[] args) {
		try {
			String data = "" +
					"id: winter\n" +
					"email: winter@mycompany.com\n" +
					"tel:010-123-1234";
		
			// Path 객체 생성 - 파일 경로를 나타내는 객체 (실제 파일이 없어도 생성 가능)
			Path path = Paths.get("C:/Temp/user.txt");
			
			// 파일 생성 및 데이터 저장 - Files.writeString()은 편리한 한 줄 쓰기 메서드
			// 파일이 없으면 자동 생성, 이미 있으면 덮어쓰기됨
			Files.writeString(Paths.get("C:/Temp/user.txt"), data, Charset.forName("UTF-8"));
			
			// 파일 메타데이터 정보 얻기
			// probeContentType() - 파일 확장자로 MIME 타입 자동 추정
			System.out.println("파일 유형: " + Files.probeContentType(path));
			// size() - 파일 크기를 바이트 단위로 반환
			System.out.println("파일 크기: " + Files.size(path) + " bytes");
			
			// 파일 전체 내용 읽기 - Files.readString()은 한 번에 전체 내용을 문자열로 읽어옴
			// 특정 인코딩을 지정하여 올바른 문자 해석 가능
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
