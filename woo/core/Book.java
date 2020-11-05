package woo.core;

import java.io.Serializable;

public class Book extends Product implements Serializable {

  private String _id;
  private String _author;
  private String _isbn;

  protected Book(String id, int crit, int q){

  }
}
