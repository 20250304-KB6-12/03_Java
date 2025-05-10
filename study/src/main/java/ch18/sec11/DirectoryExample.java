package ch18.sec11;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExample {
  public static void main(String[] args) throws IOException {
    System.out.println("==== 디렉토리 작업 시작 ====");
    
    // 디렉토리 생성 - 중간 경로가 없어도 자동으로 생성
    Path path = Paths.get("C:/Temp/images2/aaa/bbb/ccc");
    Files.createDirectories(path);
    System.out.println("디렉토리 생성: " + path + "\n");

    // 디렉토리 내용 순회
    System.out.println("==== C:/Temp 디렉토리 내용 ====");
    System.out.printf("%-10s %-20s %-15s%n", "타입", "이름", "크기");
    System.out.println("-".repeat(50));
    
    Path tempPath = Paths.get("C:/Temp");
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(tempPath)) {
      for (Path p : directoryStream) {
        String type = Files.isDirectory(p) ? "<DIR>" : " FILE";
        long size = Files.isDirectory(p) ? 0 : Files.size(p);
        String sizeStr = Files.isDirectory(p) ? "-" : size + " bytes";
        
        System.out.printf("%-10s %-20s %-15s%n", type, p.getFileName(), sizeStr);
      }
    }

    // 특정 패턴의 파일만 필터링
    System.out.println("\n==== txt 파일 필터링 결과 ====");
    try (DirectoryStream<Path> txtFilter = Files.newDirectoryStream(tempPath, "*.txt")) {
      for (Path p : txtFilter) {
        long size = Files.size(p);
        System.out.printf("%-20s %,d bytes%n", p.getFileName(), size);
      }
    }
    
    System.out.println("\n==== 작업 완료 ====");
  }
}
