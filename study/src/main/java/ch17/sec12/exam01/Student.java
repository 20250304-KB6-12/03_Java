package ch17.sec12.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student {
  private String name;
  private String sex;
  private int score;
}
