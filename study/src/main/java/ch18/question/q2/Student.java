package ch18.question.q2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
  private String name;
  private int korean;
  private int english;
  private int math;


  // 총점 계산
  public int getTotal() {
    return korean + english + math;
  }

  // 평균 계산
  public double getAverage() {
    return (double) getTotal() / 3;
  }

  @Override
  public String toString() {
    return String.format("%-10s %3d %3d %3d %4d %6.2f",
            name, korean, english, math, getTotal(), getAverage());
  }
}
