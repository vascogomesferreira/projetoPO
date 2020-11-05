package woo.core;

//FIXME import classes (cannot import from pt.tecnico or woo.app)
import java.io.Serializable;

import java.io.IOException;

import woo.core.exception.BadEntryException;

/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;

  // FIXME define attributes
  // Stores the date
  private int _date;
  private Map<String, Product> _products;
  private Map<Integer, Transaction> _transactions;
  private Map<String, Client> _clients;
  private Map<String, Supplier> _suppliers;

  // FIXME define contructor(s)
  public Store(){
    _date = 0;
  }

  // FIXME define methods
  // Increases the date by the number of days
  protected int getDate(){
    return _date;
  }

  protected void advanceDay(int numberOfDays){
    if (numberOfDays != 0)
      _date += numberOfDays;
  }

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException /* FIXME maybe other exceptions */ {
    //FIXME implement method
  }

}
