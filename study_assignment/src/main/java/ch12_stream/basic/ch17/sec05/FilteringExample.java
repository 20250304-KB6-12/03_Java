package ch12_stream.basic.ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        // List 컬렉션 생성 (가나다 순, 중복 포함)
        List<String> list = new ArrayList<>();
        list.add("감자바");
        list.add("신민철");
        list.add("신용권");
        list.add("신용권");
        list.add("홍길동");

        // 중복 요소 제거
        list.stream()
                .distinct()
                .forEach(n -> System.out.println(n));

        System.out.println();

        // '신'으로 시작하는 요소만 필터링
        list.stream()
                .filter(n -> n.startsWith("신"))
                .forEach(n -> System.out.println(n));

        System.out.println();

        // 중복 제거 후 '신'으로 시작하는 요소만 필터링
        list.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                .forEach(n -> System.out.println(n));
    }
}
