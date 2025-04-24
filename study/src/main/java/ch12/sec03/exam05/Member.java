package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
  private String id;
  private String name;
  private int age;


  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Member member)) return false;
    return age == member.age && Objects.equals(id, member.id) && Objects.equals(name, member.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }
}
