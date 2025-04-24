package ch07_exception_handling.basic.lecture.section01.exception;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        Scanner sc = new Scanner(System.in);

        System.out.print("물건의 가격을 입력해주세요 : ");
        int price = sc.nextInt();

        System.out.println(); // 줄바꿈

        System.out.print("소지하고 있는 돈을 입력해주세요 : ");
        int money = sc.nextInt();

        try {

            et.checkEnoughMoney(price, money);

            System.out.println("============ 상품 구입 가능 =============");
        } catch (Exception e) {


            System.out.println("============= 상품 구입 불가 =============");

            /*
             * finally
             *
             * 예외 처리 구문과 상관 없이 반드시 수행하는 경우 작성한다.
             * 보통 사용한 자원을 반납할 목적으로 사용된다.
             * */

        } finally {
            sc.close();
        }

        System.out.println("프로그램을 종료합니다.");


    }
}
