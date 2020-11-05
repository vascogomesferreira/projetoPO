package woo.core;

import java.io.Serializable;

public class Box extends Product implements Serializable {

  private ServiceLevel _serviceLevel;

  protected Box(String id, int price, int q, ServiceLevel s){

  }

  @Override
  public String toString() {

  }
}
