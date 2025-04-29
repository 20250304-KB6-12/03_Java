package ch15.library.service;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 대출 기록 클래스
 */
@Getter
@Setter
public class BorrowRecord {
  private String itemId;
  private String itemType;
  private Date borrowDate;
  private Date returnDate;

  public BorrowRecord(String itemId, String itemType, Date borrowDate) {
    this.itemId = itemId;
    this.itemType = itemType;
    this.borrowDate = borrowDate;
    this.returnDate = null;
  }


  @Override
  public String toString() {
    return "Item: " + itemId +
            " (" + itemType + ")" +
            ", Borrowed: " + borrowDate +
            ", Returned: " + (returnDate != null ? returnDate : "Not yet returned");
  }
}