package woo.core;

public enum NotificationDelivery {

  NORMAL("NORMAL"),
  MAIL("MAIL"),
  SMS("SMS"),
  EMAIL("EMAIL");

  private String _notificationDelivery;

  private NotificationDelivery(String notificationDelivery) {
    _notificationDelivery = notificationDelivery;
  }

  public String toString() {
    return _notificationDelivery;
  }
}
