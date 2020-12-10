package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import woo.app.suppliers.Message;

public class Supplier implements Serializable {

  private String _id;
  private String _name;
  private String _address;
  private boolean _enabled;
  private Map<Integer, Product> _products;

  protected Supplier(String id, String name, String address){
    _id = id;
    _name = name;
    _address = address;
    _enabled = true;
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

  public String getEnabled() {
    if (_enabled)
      return Message.yes();
    else
      return Message.no();
  }

  public String toogleTransactions(String supplierId){
    _enabled = !_enabled;

    if (_enabled) {
      return Message.transactionsOn(supplierId);
    }
    else {
      return Message.transactionsOff(supplierId);
    }

  }

  // public List<Transaction> getTransactions(){
  //
  // }

  @Override
  public String toString() {
    return getId() + "|" + getName() + "|" + getAddress() + "|" + getEnabled();
  }
}
