package woo.core;

import java.io.Serializable;

public class Notification implements Serializable {

  private String _type;
  private Product _product;

  protected Notification(String type, Product p){
    _type = type;
    _product = p;
  }

  public String getType(){
    return _type;
  }

  @Override
  public String toString() {
    return getType() + " | ";
  }
}
