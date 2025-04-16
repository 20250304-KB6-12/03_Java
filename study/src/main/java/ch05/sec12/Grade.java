package ch05.sec12;

public enum Grade {
    // 각 등급별 점수와 설명을 상수로 정의
    A(95, "최우수"),
    B(85, "우수"),
    C(75, "보통"),
    D(65, "미흡"),
    F(0, "불합격");

    // 각 등급의 점수와 설명을 저장하는 필드
    private final int score;
    private final String description;

    // 열거 상수 생성 시 점수와 설명을 초기화하는 생성자
    Grade(int score, String description) {
        this.score = score;
        this.description = description;
    }

    // getter
    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }
}
