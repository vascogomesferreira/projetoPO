package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

abstract public class Product implements Serializable {

  private String _id;
  private String _supplierId;
  private int _price;
  private int _criticalValue;
  private int _currentQuantity;

  private Map<String, Client> _clients;

  protected Product(String id, String supplierId, int price, int crit, int q){
    _id = id;
    _supplierId = supplierId;
    _price = price;
    _criticalValue = crit;
    _currentQuantity = q;
    _clients = new HashMap<>();
  }

  public String getId(){
    return _id;
  }

  public String getSupplierId(){
    return _supplierId;
  }

  public int getPrice(){
    return _price;
  }

  public int getCriticalValue(){
    return _criticalValue;
  }

  public int getCurrentQuantity(){
    return _currentQuantity;
  }


  @Override
  public abstract String toString();
}
