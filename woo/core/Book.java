package woo.core;

import java.io.Serializable;

public class Book extends Product implements Serializable {

  private String _id;
  private String _author;
  private String _isbn;

  protected Book(String id, int price, int crit, int q, String author, String isbn){
    super(id, price, crit, q);
    _author = author;
    _isbn = isbn;
  }

  public void getAuthor() {
    return _author;
  }

  public void getIsbn() {
    return _isbn;
  }
}
