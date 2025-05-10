package ch17.qustion.q2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderAnalysis {
  public static void main(String[] args) {
    // 제품 목록 생성
    Product laptop = new Product("노트북", "전자제품", 1200000);
    Product phone = new Product("스마트폰", "전자제품", 800000);
    Product book = new Product("자바 책", "도서", 30000);
    Product headphone = new Product("헤드폰", "전자제품", 120000);
    Product tablet = new Product("태블릿", "전자제품", 500000);
    Product charger = new Product("충전기", "액세서리", 25000);

    // 주문 목록 생성
    List<Order> orders = Arrays.asList(
            new Order(1, "김철수", Arrays.asList(laptop, headphone), LocalDate.of(2023, 3, 15)),
            new Order(2, "이영희", Arrays.asList(phone, charger), LocalDate.of(2023, 4, 20)),
            new Order(3, "박민수", Arrays.asList(book, tablet), LocalDate.of(2023, 5, 10)),
            new Order(4, "최지원", Arrays.asList(laptop, phone, charger), LocalDate.of(2023, 5, 22)),
            new Order(5, "김철수", Arrays.asList(tablet, book), LocalDate.of(2023, 6, 5))
    );


    // 1. 총액이 100만원 이상인 주문의 ID 목록을 반환하기
    // 결과: [1, 4]
    List<Integer> answer1 = orders.stream()
            .filter(order -> order.getTotalAmount() >= 1_000_000)
            .map(Order::getOrderId)
            .toList();
    System.out.println("answer1 = " + answer1);


    // 2. 각 고객별 총 주문 금액을 계산하여 맵으로 반환하기
    // 결과: {김철수=1850000.0, 이영희=825000.0, 박민수=530000.0, 최지원=2025000.0}
    Map<String, Double> answer2 = orders.stream()
            .collect(Collectors.groupingBy(
                    //order -> order.getCustomerName(), // K
                    //Collectors.summingDouble(order -> order.getTotalAmount()) // V
                    Order::getCustomerName,
                    Collectors.summingDouble(Order::getTotalAmount)
            ));

    System.out.println("answer2 = " + answer2);


    // 3. 모든 주문에서 가장 많이 구매된 제품 카테고리를 찾기
    // 결과: 전자제품
    String answer3 =
            orders.stream()
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(
                    product -> product.getCategory(), // K : 카테고리명
                    Collectors.counting()  // V : 카테고리별 상품 개수
            ))
            .entrySet().stream() // Map -> Stream으로 변경
            .max( (e1, e2)
                    -> Long.compare(e1.getValue(), e2.getValue()) )
            .map(entry -> entry.getKey()) // K : 카테고리명
            .orElse("없음");

    System.out.println("answer3 = " + answer3);


    // 4. 2023년 5월 이후의 주문에서 구매된 모든 제품의 이름을 중복 없이 반환하기
    // 결과: [자바 책, 태블릿, 노트북, 스마트폰, 충전기]
    List<String> answer4 =
            orders.stream()
                    .filter(order
                            -> order.getOrderDate().isAfter(
                                    LocalDate.of(2023, 4, 30)))
                    .flatMap(order -> order.getProducts().stream())
                    .map(product -> product.getName())
                    .distinct()
                    .toList();
    System.out.println("answer4 = " + answer4);


    // 5. 각 제품 카테고리별 평균 가격을 계산하기
    // 결과: {전자제품=731428.5714285715, 도서=30000.0, 액세서리=25000.0}
    Map<String, Double> answer5
            = orders.stream()
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(
                    Product::getCategory, // K
                    Collectors.averagingDouble(Product::getPrice) // V
            ));
    System.out.println("answer5 = " + answer5);

    // 6. 모든 주문을 날짜별로 그룹화하고, 각 날짜의 총 주문 금액을 계산하기
    // 결과: {2023-03-15=1320000.0, 2023-04-20=825000.0, 2023-05-10=530000.0, 2023-05-22=2025000.0, 2023-06-05=530000.0}
    Map<LocalDate, Double> answer6 = orders.stream()
            .collect(Collectors.groupingBy(
                    Order::getOrderDate,
                    Collectors.summingDouble(Order::getTotalAmount)
            ));
    System.out.println("answer6 = " + answer6);

  }
}