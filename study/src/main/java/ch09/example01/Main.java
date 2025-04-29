package ch09.example01;

public class Main {
  // 메인 메소드
  public static void main(String[] args) {
    // 외부 클래스 인스턴스 생성
    SchoolSystem mySchool = new SchoolSystem("국민고등학교");
    mySchool.introduceSchool();

    System.out.println("\n--- 내부 클래스 예제 ---");
    // 내부 클래스는 외부 클래스의 인스턴스 필요
    SchoolSystem.Teacher teacher1 = mySchool.new Teacher("이선생", "수학");
    teacher1.introduce();

    System.out.println("\n--- 정적 중첩 클래스 예제 ---");
    // 정적 중첩 클래스는 외부 클래스의 인스턴스 없이 생성 가능
    SchoolSystem.Student student1 = new SchoolSystem.Student("김학생", 2);
    student1.introduce();
    SchoolSystem.Student student2 = new SchoolSystem.Student("최학생", 1);
    student1.introduce();



    System.out.println("\n--- 중첩 인터페이스 구현 예제 ---");
    SchoolSystem.Club scienceClub = mySchool.new Club("과학부", 15);
    scienceClub.participate();

    System.out.println("\n--- 지역 내부 클래스와 익명 내부 클래스 예제 ---");
    mySchool.organizeSportsDay();
  }
}
