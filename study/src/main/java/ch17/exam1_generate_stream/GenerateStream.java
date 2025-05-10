package ch17.exam1_generate_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 생성
 */
public class GenerateStream {
  public static void main(String[] args) throws IOException {
    // 1. 배열로부터 스트림 생성
    String[] arr = {"a", "b", "c"};
    Stream<String> stream1 = Arrays.stream(arr);

    // 2. 컬렉션으로부터 스트림 생성
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> stream2 = list.stream();

    Set<String> set = new HashSet<>();
    set.add("홍길동");
    set.add("신용권");
    set.add("감자바");
    Stream<String> stream = set.stream();

    // 3. Stream.of()를 사용한 생성
    Stream<String> stream3 = Stream.of("a", "b", "c");

    // 4. 빈 스트림 생성
    Stream<String> emptyStream = Stream.empty();

    // 5. Stream.builder() 사용 - Builder 패턴
    Stream<String> streamBuilder = Stream.<String>builder()
            .add("A")
            .add("B")
            .add("C")
            .build();

    // 6. Stream.iterate() 사용 - 무한 스트림 (제한 필요)
    Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2)
            .limit(5); // 0, 2, 4, 6, 8

    // 7. Stream.generate() 사용 - 무한 스트림 (제한 필요)
    Stream<Double> generateStream = Stream.generate(Math::random)
            .limit(5); // 5개의 랜덤 값

    // 8. IntStream, LongStream, DoubleStream - 기본 타입 특화 스트림
    IntStream intStream = IntStream.range(1, 5); // 1, 2, 3, 4
    IntStream intStreamClosed = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5

    // 9. 문자열에서 스트림 생성
    IntStream streamFromString = "abc".chars(); // 97, 98, 99 (ASCII 값)

    // 10. 파일에서 스트림 생성
    Stream<String> streamFromFile = Files.lines(Paths.get("file.txt"));

    // 11. 병렬 스트림 생성
    Stream<String> parallelStream = list.parallelStream();

    // 12. 연결된 스트림 생성 (== 스트림 합치기)
    Stream<String> concatStream = Stream.concat(
            Stream.of("A", "B"),
            Stream.of("C", "D")
    ); // A, B, C, D

    // 13. Pattern.splitAsStream() 메서드 사용 (== 문자열을 구분자를 기준으로 분리, 구분자를 정규표현식으로 찾음)
    Stream<String> streamFromPattern = java.util.regex.Pattern.compile(", ")
            .splitAsStream("A, B, C");

    // 14. BufferedReader.lines() 메서드 사용
    Stream<String> streamFromReader = new java.io.BufferedReader(
            new java.io.StringReader("A\nB\nC")).lines();

    // 15. 기본 타입을 객체 타입으로 박싱하는 방법
    Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
  }
}
