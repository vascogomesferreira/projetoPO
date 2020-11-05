package woo.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

abstract public class Transaction implements Serializable {

  private int _cost;
  private int _id;
  private int _date;

  protected Transaction(int id, int cost, int date){
    _id = id;
    _cost = cost;
    _date = date;
  }

  public int getCost() {
    return _cost;
  }

  @Override
  public String toString() {
    return getId() + " | " ;
  }
}
