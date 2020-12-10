package woo.core.exception;

/**
 * Class for representing a read error.
 */
public class UnknownCoreServiceType extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

  /** Bad bad entry specification. */
  private String _serviceType;

  /**
   * @param entrySpecification
   */
  public UnknownCoreServiceType(String serviceType) {
    _serviceType = serviceType;
  }

  /**
   * @param entrySpecification
   * @param cause
   */
  public UnknownCoreServiceType(String serviceType, Exception cause) {
    super(cause);
    _serviceType = serviceType;
  }

  /**
   * @return the bad entry specification.
   */
  public String getServiceType() {
    return _serviceType;
  }

}
