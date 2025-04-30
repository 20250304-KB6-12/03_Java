package todo.service;

import lombok.AllArgsConstructor;
import lombok.Data;

// Comparable : 기본 정렬 기준 설정 인터페이스(TreeSet에서 이용)
@Data
@AllArgsConstructor
public class Task implements Comparable<Task> {
  private int priority; // 할 일 우선순위 (1 ~ 5, 1이 높음!)
  private String content; // 할 일 내용

  @Override
  public String toString(){
    return "[우선순위:" + priority + "]" + content;
  }

  // 기본 정렬 기준 설정
  @Override
  public int compareTo(Task other) {

    int priorityCompare = this.priority - other.priority;

    // 양수(자리바꿈), 음수(유지)
    if(priorityCompare != 0) return priorityCompare;

    // 우선순위가 같으면 content 오름 차순으로 정렬
    return this.content.compareTo(other.content);
  }
}
