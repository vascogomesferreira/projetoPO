package woo.core;

import java.io.Serializable;

public class Client implements Serializable {

  private String _id;
  private String _name;
  private String _address;
  private ClientStatus _status;
  private int _points;

  protected Client(){

  }

  public getTransactions(){

  }

  @Override
  public String toString() {
    return getId() + " | " + getName() + " | " + getAddress() + " | "
          + getStatus() + " | " + getMadePurchases() + " | " + getPaidPurchases();
  }
}
