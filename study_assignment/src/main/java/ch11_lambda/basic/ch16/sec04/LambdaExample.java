package ch11_lambda.basic.ch16.sec04;

public class LambdaExample {

    public static void main(String[] args) {
        Person person = new Person();

        // 실행문이 두 개 이상일 경우
        person.action((x, y) -> {
            double result = x + y;
            return result;
        });

        // 메소드 참조 또는 람다식을 간단하게 표현
        person.action((x, y) -> sum(x, y));
    }

    public static double sum(double x, double y) {
        return x + y;
    }
}
