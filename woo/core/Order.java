package woo.core;

import java.io.Serializable;

public class Order extends Transaction implements Serializable {

  protected Order(int id, String supplierId, int cost, int date){
    super(id, supplierId, cost, date);
  }

  @Override
  public String toString() {
    return getTransId() + "|" + getId() + "|" + getCost() + "|" + getDate();
  }
}
