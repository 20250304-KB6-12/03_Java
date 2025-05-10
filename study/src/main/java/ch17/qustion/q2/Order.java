package ch17.qustion.q2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
  private int orderId;
  private String customerName;
  private List<Product> products;
  private LocalDate orderDate;

  // 주문의 총액을 계산하는 메서드
  public double getTotalAmount() {
    return products.stream().mapToDouble(Product::getPrice).sum();
  }
}