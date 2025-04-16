package ch05.sec13;

public class GradeExample {
  public static void main(String[] args) {

    Grade myGrade = Grade.C;

    System.out.println("myGrade = " + myGrade);
    System.out.println("점수 : " + myGrade.getScore());
    System.out.println("설명 : " + myGrade.getDescription());

    // values() 메소드를 사용하여 모든 등급 정보 순회 및 출력
    for(Grade grade : Grade.values()) {
      System.out.printf("%s = %d점 (%s)%n",
              grade,                // 등급 이름
              grade.getScore(),     // 등급 점수
              grade.getDescription() // 등급 설명
      );
    }
  }
}
