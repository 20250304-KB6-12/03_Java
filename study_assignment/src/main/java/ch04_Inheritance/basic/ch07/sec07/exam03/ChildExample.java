package ch04_Inheritance.basic.ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();
// parent.field2 = "data2"; -- field2는 Child 클래스의 멤버임, Parent 타입으로 사용 불가
// parent.method3(); -- method3는 Child 클래스의 멤버임, Parent 타입으로 사용 불가
        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }
}