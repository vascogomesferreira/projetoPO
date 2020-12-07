package woo.core;

public enum ClientStatus {

  NORMAL("NORMAL"), ELITE("ELITE"), SELECTION("SELECTION");

  private String _clientStatus;

  private ClientStatus(String clientStatus) {
    _clientStatus = clientStatus;
  }

  public String toString() {
    return _clientStatus;
  }
}
