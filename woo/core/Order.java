package woo.core;

import java.io.Serializable;

public class Order extends Transaction implements Serializable {

  protected Order(){

  }

  public String getIgac(){
    return _igac;
  }

  public String getDirector(){
    return _director;
  }

  @Override
  public String getResponsible(){
    return getDirector();
  }

  @Override
  public String getType(){
    return "DVD";
  }

  @Override
  public String toString() {
    return getId() + " - " + getRemainingCopies() + " de " + getNumberOfCopies() + " - "
          + getType() + " - " + getTitle() + " - " + getPrice() + " - " + getCategory().toString()
          + " - " + getDirector() + " - " + getIgac();
  }
}
