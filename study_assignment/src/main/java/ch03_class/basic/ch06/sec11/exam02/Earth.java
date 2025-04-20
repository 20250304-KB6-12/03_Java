package ch03_class.basic.ch06.sec11.exam02;

public class Earth {

    //상수 선언 및 초기화
    static final double EARTH_RADIUS = 6400;
    //상수 선언
    static final double EARTH_SURFACE_AREA;

    //정적 블록에서 상수 초기화
    /*
     * 정적 블록 (Static Block)
     * 클래스가 메모리에 로드될 때 딱 한 번 실행되는 블록
     *
     * 클래스가 처음 JVM에 의해 로드될 때 실행됩니다.
     * 즉, 그 클래스의 static 변수나 static 메서드를 처음 사용할 때 실행됨
     * */
    static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }
}