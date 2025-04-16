package ch02_conditional_loop_reference.advanced.ch04.exam;

public class FindSolution {
    public static void main(String[] args) {
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                int answer = 4 * x + 5 * y;
                if (answer == 60) {
                    System.out.println("(" + x + "," + y + ")");
                }
            }
        }
    }
}