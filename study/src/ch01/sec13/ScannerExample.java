package ch01.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수 입력 : ");
        int inputNum = sc.nextInt();

        System.out.println("inputNum = " + inputNum);
    }
}
