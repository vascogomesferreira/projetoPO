package woo.core;

public enum ServiceLevel {

  B4("B4"),
  C4("C4"),
  C5("C5"),
  DL("DL");

  private String _serviceLevel;

  private ServiceLevel(String serviceLevel) {
    _serviceLevel = serviceLevel;
  }

  public String toString() {
    return _serviceLevel;
  }
}
