package woo.core;

import java.io.Serializable;

public class Sale extends Transaction implements Serializable {

  private String _productId;
  private String _productType;
  private int _amount;
  private int _priceWithDelay;
  private int _paymentDeadline;
  private int _amountPaid;
  private int _paymentDate;

  protected Sale(int id, String clientId, String productId, int amount, int cost, int date, int paymentDeadline, int amountPaid){
    super(id, clientId, cost, date);
    _productId = productId;
    _amount = amount;
    _paymentDeadline = paymentDeadline;
    _amountPaid = amountPaid;
  }

  protected Sale(int id, String clientId, String productId, int amount, int cost, int date, int paymentDeadline){
    super(id, clientId, cost, date);
    _productId = productId;
    _amount = amount;
    _paymentDeadline = paymentDeadline;
  }

  public String getProductId(){
    return _productId;
  }

  public int getAmount(){
    return _amount;
  }

  public int getRealAmount(){
    return _priceWithDelay;
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

  public void setPriceWithDelayOrDiscount(int discount, int fine, int daysAfter){
    _priceWithDelay = getCost() * discount + (daysAfter * (getCost() * fine));
  }

  @Override
  public String toString() {
    return getTransId() + "|" + getId() + "|" + getProductId() + "|" + getAmount()
    + "|" + getCost() + "|" + getRealAmount() + "|" + getPaymentDeadline() + "|"
     + getPaymentDate();
  }
}
