package woo.core;

import java.io.Serializable;

public class Book extends Product implements Serializable {

  private String _id;
  private String _title;
  private String _author;
  private String _isbn;

  protected Book(String id, String supplierId, int price, int crit, int q, String title, String author, String isbn){
    super(id, supplierId, price, crit, q);
    _title = title;
    _author = author;
    _isbn = isbn;
  }

  public String getAuthor() {
    return _author;
  }

  public String getIsbn() {
    return _isbn;
  }

  @Override
  public String toString() {
    return getId() + "|" + getSupplierId() + "|" + getPrice() + "|" + getCriticalValue() + "|"
          + getCurrentQuantity() + "|" + getAuthor() + "|" + getIsbn();
  }
}
