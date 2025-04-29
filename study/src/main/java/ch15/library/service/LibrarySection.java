package ch15.library.service;

import ch15.library.dto.LibraryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 제네릭을 활용한 도서관 섹션 클래스
 */
public class LibrarySection<T extends LibraryItem> {
  private String sectionName;
  private List<T> items;

  public LibrarySection(String sectionName) {
    this.sectionName = sectionName;
    this.items = new ArrayList<T>();
  }

  // 자료 추가
  public void addItem(T item) {
    items.add(item);
  }

  // 자료 제거
  public boolean removeItem(String itemId) {
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getItemId().equals(itemId)) {
        items.remove(i);
        return true;
      }
    }
    return false;
  }

  // 제목으로 자료 검색
  public List<T> searchByTitle(String title) {
    List<T> result = new ArrayList<T>();
    for (T item : items) {
      if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  // 저자로 자료 검색
  public List<T> searchByAuthor(String author) {
    List<T> result = new ArrayList<T>();
    for (T item : items) {
      if (item.getAuthor().toLowerCase().contains(author.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  // ID로 자료 검색
  public T findById(String itemId) {
    for (T item : items) {
      if (item.getItemId().equals(itemId)) {
        return item;
      }
    }
    return null;
  }

  // 대출 가능한 자료만 필터링
  public List<T> getAvailableItems() {
    List<T> availableItems = new ArrayList<T>();
    for (T item : items) {
      if (item.isAvailable()) {
        availableItems.add(item);
      }
    }
    return availableItems;
  }

  // 연도별 정렬
  public List<T> getSortedByYear() {
    List<T> sorted = new ArrayList<T>(items);

    Collections.sort(sorted, new Comparator<T>() {
      @Override
      public int compare(T item1, T item2) {
        return Integer.compare(item1.getYear(), item2.getYear());
      }
    });

    return sorted;
  }

  // 제목별 정렬
  public List<T> getSortedByTitle() {
    List<T> sorted = new ArrayList<T>(items);

    Collections.sort(sorted, new Comparator<T>() {
      @Override
      public int compare(T item1, T item2) {
        return item1.getTitle().compareTo(item2.getTitle());
      }
    });

    return sorted;
  }

  // 모든 자료 가져오기
  public List<T> getAllItems() {
    return new ArrayList<T>(items);
  }

  public String getSectionName() {
    return sectionName;
  }
}