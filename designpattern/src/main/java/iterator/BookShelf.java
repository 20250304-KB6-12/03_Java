package iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BookShelf implements Iterable<Book> {
  private Book[] books;
  private int last = 0;

  public BookShelf(int maxSize) {
    this.books = new Book[maxSize];
  }

  public Book getBookAt(int index) {
    return books[index];
  }

  public void appendBook(Book book) {
    books[last++] = book;
  }

  public int getLength(){
    return last;
  }

  @Override
  public Iterator<Book> iterator() {
    return new BookShelfIterator(this);
  }
}
