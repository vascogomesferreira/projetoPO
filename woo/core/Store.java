package woo.core;

//FIXME import classes (cannot import from pt.tecnico or woo.app)
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

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
  private int _nextTransactionId;

  private Map<String, Product> _products;
  private Map<Integer, Transaction> _transactions;
  private Map<String, Client> _clients;
  private Map<String, Supplier> _suppliers;

  // FIXME define contructor(s)
  public Store(){
    _date = 0;
    _products = new HashMap<>();
    _transactions = new HashMap<>();
    _clients = new HashMap<>();
    _suppliers = new HashMap<>();
  }

  protected void registerProductContainer(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level) {
    _products.put(id, new Container(id, supplierId, price, crit, q, s, level));
  }

  protected void addProduct(Product product){
    String id = product.getId();
    _products.put(id,product);
    System.out.println(id);
  }

  protected List<Product> getAllProducts(){
    List<Product> products = new ArrayList<Product>(_products.values());

    Comparator<Product> comparator = new Comparator<Product>() {
      public int compare(Product p1, Product p2) {
        return p1.getId().compareTo(p2.getId());
      }
    };

    products.sort(comparator);
    return products;
  }

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
