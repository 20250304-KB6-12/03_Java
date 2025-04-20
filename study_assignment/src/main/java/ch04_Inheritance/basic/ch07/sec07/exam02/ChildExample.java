package ch04_Inheritance.basic.ch07.sec07.exam02;


public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();

        Parent parent = child;  // 자동 타입 변환 (다형성)
        parent.method1();       // Parent-method1()
        parent.method2();       // 오버라이딩된 Child-method2()

        // parent.method3();  // 오류! Parent 타입에는 method3()이 없음
    }
}
