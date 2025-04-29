package iterator;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    BookShelf bookShelf = new BookShelf(4);
    bookShelf.appendBook(new Book("Around the world in 80 Days"));
    bookShelf.appendBook(new Book("Bible"));
    bookShelf.appendBook(new Book("Cinderella"));
    bookShelf.appendBook(new Book("Daddy-Long_Legs"));

    // 명시적 Iterator 사용
    Iterator<Book> it = bookShelf.iterator();
    while(it.hasNext()) {
      Book book = it.next();
      System.out.println(book.getName());
    }

    // 향상된 for문
    System.out.println();
    for(Book book : bookShelf) {
      System.out.println("book = " + book);
    }
  }
}
