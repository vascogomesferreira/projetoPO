package woo.core;

import java.io.Serializable;

public class Box extends Product implements Serializable {

  private ServiceLevel _serviceLevel;

  protected Box(String id, int price, int crit, int q, ServiceLevel s){
    super(id, price, crit, q);
    _serviceLevel = s;
  }

  @Override
  public String toString() {

  }
}
