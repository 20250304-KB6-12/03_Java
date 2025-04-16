package ch02_conditional_loop_reference.basic.ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int m = 2; m <= 9; m++) {
            System.out.println("*** " + m + "단 ***");

            for (int n = 1; n <= 9; n++) {
                System.out.println(m + " x " + n + " = " + (m * n));
            }

            System.out.println(); // 단 사이에 빈 줄 추가하면 더 보기 좋아요
        }
    }
}
