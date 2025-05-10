package ch17.sec12.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		// 그룹핑 후 성별 학생 수 구하기
		Map<String, Long> countMap = totalList.stream()
						.collect(
										Collectors.groupingBy(
														s -> s.getSex(),
														Collectors.counting()
										)
						);
		System.out.println(countMap);
		System.out.println();

		// 그룹핑 후 성별 평균 점수 구하기
		Map<String, Double> map = totalList.stream()
				.collect(
					Collectors.groupingBy(
						s -> s.getSex(),
						Collectors.averagingDouble(s->s.getScore())
					)
				);
		
		System.out.println(map);
	}
}
