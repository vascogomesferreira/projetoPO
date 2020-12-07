package woo.core;

import java.io.Serializable;

public class Sale extends Transaction implements Serializable {

  private int _paymentDate;
  private int _amountPaid;

  protected Sale(int id, int cost, int date, int paymentDate, int amountPaid){
    super(id, cost, date);
    _paymentDate = paymentDate;
    _amountPaid = amountPaid;
  }

  public int getPaymentDate(){
    return _paymentDate;
  }

  public int getAmountPaid(){
    return _amountPaid;
  }

  @Override
  public String toString() {
    return getPaymentDate() + " | ";
  }
}
