package woo.core;

import java.io.Serializable;

public class Product implements Serializable {

  private int _price;
  private int _criticalValue;
  private int _currentQuantity;
  private String _id;

  protected Product(String id, int price, int crit, int q){

  }

  @Override
  public String toString() {

  }
}
