package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
  public static void main(String[] args) {
    List<Student> totalList = new ArrayList<>();
    totalList.add(new Student("홍길동", "남", 92));
    totalList.add(new Student("김수영", "여", 87));
    totalList.add(new Student("감자바", "남", 95));
    totalList.add(new Student("오해영", "여", 93));


    // 남학생 List 구하기
    // 1) Stream 사용 X
    List<Student> maleList1 = new ArrayList<>();
    for(Student student : totalList) {
      if(student.getSex().equals("남")){
        maleList1.add(student);
      }
    }
    System.out.println("maleList1 = " + maleList1);


    // 2) Stream 사용 O
    List<Student> maleList2 = totalList.stream()
            .filter(student -> student.getSex().equals("남"))
            .collect(Collectors.toList());
    System.out.println("maleList2 = " + maleList2);

    // 남학생 이름만 출력
    System.out.println();
    maleList2.stream().forEach(s-> System.out.println(s.getName()));
    System.out.println();
    maleList2.stream().map(Student::getName).forEach(System.out::println);

    // 학생을 성적 내림 차순 정렬 후 2명만 출력
    // 1) Comparator 비교자를 구현하여 제공
    List<Student> list1 = totalList.stream()
            .sorted((a,b) -> Integer.compare(b.getScore(), a.getScore()))
            .limit(2)
            .collect(Collectors.toList());
    System.out.println("list1 = " + list1);

    // 2) Comparator.comparing() 이용
    List<Student> list2 = totalList.stream()
            .sorted(Comparator.comparing(Student::getScore).reversed())
            .limit(2)
            .collect(Collectors.toList());
    System.out.println("list2 = " + list2);

  }
}
