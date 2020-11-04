package woo.core;

public enum ServiceLevel {

  NORMAL("NORMAL"), AIR("AIR"), EXPRESS("EXPRESS"), BY_HAND("BY_HAND");

  private String _serviceLevel;

  private ServiceLevel(String serviceLevel) {
    _serviceLevel = serviceLevel;
  }

  public String toString() {
    return _serviceLevel;
  }
}
