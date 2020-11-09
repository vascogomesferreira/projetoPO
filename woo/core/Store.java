package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import woo.app.exception.InvalidDateException;
import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.UnknownClientKeyException;
import woo.app.exception.DuplicateClientKeyException;
import woo.app.exception.DuplicateSupplierKeyException;

import woo.core.exception.MissingFileAssociationException;
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

  protected List<Supplier> getAllSuppliers(){
    List<Supplier> suppliers = new ArrayList<Supplier>(_suppliers.values());

    Comparator<Supplier> comparator = new Comparator<Supplier>() {
      public int compare(Supplier s1, Supplier s2) {
        return s1.getId().compareTo(s2.getId());
      }
    };

    suppliers.sort(comparator);
    return suppliers;
  }

  protected void registerSupplier(String id, String name, String address) throws DuplicateSupplierKeyException{
    _suppliers.put(id, new Supplier(id, name, address));
  }

  protected void addSupplier(Supplier supplier) {
    String id = supplier.getId();
    _suppliers.put(id, supplier);
  }

  protected List<Client> getAllClients(){
    List<Client> clients = new ArrayList<Client>(_clients.values());

    Comparator<Client> comparator = new Comparator<Client>() {
      public int compare(Client c1, Client c2) {
        return c1.getId().compareTo(c2.getId());
      }
    };

    clients.sort(comparator);
    return clients;
  }

  protected Client getClient(String id) throws UnknownClientKeyException {
    if (_clients.containsKey(id)) {
      return _clients.get(id);
    } else {
      throw new UnknownClientKeyException(id);
    }
  }

  protected void registerClient(String id, String name, String address) throws DuplicateClientKeyException {
    _clients.put(id, new Client(id, name, address));
  }

  protected void addClient(Client client) {
    String id = client.getId();
    _clients.put(id, client);
  }

  protected void registerProductBook(String id, String supplierId, int price, int crit, int q, String title, String author, String isbn) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Book(id, supplierId, price, crit, q, title, author, isbn));
  }

  protected void registerProductBox(String id, String supplierId, int price, int crit, int q, ServiceType s) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Box(id, supplierId, price, crit, q, s));
  }

  protected void registerProductContainer(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Container(id, supplierId, price, crit, q, s, level));
  }

  protected void addProduct(Product product){
    String id = product.getId();
    _products.put(id,product);
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

  protected int advanceDay(int numberOfDays) throws InvalidDateException {
    if (numberOfDays > 0)
      _date += numberOfDays;

    return numberOfDays;
  }

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException /* FIXME maybe other exceptions */ {
    MyParser parse = new MyParser(this);
    parse.parseFile(txtfile);
  }

}
