package ch05.sec12;

public class GradeExample {
    public static void main(String[] args) {
        // Grade 타입 변수 선언 및 A 등급 할당
        Grade myGrade = Grade.A;

        // 등급 정보 출력
        System.out.println("등급: " + myGrade);          // enum 상수 이름 출력
        System.out.println("점수: " + myGrade.getScore()); // 해당 등급의 점수 출력
        System.out.println("설명: " + myGrade.getDescription()); // 해당 등급의 설명 출력

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
