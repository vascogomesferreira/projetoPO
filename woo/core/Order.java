package woo.core;

import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

public class Order extends Transaction implements Serializable {

  protected Order(int id, String supplierId, int cost, int date, List<Item> items){
    super(id, supplierId, cost, date, items);
  }

  @Override
  public String toString() {
    return getTransId() + "|" + getId() + "|" + getCost() + "|" + getDate();
  }
}
