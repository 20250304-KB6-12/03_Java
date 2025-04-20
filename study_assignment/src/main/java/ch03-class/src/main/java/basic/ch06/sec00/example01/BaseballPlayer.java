package basic.ch06.sec00.example01;

public class BaseballPlayer {
    // 필드 선언
    String name;
    String position;
    int uniformNumber;
    double battingAverage;
    String team;

    // 이름만 받는 생성자 → position은 "외야수", uniformNumber는 0, 평균 타율은 0.0, 팀은 "무소속"으로 초기화
    BaseballPlayer(String name) {
        this(name, "외야수", 0, 0.0, "무소속");
    }

    // 안됨.
//    BaseballPlayer(String position) {
//        this("name", position, 0, 0.0, "무소속");
//    }

    // 이름, 포지션만 받는 생성자 → 나머지 기본값 설정
    BaseballPlayer(String name, String position) {
        this(name, position, 0, 0.0, "무소속");
    }

    // 이름, 포지션, 등번호만 받는 생성자 → 타율과 팀은 기본값
    BaseballPlayer(String name, String position, int uniformNumber) {
        this(name, position, uniformNumber, 0.0, "무소속");
    }

    // 최종 필드 초기화용 생성자
    BaseballPlayer(String name, String position, int uniformNumber, double battingAverage, String team) {
        this.name = name;
        this.position = position;
        this.uniformNumber = uniformNumber;
        this.battingAverage = battingAverage;
        this.team = team;
    }

    // 정보 출력용 메서드
    void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("포지션: " + position);
        System.out.println("등번호: " + uniformNumber);
        System.out.println("타율: " + battingAverage);
        System.out.println("소속팀: " + team);
    }
}
