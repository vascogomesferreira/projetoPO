package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

abstract public class Product implements Serializable {

  private int _price;
  private int _criticalValue;
  private int _currentQuantity;
  private String _id;
  private Supplier _supplier;
  private Map<String, Client> _clients;

  protected Product(String id, int price, int crit, int q){
    _id = id;
    _price = price;
    _criticalValue = crit;
    _currentQuantity = q;
    _clients = new HashMap<>();
  }

  public String getId(){
    return _id;
  }

  public int getPrice(){
    return _price;
  }



  @Override
  public String toString() {
    return getId();
  }
}
