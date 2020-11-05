package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Supplier implements Serializable {

  private String _id;
  private String _name;
  private String _address;
  private boolean _enabled;
  private Map<Integer, Product> _products;

  protected Supplier(String id, String name, String address, boolean enabled){
    _id = id;
    _name = name;
    _address = address;
    _enabled = enabled;
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

  public boolean toogleActivation(){
    _enabled = !_enabled;

    return _enabled;
  }

  // public List<Transaction> getTransactions(){
  //
  // }

  @Override
  public String toString() {
    return getId();
  }
}
