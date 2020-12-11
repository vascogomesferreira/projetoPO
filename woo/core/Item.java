package woo.core;

import java.io.Serializable;

public class Item implements Serializable {

  private String _productId;
  private int _quantity;

  protected Item(String productId, int quantity){
    _productId = productId;
    _quantity = quantity;
  }

  public String getProductId(){
    return _productId;
  }

  public int getQuantity(){
    return _quantity;
  }

  protected void setProductId(String productId){
    _productId = productId;
  }

  protected void setQuantity(int quantity){
    _quantity = quantity;
  }

  public String toString(){
    return getProductId() + "|" + getQuantity();
  }

}
