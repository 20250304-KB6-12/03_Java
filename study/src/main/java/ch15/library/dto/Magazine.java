package ch15.library.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 잡지 클래스
 */
@Getter
@Setter
public class Magazine extends LibraryItem {
  private String issn;
  private int issue;
  private String category;

  public Magazine(String title, String author, int year, String itemId,
                  String issn, int issue, String category) {
    super(title, author, year, itemId);
    this.issn = issn;
    this.issue = issue;
    this.category = category;
  }


  @Override
  public String getItemInfo() {
    return "Magazine: " + getTitle() +
            ", Issue: " + issue +
            " (" + getYear() + "), Category: " + category;
  }
}
