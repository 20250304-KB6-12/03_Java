package ch07_exception_handling.basic.lecture.section04.overriding;

import java.io.FileNotFoundException;

public class SubClass extends SuperClass {

    // 예외 없이 오버라이딩 가능
//    @Override
//    public void method(){}


    // 같은 예외를 던지는 구문으로 오버라이딩 가능.
//    @Override
//    public void method() throws IOException {}


    // 부모의 예외처리 클래스보다 상위의 예외로는 후손클래서에서 오버라이딩 할 수 없다.
//    @Override
//    public void method() throws Exception {}


    // 부모의 예외처리 클래스보다 더 하위에 있는 구체적인 예외사항의 경우 오버라이딩 가능 하다.
    @Override
    public void method() throws FileNotFoundException {
    }

    // Exception에서 자식클래스는 부모 클래스보다 더 많은 예외를 가질 수 없다.
}
