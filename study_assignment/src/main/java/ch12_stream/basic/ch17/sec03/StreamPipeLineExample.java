package ch12_stream.basic.ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        // 학생 리스트 생성
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        // 방법1: 단계별 스트림 처리
        Stream<Student> studentStream = list.stream();
        IntStream scoreStream = studentStream
                .mapToInt(student -> student.getScore());
        double avg1 = scoreStream
                .average()
                .getAsDouble();
        System.out.println("평균 점수(방법1): " + avg1);

        // 방법2: 파이프라인 스타일
        double avg2 = list.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
        System.out.println("평균 점수(방법2): " + avg2);
    }
}
