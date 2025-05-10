package ch18.sec07.exam02;

import java.io.*;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {

		// 1. Class.getResource()는 지정된 클래스 패스(/src/main/resources) 기준으로 파일 검색
		// -> 배포 가능 애플리케이션에 적합

		// 2. 디렉토리(working directory) 기준 파일 검색 방법
		// -> 로컬 프로젝트, 개발 단계 등 간단한 환경에서 사용
		BufferedReader br = new BufferedReader(
			new FileReader("src/main/java/ch18/sec07/exam02/ReadLineExample.java")
		);
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		
		br.close();
	}
}