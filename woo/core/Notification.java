package woo.core;

import java.io.Serializable;

public class Notification implements Serializable {

  private String _type;
  private Product _product;
  // private int _value = 0;
  // private boolean _isActive;
  // private NotificationDelivery _deliveryMethod;

  // protected Notification(String type, String productId, boolean isActive, NotificationDelivery delivery){
  //   _type = type;
  //   _productId = productId;
  //   _isActive = isActive;
  //   _deliveryMethod = delivery;
  // }

  protected Notification(String type, Product product){
    _type = type;
    _product = product;
  }

  protected Notification(Product product){
    _product = product;
    // _isActive = Boolean.TRUE;
    // _deliveryMethod = NotificationDelivery.NORMAL;
  }

  public String getType(){
    return _type;
  }

  public String getProductId(){
    return _product.getId();
  }

  // public int getProductPrice(){
  //   return _product.getPrice();
  // }

  // public boolean getActive() {
  //   return _isActive;
  // }
  //
  // public NotificationDelivery getDeliveryMethod(){
  //   return _deliveryMethod;
  // }

  // public int getValue(){
  //   return _value;
  // }
  //
  // public boolean toggleNotifications(){
  //   return _isActive = (!_isActive);
  // }

  @Override
  public String toString() {
    return getType() + "|" + getProductId() + "|";
    // + getValue();
  }
}
