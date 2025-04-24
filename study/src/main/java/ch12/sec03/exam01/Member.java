package ch12.sec03.exam01;

import lombok.Data;

import java.util.Objects;

@Data
public class Member {
  private String id;
  private String name;
  private int age;

  // 생성자
  public Member(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Member member)) return false;
    return age == member.age && Objects.equals(id, member.id) && Objects.equals(name, member.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }

  @Override
  public String toString() {
    return "Member{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
