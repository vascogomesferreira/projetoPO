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

  protected Client(String id, String name, String address){
    _id = id;
    _name = name;
    _address = address;
    _status = ClientStatus.NORMAL;
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

  public int getMadePurchases(){
    int _madePurchases = 0;
    Iterator<Transaction> iter = _transactions.iterator();

    while (iter.hasNext()){
      Transaction transaction = iter.next();
      _madePurchases += transaction.getCost();
    }
    return _madePurchases;
  }

  public int getPaidPurchases(){
    int _paidPurchases = 0;
    Iterator<Transaction> iter = _transactions.iterator();

    while (iter.hasNext()){
      Transaction transaction = iter.next();
      _paidPurchases += transaction.getAmountPaid();
    }
    return _paidPurchases;
  }

  // public List<Notification> getNotifications(){
  //   List<Notification> notifications = new ArrayList<>(_notifications);
  //
  //   Iterator<Notification> iter = notifications.iterator();
  //
  //   while (iter.hasNext()){
  //     Notification nextNotification = iter.next();
  //     // if (nextNotification.getActive()){
  //     //   notifications.remove(nextNotification);
  //     // }
  //   }
  //
  //   _notifications.clear();
  //   return notifications;
  // }

  // public void addProductNotification(Product product){
  //   Notification notification = new Notification(product);
  //   _notifications.add(notification);
  // }
  //
  // public String toggleNotifications(Product product){
  //   Iterator<Notification> iter = _notifications.iterator();
  //
  //   while (iter.hasNext()){
  //     Notification isEqual = iter.next();
  //     if ((isEqual.getId().contains(product.getId()))){
  //       _notifications.remove(isEqual);
  //     }
  //   }
  // }

  @Override
  public String toString() {
    return getId() + "|" + getName() + "|" + getAddress() + "|"
          + getStatus() + "|"
          + getMadePurchases() + "|" + getPaidPurchases() + ("\n");
          // + getNotifications();
  }
}
