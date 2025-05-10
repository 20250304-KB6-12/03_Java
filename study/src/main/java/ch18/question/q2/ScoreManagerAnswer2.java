package ch18.question.q2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 실습 문제 2: 성적 관리 시스템 (Stream API 활용 정답)
 */
public class ScoreManagerAnswer2 {
  private static final String SCORE_FILE = "C:/Temp/scores.csv";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 파일이 존재하지 않으면 BOM이 있는 새 파일 생성
    try {
      File file = new File(SCORE_FILE);
      if (!file.exists()) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
          // UTF-8 BOM (EF BB BF) 추가
          fos.write(0xEF);
          fos.write(0xBB);
          fos.write(0xBF);
        }
      }
    } catch (IOException e) {
      System.out.println("파일 초기화 중 오류 발생: " + e.getMessage());
    }

    while (true) {
      System.out.println("\n==== 성적 관리 시스템 ====");
      System.out.println("1. 학생 성적 추가");
      System.out.println("2. 전체 성적 조회");
      System.out.println("3. 학생 검색");
      System.out.println("4. 성적 통계");
      System.out.println("5. 종료");
      System.out.print("선택: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // 버퍼 클리어

      try {
        switch (choice) {
          case 1:
            addStudent(scanner);
            break;
          case 2:
            showAllScores();
            break;
          case 3:
            searchStudent(scanner);
            break;
          case 4:
            calculateStatistics();
            break;
          case 5:
            System.out.println("프로그램을 종료합니다.");
            scanner.close();
            return;
          default:
            System.out.println("잘못된 선택입니다.");
        }
      } catch (IOException e) {
        System.out.println("파일 작업 중 오류가 발생했습니다: " + e.getMessage());
      }
    }
  }

  /**
   * 학생 성적 정보를 파일에 추가
   */
  public static void addStudent(Scanner scanner) throws IOException {
    System.out.print("학생 이름: ");
    String name = scanner.nextLine();

    // 점수 입력 및 유효성 검사
    int korean = getValidScore(scanner, "국어");
    int english = getValidScore(scanner, "영어");
    int math = getValidScore(scanner, "수학");

    // 파일에 추가 (append 모드)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE, true))) {
      writer.write(name + "," + korean + "," + english + "," + math);
      writer.newLine();
      writer.flush();
    }

    System.out.println("학생 성적이 추가되었습니다.");
  }

  /**
   * 유효한 점수 입력받기 (0-100 범위)
   */
  private static int getValidScore(Scanner scanner, String subject) {
    while (true) {
      System.out.print(subject + " 점수 (0-100): ");
      int score = scanner.nextInt();
      scanner.nextLine(); // 버퍼 클리어
      if (score >= 0 && score <= 100) {
        return score;
      }
      System.out.println("0-100 사이의 점수를 입력해주세요.");
    }
  }

  /**
   * 모든 학생의 성적과 통계 정보 출력
   */
  public static void showAllScores() throws IOException {
    List<Student> students = loadStudents();

    if (students.isEmpty()) {
      System.out.println("등록된 학생이 없습니다.");
      return;
    }

    System.out.println("\n==== 전체 성적 현황 ====");
    System.out.println("이름       국어 영어 수학 총점 평균");
    System.out.println("-".repeat(40));

    students.forEach(System.out::println);

    System.out.println("-".repeat(40));
    System.out.printf("전체 학생 수: %d명\n", students.size());
  }

  /**
   * 특정 학생의 성적 정보 검색
   */
  public static void searchStudent(Scanner scanner) throws IOException {
    System.out.print("검색할 학생 이름: ");
    String searchName = scanner.nextLine();

    List<Student> students = loadStudents();

    Optional<Student> foundStudent = students.stream()
            .filter(student -> student.getName().equals(searchName))
            .findFirst();

    if (foundStudent.isPresent()) {
      System.out.println("\n==== 검색 결과 ====");
      System.out.println("이름       국어 영어 수학 총점 평균");
      System.out.println("-".repeat(40));
      System.out.println(foundStudent.get());
    } else {
      System.out.println("해당 학생을 찾을 수 없습니다.");
    }
  }

  /**
   * 성적 통계 정보 계산하여 출력
   */
  public static void calculateStatistics() throws IOException {
    List<Student> students = loadStudents();

    if (students.isEmpty()) {
      System.out.println("등록된 학생이 없습니다.");
      return;
    }

    // 과목별 통계 계산
    // IntSummaryStatistics :  정수값들에 대한 통계 정보를 자동으로 계산하고 저장해주는 유틸리티 클래스
    IntSummaryStatistics koreanStats = students.stream()
            .mapToInt(Student::getKorean)
            .summaryStatistics();

    IntSummaryStatistics englishStats = students.stream()
            .mapToInt(Student::getEnglish)
            .summaryStatistics();

    IntSummaryStatistics mathStats = students.stream()
            .mapToInt(Student::getMath)
            .summaryStatistics();

    double totalAverage = students.stream()
            .mapToDouble(Student::getAverage)
            .average()
            .orElse(0);

    System.out.println("\n==== 성적 통계 ====");
    System.out.println("과목별 통계:");
    System.out.printf("국어 - 최고: %d, 최저: %d, 평균: %.2f\n",
            koreanStats.getMax(), koreanStats.getMin(), koreanStats.getAverage());
    System.out.printf("영어 - 최고: %d, 최저: %d, 평균: %.2f\n",
            englishStats.getMax(), englishStats.getMin(), englishStats.getAverage());
    System.out.printf("수학 - 최고: %d, 최저: %d, 평균: %.2f\n",
            mathStats.getMax(), mathStats.getMin(), mathStats.getAverage());
    System.out.printf("\n전체 학생 평균 점수: %.2f\n", totalAverage);
  }

  /**
   * 파일에서 모든 학생 정보 로드 (Stream API 활용)
   */
  private static List<Student> loadStudents() throws IOException {
    try {
      return Files.lines(Paths.get(SCORE_FILE))
              .map(line -> {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                  String name = parts[0];
                  int korean = Integer.parseInt(parts[1]);
                  int english = Integer.parseInt(parts[2]);
                  int math = Integer.parseInt(parts[3]);
                  return new Student(name, korean, english, math);
                }
                return null;
              })
              .filter(Objects::nonNull)
              .collect(Collectors.toList());
    } catch (IOException e) {
      // 파일이 없으면 빈 리스트 반환
      if (e.getMessage().contains("No such file")) {
        return new ArrayList<>();
      }
      throw e;
    }
  }
}