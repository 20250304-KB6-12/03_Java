package basic.ch06.sec10.exam01;

public class Calculator {

    /*
    * static
    * 클래스 자체에 소속됨을 의미함
    * 모든 인스턴스 들에 대해 동일한 값을 유지해야 할때 사용
    *
    * 인스턴스를 만들지 않고도 클래스 이름 . 으로 참조할 수있음
    * */
    static double PI = 3.14159;

    public static int plus(int x, int y) {
        PI = 1;
        return x + y;
    }

    static int minus(int x, int y) {
        return x - y;
    }
}