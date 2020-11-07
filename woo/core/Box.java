package woo.core;

import java.io.Serializable;

public class Box extends Product implements Serializable {

  private ServiceType _serviceType;

  protected Box(String id, String supplierId, int price, int crit, int q, ServiceType s){
    super(id, supplierId, price, crit, q);
    _serviceType = s;
  }

  public ServiceType getServiceType(){
    return _serviceType;
  }

  @Override
  public String toString() {
    return getId() + " | " + getSupplierId() + " | " + getPrice() + " | " + getCriticalValue() + " | "
          + getCurrentQuantity() + " | " + getServiceType();
  }
}
