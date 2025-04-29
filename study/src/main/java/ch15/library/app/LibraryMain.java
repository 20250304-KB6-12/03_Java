package ch15.library.app;


import ch15.library.dto.Book;
import ch15.library.dto.LibraryItem;
import ch15.library.dto.Magazine;
import ch15.library.dto.Thesis;
import ch15.library.service.BorrowRecord;
import ch15.library.service.Library;

import java.util.List;
import java.util.Map;

// 메인 클래스 - 테스트용
public class LibraryMain {
  public static void main(String[] args) {
    // 라이브러리 인스턴스 생성
    Library library = new Library();

    // 샘플 책 인스턴스 생성
    Book book1 = new Book("Java Programming", "John Smith", 2020, "B001",
            "978-1234567890", "Tech Press", 450);
    Book book2 = new Book("Data Structures", "Alice Johnson", 2018, "B002",
            "978-0987654321", "CS Publishing", 380);
    Book book3 = new Book("Algorithms", "Robert Williams", 2019, "B003",
            "978-5678901234", "Code Books", 520);

    // 샘플 책 인스턴스를 라이브러리 인스턴스에 등록
    library.registerBook(book1);
    library.registerBook(book2);
    library.registerBook(book3);

    // 잡지 등록
    Magazine magazine1 = new Magazine("Tech Today", "Various Authors", 2022, "M001",
            "1234-5678", 45, "Technology");
    Magazine magazine2 = new Magazine("Science Weekly", "Science Group", 2023, "M002",
            "8765-4321", 112, "Science");

    library.registerMagazine(magazine1);
    library.registerMagazine(magazine2);

    // 논문 등록
    Thesis thesis1 = new Thesis("Machine Learning Applications", "David Chen", 2021, "T001",
            "AI", "Stanford University", "Ph.D");
    Thesis thesis2 = new Thesis("Network Security", "Emily Brown", 2020, "T002",
            "Cybersecurity", "MIT", "Master's");

    library.registerThesis(thesis1);
    library.registerThesis(thesis2);

    // 자료 검색 테스트
    System.out.println("===== 제목으로 검색 (java) =====");
    List<LibraryItem> javaResults = library.searchAllByTitle("java");
    for (LibraryItem item : javaResults) {
      System.out.println(item.getItemInfo());
    }

    System.out.println("\n===== 저자로 검색 (smith) =====");
    List<LibraryItem> smithResults = library.searchAllByAuthor("smith");
    for (LibraryItem item : smithResults) {
      System.out.println(item.getItemInfo());
    }

    // 대출 및 반납 테스트
    System.out.println("\n===== 대출 및 반납 테스트 =====");

    String borrowerId1 = "S12345"; // 학생 ID
    String borrowerId2 = "F67890"; // 교수 ID

    System.out.println("Book1 대출: " + library.borrowItem("B001", borrowerId1));
    System.out.println("Magazine1 대출: " + library.borrowItem("M001", borrowerId1));
    System.out.println("Book2 대출: " + library.borrowItem("B002", borrowerId2));
    System.out.println("Thesis1 대출: " + library.borrowItem("T001", borrowerId2));

    // 이미 대출된 자료 대출 시도
    System.out.println("Book1 대출 시도(이미 대출됨): " + library.borrowItem("B001", borrowerId2));

    // 대출 가능한 책만 확인
    System.out.println("\n===== 대출 가능한 책 =====");
    List<Book> availableBooks = library.getBookSection().getAvailableItems();
    for (Book book : availableBooks) {
      System.out.println(book.getItemInfo());
    }

    // 자료 반납
    System.out.println("\n===== 자료 반납 =====");
    System.out.println("Book1 반납: " + library.returnItem("B001", borrowerId1));
    System.out.println("Magazine1 반납: " + library.returnItem("M001", borrowerId1));

    // 대출 이력 확인
    System.out.println("\n===== 대출 이력 확인(학생) =====");
    List<BorrowRecord> studentRecords = library.getBorrowHistory(borrowerId1);
    for (BorrowRecord record : studentRecords) {
      System.out.println(record);
    }

    System.out.println("\n===== 대출 이력 확인(교수) =====");
    List<BorrowRecord> professorRecords = library.getBorrowHistory(borrowerId2);
    for (BorrowRecord record : professorRecords) {
      System.out.println(record);
    }

    // 추가 대출 및 반납 (통계용)
    library.borrowItem("B001", borrowerId2);  // 다시 대출
    library.borrowItem("B003", borrowerId1);

    // 일부 자료만 반납
    try {
      // 실제 코드에서는 더 현실적인 지연이 필요합니다
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    library.returnItem("B001", borrowerId2);
    library.returnItem("B002", borrowerId2);

    // 통계 확인
    System.out.println("\n===== 인기 자료 통계 =====");
    Map<String, Integer> popularItems = library.getMostPopularItems();
    for (Map.Entry<String, Integer> entry : popularItems.entrySet()) {
      System.out.println("Item ID: " + entry.getKey() + ", Borrow Count: " + entry.getValue());
    }

    System.out.println("\n===== 평균 대출 기간 =====");
    System.out.println("평균 대출 기간: " + library.getAverageBorrowDuration() + "일");

    // 정렬 테스트
    System.out.println("\n===== 책 제목순 정렬 =====");
    List<Book> booksByTitle = library.getBookSection().getSortedByTitle();
    for (Book book : booksByTitle) {
      System.out.println(book.getTitle());
    }

    System.out.println("\n===== 책 출판년도순 정렬 =====");
    List<Book> booksByYear = library.getBookSection().getSortedByYear();
    for (Book book : booksByYear) {
      System.out.println(book.getTitle() + " (" + book.getYear() + ")");
    }
  }
}