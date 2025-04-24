package ch07_exception_handling.basic.lecture.section01.exception;

public class Application2 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(10000, 5000);

            System.out.println("=========== 상품 구입 가능 ==============");
        } catch (Exception e) {

            System.out.println("=========== 상품 구입 불가능 =============");
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
