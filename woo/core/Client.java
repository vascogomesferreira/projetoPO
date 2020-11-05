package woo.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Client implements Serializable {

  private String _id;
  private String _name;
  private String _address;
  private ClientStatus _status;
  private int _points;
  private List<Transaction> _transactions;
  private List<Notification> _notifications;

  protected Client(String id, String name, String address, ClientStatus status){
    _id = id;
    _name = name;
    _address = address;
    _status = status;
    _points = 0;
    _transactions = new ArrayList<>();
    _notifications = new ArrayList<>();
  }

  public List<Transaction> getTransactions(){
    return _transactions;
  }

  public String getId(){
    return _id;
  }

  public String getName(){
    return _name;
  }

  public String getAddress(){
    return _address;
  }

  public ClientStatus getStatus(){
    return _status;
  }

  // public int getMadePurchases(){
  //   int _madePurchases;
  //   Iterator<Transaction> iter = _transactions.iterator();
  //
  //   while (iter.hasNext()){
  //     Transaction transaction = iter.next();
  //     _madePurchases += transaction.getCost();
  //   }
  //   return _madePurchases;
  // }
  //
  // public int getPaidPurchases(){
  //   int _paidPurchases;
  //   Iterator<Transaction> iter = _transactions.iterator();
  //
  //   while (iter.hasNext()){
  //     Transaction transaction = iter.next();
  //     _paidPurchases += transaction.getAmountPaid();
  //   }
  //   return _paidPurchases;
  // }

  @Override
  public String toString() {
    return getId() + " | " + getName() + " | " + getAddress() + " | "
          + getStatus() + " | ";
          // + getMadePurchases() + " | " + getPaidPurchases();
  }
}
