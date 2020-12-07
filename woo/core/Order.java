package woo.core;

import java.io.Serializable;

public class Order extends Transaction implements Serializable {

  private Supplier _supplier;

  protected Order(int id, int cost, int date, Supplier sup){
    super(id, cost, date);
    _supplier = sup;
  }

  public Supplier getSupplier(){
    return _supplier;
  }

  @Override
  public String toString() {
    return " | ";
  }
}
