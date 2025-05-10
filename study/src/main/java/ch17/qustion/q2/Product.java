package ch17.qustion.q2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private String name;
  private String category;
  private double price;
}