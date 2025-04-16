package ch02_conditional_loop_reference.advanced.ch04.exam;

import java.util.Scanner;

public class Account2 {
    public static void main(String[] args) {
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("-------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");
            int menuNum = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            switch (menuNum) {
                case 1:
                    System.out.print("예금액> ");
                    int deposit = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 소비
                    balance += deposit;
                    break;
                case 2:
                    System.out.print("출금액> ");
                    int withdraw = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 소비
                    balance -= withdraw;
                    break;
                case 3:
                    System.out.println("잔고> " + balance);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 1~4를 선택하세요.");
            }

            System.out.println();
        }

        System.out.println("프로그램 종료");
        scanner.close();
    }
}
