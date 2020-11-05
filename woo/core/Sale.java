package woo.core;

import java.io.Serializable;

public class Sale extends Transaction implements Serializable {

  private int _paymentDate;
  private int _amountPaid;

  protected Sale(){

  }

  public int getPaymentDate(){
    return _paymentDate;
  }

  public int getAmountPaid(){
    return _amountPaid;
  }

  @Override
  public String getResponsible(){
    return getDirector();
  }

  @Override
  public String getType(){
    return "DVD";
  }

  @Override
  public String toString() {
    return getId() + " - " + getRemainingCopies() + " de " + getNumberOfCopies() + " - "
          + getType() + " - " + getTitle() + " - " + getPrice() + " - " + getCategory().toString()
          + " - " + getDirector() + " - " + getIgac();
  }
}
