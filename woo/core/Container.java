package woo.core;

import java.io.Serializable;

public class Container extends Box implements Serializable {

  private ServiceLevel _serviceLevel;

  protected Container(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level){
      super(id, supplierId, price, crit, q, s);
      _serviceLevel = level;
  }

  public ServiceLevel getServiceLevel(){
    return _serviceLevel;
  }

  @Override
  public String toString() {
    return "CONTAINER|" + getId() + "|" + getSupplierId() + "|" + getPrice() + "|" + getCriticalValue() + "|"
          + getCurrentQuantity() + "|" + getServiceType() + "|" + getServiceLevel();
  }
}
