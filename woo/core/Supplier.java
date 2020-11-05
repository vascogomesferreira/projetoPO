package woo.core;

import java.io.Serializable;

public class Supplier implements Serializable {

  private String _id;
  private String _name;
  private String _address;
  private boolean _enabled;

  protected Supplier(String id, int crit, int q){

  }

  public boolean toogleActivation(){

  }

  public List<Transaction> getTransactions(){
    
  }

  @Override
  public String toString() {

  }
}
