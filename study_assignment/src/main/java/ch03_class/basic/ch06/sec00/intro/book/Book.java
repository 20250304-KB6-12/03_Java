package ch03_class.basic.ch06.sec00.intro.book;

public class Book {
    // 필드
    public String author;
    public String title;
    public int pageCount;
    public String coverType;

    // 생성자
//    public Book(String author, String title, int pageCount, String coverType) {
//        this.author = author;
//        this.title = title;
//        this.pageCount = pageCount;
//        this.coverType = coverType;
//    }

    // getter와 setter (필드에 접근하기 위한 메서드)
    // 메소드
    /*
    * 접근제어자 반환타입 메서드명() {
    *
    *   return (반환값 : 한개만가능!!)
    * }
    * */
    public String getAuthor() {
        return author;
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "author='" + author + '\'' +
//                ", title='" + title + '\'' +
//                ", pageCount=" + pageCount +
//                ", coverType='" + coverType + '\'' +
//                '}';
//    }1
}
