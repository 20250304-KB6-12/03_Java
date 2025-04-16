package ch01_variable_tpye_operator.advanced.ch02.sec12;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;

        System.out.printf("상품의 가격:%d원\n", value);
        System.out.printf("상품의 가격:%6d원\n", value);   // 6자리 오른쪽 정렬
        System.out.printf("상품의 가격:%-6d원\n", value);  // 6자리 왼쪽 정렬
        System.out.printf("상품의 가격:%06d원\n", value);  // 6자리, 빈칸은 0으로 채움

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);
        // %10.2f : 전체 10자리, 소수점 아래 2자리 (남는 자리는 공백으로)

        String name = "홍길동";
        String job = "도적";
        System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
        // %6d : 번호를 6자리로 오른쪽 정렬
        // %-10s : 이름을 10자리로 왼쪽 정렬
        // %10s : 직업을 10자리로 오른쪽 정렬
    }
}
