package woo.core;

import java.io.Serializable;

public class Container extends Box implements Serializable {

  private ServiceLevel _serviceLevel;

  protected Container(String id, int price, int crit, int q, ServiceType s, ServiceLevel level){
      super(id, price, crit, q, s);
      _serviceLevel = level;
  }

  public ServiceLevel getServiceLevel(){
    return _serviceLevel;
  }

  @Override
  public String toString() {
    return getId() + " | " + getSupplier() + " | " + getPrice() + " | " + getCriticalValue() + " | "
          + getCurrentQuantity() + " | " + getServiceType() + " | " + getServiceLevel();
  }
}
