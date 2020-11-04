package woo.core;

public enum ServiceQuality {

  B4("B4"), C4("C4"), C5("C5"), DL("DL");

  private String _serviceQuality;

  private ServiceQuality(String serviceQuality) {
    _serviceQuality = serviceQuality;
  }

  public String toString() {
    return _serviceQuality;
  }
}
