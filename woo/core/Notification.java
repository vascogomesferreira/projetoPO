package woo.core;

import java.io.Serializable;

public class Notification implements Serializable {

  private String _type;

  protected Notification(){

  }

  @Override
  public String toString() {
    return getType();
  }
}
