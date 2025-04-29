package ch15.library.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 논문 클래스
 */
@Getter
@Setter
public class Thesis extends LibraryItem {
  private String topic;
  private String university;
  private String degree;

  public Thesis(String title, String author, int year, String itemId,
                String topic, String university, String degree) {
    super(title, author, year, itemId);
    this.topic = topic;
    this.university = university;
    this.degree = degree;
  }



  @Override
  public String getItemInfo() {
    return "Thesis: " + getTitle() +
            " by " + getAuthor() +
            " (" + getYear() + "), " + degree + " at " + university;
  }
}