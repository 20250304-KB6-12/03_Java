package ch15.library.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 도서관 자료의 기본 추상 클래스
@Getter
@Setter
@ToString
public abstract class LibraryItem {
  private String title;
  private String author;
  private int year;
  private boolean isAvailable;
  private String itemId;

  // 매개 변수 4개짜리 생성자
  public LibraryItem(String title, String author, int year, String itemId) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.itemId = itemId;

    // true로 초기화
    this.isAvailable = true;
  }


  // 자료의 간단한 정보를 반환하는 추상 메서드
  public abstract String getItemInfo();

}