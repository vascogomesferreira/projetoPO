package woo.core;

public enum ServiceType {

  NORMAL("NORMAL"),
  AIR("AIR"),
  EXPRESS("EXPRESS"),
  BY_HAND("BY_HAND");

  private String _serviceType;

  private ServiceType(String serviceType) {
    _serviceType = serviceType;
  }

  public String toString() {
    return _serviceType;
  }
}
