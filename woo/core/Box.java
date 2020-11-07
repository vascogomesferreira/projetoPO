package woo.core;

import java.io.Serializable;

public class Box extends Product implements Serializable {

  private ServiceType _serviceType;

  protected Box(String id, int price, int crit, int q, ServiceType s){
    super(id, price, crit, q);
    _serviceType = s;
  }

  public ServiceType getServiceType(){
    return _serviceType;
  }

  @Override
  public String toString() {
    return getId() + " | " + getSupplier() + " | " + getPrice() + " | " + getCriticalValue() + " | "
          + getCurrentQuantity() + " | " + getServiceType();
  }
}
