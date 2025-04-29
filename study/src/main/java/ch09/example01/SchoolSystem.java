package ch09.example01;

public class SchoolSystem {
  // 외부 클래스의 멤버 변수
  private String schoolName;

  // 생성자
  public SchoolSystem(String schoolName) {
    this.schoolName = schoolName;
  }

  // 외부 클래스의 메소드
  public void introduceSchool() {
    System.out.println(schoolName + "에 오신 것을 환영합니다!");
  }


  /**
   * 내부 클래스 (Inner Class)
   * 학교의 선생님을 나타냅니다.
   * 외부 클래스의 인스턴스와 연결되어 있습니다.
   */
  public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
      this.name = name;
      this.subject = subject;
    }

    public void introduce() {
      // 내부 클래스는 외부 클래스의 멤버에 직접 접근 가능합니다.
      System.out.println(schoolName + "의 " + subject + " 교사 " + name + "입니다.");
    }
  }



  /**
   * 중첩 인터페이스 (Nested Interface)
   * 학생 활동을 정의하는 인터페이스입니다.
   */
  public interface StudentActivity {
    void participate(); // 활동 참여 메소드
    String getActivityName(); // 활동 이름 반환 메소드
  }

  /**
   * 정적 중첩 클래스 (Static Nested Class)
   * 학교의 학생을 나타냅니다.
   * 외부 클래스의 인스턴스 없이도 생성 가능합니다.
   */
  public static class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
      this.name = name;
      this.grade = grade;
    }

    public void introduce() {
      System.out.println("안녕하세요! 저는 " + grade + "학년 " + name + "입니다.");
      // 주의: 정적 중첩 클래스는 외부 클래스의 인스턴스 변수에 직접 접근할 수 없습니다.
      // System.out.println("학교: " + schoolName); // 이 코드는 컴파일 에러를 발생시킵니다.
    }
  }



  /**
   * 중첩 인터페이스를 구현하는 내부 클래스
   * 학교의 클럽 활동을 나타냅니다.
   */
  public class Club implements StudentActivity {
    private String clubName;
    private int memberCount;

    public Club(String clubName, int memberCount) {
      this.clubName = clubName;
      this.memberCount = memberCount;
    }

    @Override
    public void participate() {
      System.out.println(schoolName + "의 " + clubName + " 활동에 참여합니다.");
      System.out.println("현재 회원 수: " + memberCount + "명");
    }

    @Override
    public String getActivityName() {
      return clubName;
    }
  }

  /**
   * 지역 내부 클래스 예제를 보여주는 메소드
   */
  public void organizeSportsDay() {
    final String eventName = "체육대회";

    /**
     * 지역 내부 클래스 (Local Inner Class)
     * 메소드 내에서만 사용되는 클래스입니다.
     */
    class SportEvent implements StudentActivity {
      private String sportName;

      public SportEvent(String sportName) {
        this.sportName = sportName;
      }

      @Override
      public void participate() {
        // 지역 내부 클래스는 외부 클래스의 멤버와 final 지역 변수에 접근 가능합니다.
        System.out.println(schoolName + "의 " + eventName + "에서 " + sportName + " 경기에 참여합니다.");
      }

      @Override
      public String getActivityName() {
        return eventName + ": " + sportName;
      }
    }

    // 지역 내부 클래스 사용
    SportEvent football = new SportEvent("축구");
    football.participate();

    // 익명 내부 클래스 (Anonymous Inner Class)
    StudentActivity basketball = new StudentActivity() {
      @Override
      public void participate() {
        System.out.println(schoolName + "의 " + eventName + "에서 농구 경기에 참여합니다.");
      }

      @Override
      public String getActivityName() {
        return eventName + ": 농구";
      }
    };

    basketball.participate();
  }



}
