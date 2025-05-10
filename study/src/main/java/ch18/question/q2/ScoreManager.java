package ch18.question.q2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 실습 문제 2: 성적 관리 시스템
 * <p>
 * [문제]
 * 1. 학생들의 성적 정보를 파일에 저장하고 관리하는 시스템 구현
 * 2. 각 학생의 이름, 국어, 영어, 수학 점수를 입력받아 저장
 * 3. 파일에서 성적을 읽어와 통계 정보 제공
 * - 학생별 총점, 평균 계산
 * - 과목별 최고점, 최저점 찾기
 * - 전체 학생 평균 점수 계산
 * 4. 특정 학생의 성적 정보 검색 기능
 * <p>
 * [파일 형식]
 * 홍길동,85,90,78
 * 김철수,92,88,95
 * 이영희,78,95,82
 * <p>
 * [구현해야 할 메서드]
 * - addStudent(): 학생 성적 정보 추가
 * - showAllScores(): 모든 학생의 성적과 통계 출력
 * - searchStudent(): 특정 학생 검색
 * - calculateStatistics(): 성적 통계 계산
 * <p>
 * [사용할 클래스]
 * - BufferedReader, BufferedWriter (파일 입출력)
 * - Scanner (사용자 입력)
 * - List<Student> (학생 정보 저장용)
 */
public class ScoreManager {
  private static final String SCORE_FILE = "C:/Temp/scores.txt";

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
   *
   * @param scanner 사용자 입력용 스캐너
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void addStudent(Scanner scanner) throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 힌트:
    // 1. 이름, 국어, 영어, 수학 점수를 입력받기
    // 2. 입력값 유효성 검사 (점수는 0-100 범위)
    // 3. "이름,국어,영어,수학" 형식으로 파일에 저장 (append 모드)

  }

  /**
   * 모든 학생의 성적과 통계 정보 출력
   *
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void showAllScores() throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 힌트:
    // 1. 파일에서 모든 학생 정보 읽기
    // 2. Student 객체로 파싱
    // 3. 각 학생의 총점과 평균 계산
    // 4. 표 형식으로 정리하여 출력

  }

  /**
   * 특정 학생의 성적 정보 검색
   *
   * @param scanner 사용자 입력용 스캐너
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void searchStudent(Scanner scanner) throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 힌트:
    // 1. 검색할 학생 이름 입력받기
    // 2. 파일에서 해당 학생 찾기
    // 3. 찾으면 성적 정보 출력, 없으면 "찾을 수 없습니다" 출력

  }

  /**
   * 성적 통계 정보 계산하여 출력
   *
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void calculateStatistics() throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 힌트:
    // 1. 파일에서 모든 학생 정보 읽기
    // 2. 과목별 최고점, 최저점, 평균 계산
    // 3. 전체 학생의 평균 점수 계산
    // 4. 결과를 보기 좋게 정리하여 출력

  }
}

