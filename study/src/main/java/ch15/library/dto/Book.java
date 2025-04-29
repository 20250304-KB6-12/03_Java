package ch15.library.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 책 클래스
 */
@Getter
public class Book extends LibraryItem {

  private String isbn;
  private String publisher;
  private int pages;

  public Book(String title, String author, int year, String itemId,
              String isbn, String publisher, int pages) {
    super(title, author, year, itemId);
    this.isbn = isbn;
    this.publisher = publisher;
    this.pages = pages;
  }


  @Override
  public String getItemInfo() {
    return "Book: " + getTitle() +
            " by " + getAuthor() +
            " (" + getYear() + "), ISBN: " + isbn;
  }
}
