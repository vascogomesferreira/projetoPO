package woo.core;

import java.io.Serializable;

public class Date implements Serializable {

  private int _date;

  protected int getCurrentDate(){
    return _date;
  }

  protected void advanceDay(int numberOfDays){
    if (numberOfDays > 0)
      _date += numberOfDays;
  }
}
