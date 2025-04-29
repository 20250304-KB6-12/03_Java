package ch13.exam01;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureExample {

  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    List<Integer> integerList = new ArrayList<>();

    // 런타임에는 제네릭 타입 정보가 소거됨
    System.out.println("stringList의 클래스: " + stringList.getClass().getName());
    System.out.println("integerList의 클래스: " + integerList.getClass().getName());

    // 두 리스트의 클래스가 동일함을 확인
    System.out.println("두 리스트의 클래스가 같은가? " + (stringList.getClass() == integerList.getClass()));
  }
}
