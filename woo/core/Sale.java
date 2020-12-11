package woo.core;

import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

public class Sale extends Transaction implements Serializable {

  private String _productId;
  private int _quantity;
  private int _priceWithDelay = 1;
  private int _paymentDeadline;
  private int _amountPaid = 0;
  private int _paymentDate;

  protected Sale(int id, String clientId, int cost, int date, String productId, int quantity, List<Item> items, int paymentDeadline, int amountPaid){
    super(id, clientId, cost, date, items);
    _productId = productId;
    _quantity = quantity;
    _paymentDeadline = paymentDeadline;
    _amountPaid = amountPaid;
  }

  protected Sale(int id, String clientId, int cost, int date, String productId, int quantity, List<Item> items, int paymentDeadline){
    super(id, clientId, cost, date, items);
    _productId = productId;
    _quantity = quantity;
    _paymentDeadline = paymentDeadline;
  }

  public String getProductId(){
    return _productId;
  }

  public int getQuantity(){
    return _quantity;
  }

  public int getRealAmount(){
    return (getCost() * _priceWithDelay);
  }

  public int getPaymentDeadline(){
    return _paymentDeadline;
  }

  public int getAmountPaid(){
    return _amountPaid;
  }

  public int getPaymentDate(){
    return _paymentDate;
  }

  protected void setPriceWithDelayOrDiscount(int discount, int fine, int daysAfter){
    _priceWithDelay = getCost() * discount + (daysAfter * (getCost() * fine));
  }

  @Override
  public String toString() {
    return getTransId() + "|" + getId() + "|" + getProductId() + "|" + getQuantity() +
    "|" + getCost() + "|" + getRealAmount() + "|" + getPaymentDeadline();
  }
}
