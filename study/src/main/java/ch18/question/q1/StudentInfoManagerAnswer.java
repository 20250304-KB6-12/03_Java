package ch18.question.q1;

import java.io.*;

/**
 * 실습 문제 1: 학생 정보 관리 시스템 (정답)
 */
public class StudentInfoManagerAnswer {
  private static final String FILE_PATH = "C:/Temp/students.csv";

  public static void main(String[] args) {
    // 파일이 존재하지 않으면 BOM이 있는 새 파일
    // UTF8-BOM(Byte Order Mark) : 출력된 파일의 한글 깨짐 방지
    File file = new File(FILE_PATH);
    if (!file.exists()) {
      try (FileOutputStream fos = new FileOutputStream(file)) {
        // UTF-8 BOM (EF BB BF) 추가
        fos.write(0xEF);
        fos.write(0xBB);
        fos.write(0xBF);
      } catch (IOException e) {
        System.out.println("파일 초기화 중 오류 발생: " + e.getMessage());
      }
    }

    try {
      // 학생 정보 추가
      addStudent("홍길동", "2021001", "컴퓨터공학과");
      addStudent("김철수", "2021002", "경영학과");
      addStudent("이영희", "2021003", "디자인학과");

      // 모든 학생 정보 출력
      showAllStudents();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 학생 정보를 파일에 추가하는 메서드
   */
  public static void addStudent(String name, String studentId, String major) throws IOException {
    // FileWriter의 두 번째 인자로 true를 전달하면 파일에 추가(append)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {


      // 이름,학번,전공 형식으로 저장 (CSV 형식)
//    writer.write('\uFEFF'); // UTF8-BOM(Byte Order Mark) 추가 시 출력된 파일의 한글 깨짐 방지
      writer.write(name + "," + studentId + "," + major);
      writer.newLine(); // 줄바꿈 추가

      writer.flush();   // 버퍼 플러시

      System.out.println("학생 정보가 추가되었습니다: " + name + "(" + studentId + ")");
    }
  }

  /**
   * 파일에서 모든 학생 정보를 읽어와 출력하는 메서드
   */
  public static void showAllStudents() throws IOException {
    System.out.println("\n==== 전체 학생 정보 ====");
    System.out.printf("%-10s %-15s %-20s%n", "이름", "학번", "전공");
    System.out.println("-".repeat(45));

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      // 파일의 끝에 도달할 때까지 한 줄씩 읽기
      while ((line = reader.readLine()) != null) {
        // 쉼표(,)로 문자열 분리 (CSV 형식)
        String[] parts = line.split(",");

        // 분리된 데이터가 3개인지 확인 (이름, 학번, 전공)
        if (parts.length == 3) {
          String name = parts[0];
          String studentId = parts[1];
          String major = parts[2];

          // 정렬된 형식으로 출력
          System.out.printf("%-10s %-15s %-20s%n", name, studentId, major);
        }
      }
    }
    System.out.println("-".repeat(45));

        /* 선택적으로 Stream API를 사용할 수도 있음
        try {
            Files.lines(Paths.get(FILE_PATH))
                .map(line -> line.split(","))
                .filter(parts -> parts.length == 3)
                .forEach(parts -> {
                    System.out.printf("%-10s %-15s %-20s%n", parts[0], parts[1], parts[2]);
                });
        } catch (IOException e) {
            // 파일이 없는 경우 무시
            if (!e.getMessage().contains("No such file")) {
                throw e;
            }
        }
        */
  }
}