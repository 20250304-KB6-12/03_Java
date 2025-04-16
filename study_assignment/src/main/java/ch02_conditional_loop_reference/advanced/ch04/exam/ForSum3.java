package ch02_conditional_loop_reference.advanced.ch04.exam;

public class ForSum3 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }

        System.out.println("1~100에서 3의 배수 합: " + sum);
    }
}
