package ch08.sec01;

public interface Temp {
    // 상수 (Constants)
    // 인터페이스의 모든 필드는 자동으로 public, static, final
    int MAX_SIZE = 100;
    String DEFAULT_NAME = "Unknown";
    
    // 추상 메서드 (Abstract Methods)
    // 인터페이스의 메서드는 기본적으로 public, abstract
    void process();
    String getName();
    int calculate(int x, int y);
    
    // 디폴트 메서드 (Default Methods) - Java 8부터 지원
    default void printInfo() {
        System.out.println("이 객체의 이름: " + getName());
        System.out.println("최대 크기: " + MAX_SIZE);
    }
    
    default String getDefaultValue() {
        return "기본값";
    }
    
    // 정적 메서드 (Static Methods) - Java 8부터 지원
    static void printVersion() {
        System.out.println("Temp 인터페이스 버전 1.0");
    }

    static boolean isValid(int value) {
        return value >= 0 && value <= MAX_SIZE;
    }
}