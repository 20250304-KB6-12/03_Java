package ch02_conditional_loop_reference.basic.ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        intArray[0] = 10; // null에 대해서 대입 연산 실행
        String str = null;
        System.out.println("총 문자 수: " + str.length() ); // null에 대해서 length() 메서드 호출
    }
}