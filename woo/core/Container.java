package woo.core;

import java.io.Serializable;

public class Container extends Box implements Serializable {

  private ServiceQuality _serviceQuality;

  protected Container(String id, int price, int q, ServiceLevel s, ServiceQuality quality){
      super(id, price, crit, q, s);
      _serviceQuality = quality;
    }
  }

  @Override
  public String toString() {

  }
}
