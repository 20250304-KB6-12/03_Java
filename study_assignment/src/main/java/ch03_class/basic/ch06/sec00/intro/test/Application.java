package ch03_class.basic.ch06.sec00.intro.test;


import ch03_class.basic.ch06.sec00.intro.book.Book;

public class Application {
    public static void main(String[] args) {
        // Book 객체 생성
        Book myBook = new Book();

        // "조앤 K 롤링", "해리 포터와 마법사의 돌", 320, "하드커버"
        myBook.pageCount = 320;
        myBook.author = "조엔 K. 롤링";
        myBook.coverType = "하드커버";
        myBook.title = "해리포터와 마법사의 돌";

        // 책 정보 출력
        String myBookAuthor = myBook.getAuthor();

        // 필드 수정 예시 (setter 사용)
        System.out.println("\n[커버 종류 변경 후 출력]");
        System.out.println(myBookAuthor);

        System.out.println(myBook);
    }
}
