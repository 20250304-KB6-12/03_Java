package ch15.library.service;


import ch15.library.dto.Book;
import ch15.library.dto.LibraryItem;
import ch15.library.dto.Magazine;
import ch15.library.dto.Thesis;
import lombok.Getter;

import java.util.*;

// 도서관 관리 클래스
@Getter
public class Library {
  private LibrarySection<Book> bookSection;
  private LibrarySection<Magazine> magazineSection;
  private LibrarySection<Thesis> thesisSection;
  private Map<String, List<BorrowRecord>> borrowHistory;

  public Library() {
    this.bookSection = new LibrarySection<Book>("Books");
    this.magazineSection = new LibrarySection<Magazine>("Magazines");
    this.thesisSection = new LibrarySection<Thesis>("Theses");
    this.borrowHistory = new HashMap<String, List<BorrowRecord>>();
  }

  // 자료 등록
  public void registerBook(Book book) {
    bookSection.addItem(book);
  }

  public void registerMagazine(Magazine magazine) {
    magazineSection.addItem(magazine);
  }

  public void registerThesis(Thesis thesis) {
    thesisSection.addItem(thesis);
  }

  // 자료 대출
  public boolean borrowItem(String itemId, String borrowerId) {
    // 책 확인
    Book book = bookSection.findById(itemId);
    if (book != null && book.isAvailable()) {
      book.setAvailable(false);
      recordBorrow(borrowerId, itemId, "Book");
      return true;
    }

    // 잡지 확인
    Magazine magazine = magazineSection.findById(itemId);
    if (magazine != null && magazine.isAvailable()) {
      magazine.setAvailable(false);
      recordBorrow(borrowerId, itemId, "Magazine");
      return true;
    }

    // 논문 확인
    Thesis thesis = thesisSection.findById(itemId);
    if (thesis != null && thesis.isAvailable()) {
      thesis.setAvailable(false);
      recordBorrow(borrowerId, itemId, "Thesis");
      return true;
    }

    return false;
  }

  // 자료 반납
  public boolean returnItem(String itemId, String borrowerId) {
    // 책 확인
    Book book = bookSection.findById(itemId);
    if (book != null && !book.isAvailable()) {
      book.setAvailable(true);
      recordReturn(borrowerId, itemId);
      return true;
    }

    // 잡지 확인
    Magazine magazine = magazineSection.findById(itemId);
    if (magazine != null && !magazine.isAvailable()) {
      magazine.setAvailable(true);
      recordReturn(borrowerId, itemId);
      return true;
    }

    // 논문 확인
    Thesis thesis = thesisSection.findById(itemId);
    if (thesis != null && !thesis.isAvailable()) {
      thesis.setAvailable(true);
      recordReturn(borrowerId, itemId);
      return true;
    }

    return false;
  }

  // 대출 기록
  private void recordBorrow(String borrowerId, String itemId, String itemType) {
    BorrowRecord record = new BorrowRecord(itemId, itemType, new Date());

    if (!borrowHistory.containsKey(borrowerId)) {
      borrowHistory.put(borrowerId, new ArrayList<BorrowRecord>());
    }

    borrowHistory.get(borrowerId).add(record);
  }

  // 반납 기록
  private void recordReturn(String borrowerId, String itemId) {
    if (borrowHistory.containsKey(borrowerId)) {
      List<BorrowRecord> records = borrowHistory.get(borrowerId);
      for (BorrowRecord record : records) {
        if (record.getItemId().equals(itemId) && record.getReturnDate() == null) {
          record.setReturnDate(new Date());
          break;
        }
      }
    }
  }

  // 제목으로 모든 유형의 자료 검색
  public List<LibraryItem> searchAllByTitle(String title) {
    List<LibraryItem> results = new ArrayList<LibraryItem>();

    results.addAll(bookSection.searchByTitle(title));
    results.addAll(magazineSection.searchByTitle(title));
    results.addAll(thesisSection.searchByTitle(title));

    return results;
  }

  // 저자로 모든 유형의 자료 검색
  public List<LibraryItem> searchAllByAuthor(String author) {
    List<LibraryItem> results = new ArrayList<LibraryItem>();

    results.addAll(bookSection.searchByAuthor(author));
    results.addAll(magazineSection.searchByAuthor(author));
    results.addAll(thesisSection.searchByAuthor(author));

    return results;
  }

  // 대출 기록 확인
  public List<BorrowRecord> getBorrowHistory(String borrowerId) {
    if (borrowHistory.containsKey(borrowerId)) {
      return borrowHistory.get(borrowerId);
    } else {
      return new ArrayList<BorrowRecord>();
    }
  }

  // 가장 인기 있는 책 (대출 횟수 기준)
  public Map<String, Integer> getMostPopularItems() {
    Map<String, Integer> popularityMap = new HashMap<String, Integer>();

    // 모든 대출 기록을 순회하며 각 자료의 대출 횟수 집계
    for (List<BorrowRecord> records : borrowHistory.values()) {
      for (BorrowRecord record : records) {
        String itemId = record.getItemId();
        if (popularityMap.containsKey(itemId)) {
          popularityMap.put(itemId, popularityMap.get(itemId) + 1);
        } else {
          popularityMap.put(itemId, 1);
        }
      }
    }

    return popularityMap;
  }

  // 평균 대출 기간 계산 (일 단위) - 스트림 없이 구현
  public double getAverageBorrowDuration() {
    int totalDays = 0;
    int returnedItemCount = 0;

    for (List<BorrowRecord> records : borrowHistory.values()) {
      for (BorrowRecord record : records) {
        if (record.getReturnDate() != null) {
          // 반납된 자료만 계산
          long diffInMillies = record.getReturnDate().getTime() - record.getBorrowDate().getTime();
          int diffInDays = (int) (diffInMillies / (1000 * 60 * 60 * 24));
          totalDays += diffInDays;
          returnedItemCount++;
        }
      }
    }

    if (returnedItemCount == 0) {
      return 0;
    }

    return (double) totalDays / returnedItemCount;
  }
}
