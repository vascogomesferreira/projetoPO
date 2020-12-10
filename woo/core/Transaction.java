package woo.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

abstract public class Transaction implements Serializable {

  private int _transactionId;
  private int _cost;
  private String _id;
  private int _date;

  protected Transaction(int transactionId, String id, int cost, int date){
    _transactionId = transactionId;
    _id = id;
    _cost = cost;
    _date = date;
  }
  
  public int getAmountPaid() {
    if (_date == 0) {
      return _cost;
    }
    else {
      return 0;
    }
  }

  public int getDate(){
    return _date;
  }

  public int getCost() {
    return _cost;
  }

  public int getTransId(){
    return _transactionId;
  }

  public String getId(){
    return _id;
  }

  @Override
  public abstract String toString();
}
