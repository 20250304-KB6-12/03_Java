package ch03_class.basic.ch06.sec14.lecture.method;
import java.util.Random;

public class Application {

    public static int plus(int x, int y) {
        return x+y;
    }

    public static int getInt() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public static void main(String[] args) {

        int result = plus(getInt(), getInt());
        System.out.println();

    }
}
