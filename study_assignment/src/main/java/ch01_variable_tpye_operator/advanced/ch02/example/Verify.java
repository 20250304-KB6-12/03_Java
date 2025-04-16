package ch01_variable_tpye_operator.advanced.ch02.example;

public class Verify {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        System.out.println((x > 7) && (y <= 5));
        System.out.println((x % 3 == 2) || (y % 2 != 1));
    }
}