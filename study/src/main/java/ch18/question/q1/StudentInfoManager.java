package ch18.question.q1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 실습 문제 1: 학생 정보 관리 시스템
 * <p>
 * [문제]
 * 1. 학생의 이름, 학번, 전공을 입력받아 "students.csv" 파일에 저장하는 기능 구현
 * 2. 파일에서 학생 정보를 읽어와 콘솔에 출력하는 기능 구현
 * 3. 파일 형식: "이름,학번,전공" (쉼표로 구분된 CSV 형식)
 * <p>
 * [구현해야 할 메서드]
 * - addStudent(String name, String studentId, String major): 학생 정보를 파일에 추가
 * - showAllStudents(): 파일의 모든 학생 정보 출력
 * <p>
 * [사용할 클래스]
 * - BufferedWriter, FileWriter (파일 쓰기용)
 * - BufferedReader, FileReader (파일 읽기용)
 */
public class StudentInfoManager {
  // 파일 경로 (클래스 레벨 상수로 정의)
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

    // 테스트 코드
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
   *
   * @param name      학생 이름
   * @param studentId 학번
   * @param major     전공
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void addStudent(String name, String studentId, String major) throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 1. BufferedWriter를 사용하여 파일에 "이름,학번,전공" 형식으로 저장 (CSV 형식)
    // 2. FileWriter의 두 번째 인자를 true로 설정 -> 파일에 추가(append)

  }


  /**
   * 파일에서 모든 학생 정보를 읽어와 출력하는 메서드
   *
   * @throws IOException 파일 작업 중 오류 발생 시
   */
  public static void showAllStudents() throws IOException {
    // TODO: 여기에 코드를 작성하세요
    // 1. BufferedReader를 사용하여 파일을 한 줄씩 읽기
    // 2. 읽은 데이터를 쉼표(,)로 분리 (CSV 형식)
    // 3. 이름, 학번, 전공 정보를 적절한 형식으로 출력

  }
}