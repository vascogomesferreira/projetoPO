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
 * @author Vasco Gomes Ferreira - 87132
 * @author Manuel Carneiro - 89927
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;

  /**
  * Stores the current date
  */
  private int _date;
  /**
  * The ID of the next transaction
  */
  private int _nextTransactionId;
  /**
  * A map that contains all the products
  */
  private Map<String, Product> _products;
  /**
  * A map that contains all the transactions
  */
  private Map<Integer, Transaction> _transactions;
  /**
  * A map that contains all the clients
  */
  private Map<String, Client> _clients;
  /**
  * A map that contains all the suppliers
  */
  private Map<String, Supplier> _suppliers;

  /**
  * The constructor of the class Store.
  * It creats four HashMaps and initializes the date
  */
  public Store(){
    _date = 0;
    _products = new HashMap<>();
    _transactions = new HashMap<>();
    _clients = new HashMap<>();
    _suppliers = new HashMap<>();
  }

  /**
  * @return a sorted list that contains all the suppliers
  */
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

  /**
  * Registrates a supplier with his arguments
  * @param id
  * @param name
  * @param address
  * @throws DuplicateSupplierKeyException
  */
  protected void registerSupplier(String id, String name, String address) throws DuplicateSupplierKeyException{
    _suppliers.put(id, new Supplier(id, name, address));
  }

  /**
  * Adds an instance of a supplier to the HashMap
  * @param supplier
  */
  protected void addSupplier(Supplier supplier) {
    String id = supplier.getId();
    _suppliers.put(id, supplier);
  }

  /**
  * @return a sorted list that contains all the clients
  */
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

  /**
  * @param ID
  * @throws UnknownClientKeyException
  * @return A specific client based on his ID
  */
  protected Client getClient(String id) throws UnknownClientKeyException {
    if (_clients.containsKey(id)) {
      return _clients.get(id);
    } else {
      throw new UnknownClientKeyException(id);
    }
  }

  /**
  * Registrates a client with his arguments
  * @param ID
  * @param name
  * @param address
  * @throws DuplicateClientKeyException
  */
  protected void registerClient(String id, String name, String address) throws DuplicateClientKeyException {
    _clients.put(id, new Client(id, name, address));
  }

  /**
  * Adds an instance of a client to the HashMap
  * @param client
  */
  protected void addClient(Client client) {
    String id = client.getId();
    _clients.put(id, client);
  }

  /**
  * Registrates a client with his arguments
  * @param ID
  * @param supplierid
  * @param price
  * @param crit critical value
  * @param title
  * @param author
  * @param isbn
  * @throws DuplicateProductKeyException
  * @throws UnknownSupplierKeyException
  */
  protected void registerProductBook(String id, String supplierId, int price, int crit, int q, String title, String author, String isbn) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Book(id, supplierId, price, crit, q, title, author, isbn));
  }

  /**
  * Registrates a client with his arguments
  * @param ID
  * @param supplierid
  * @param price
  * @param crit critical value
  * @param ServiceType
  * @throws DuplicateProductKeyException
  * @throws UnknownSupplierKeyException
  */
  protected void registerProductBox(String id, String supplierId, int price, int crit, int q, ServiceType s) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Box(id, supplierId, price, crit, q, s));
  }

  /**
  * Registrates a client with his arguments
  * @param ID
  * @param supplierid
  * @param price
  * @param crit critical value
  * @param ServiceType
  * @param ServiceLevel
  * @throws DuplicateProductKeyException
  * @throws UnknownSupplierKeyException
  */
  protected void registerProductContainer(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _products.put(id, new Container(id, supplierId, price, crit, q, s, level));
  }

  /**
  * Adds an instance of a product to the HashMap
  * @param product
  */
  protected void addProduct(Product product){
    String id = product.getId();
    _products.put(id,product);
  }

  /**
  * @return a sorted list that contains all the products
  */
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

  protected void changeProductPrice(String productId, int newPrice){
    String lowerCase = productId.toLowerCase();
    List<Product> products = getAllProducts();

    Iterator<Product> iter = products.iterator();

    while (iter.hasNext()){
      Product isEqual = iter.next();
      if ((isEqual.getId().toLowerCase().contains(lowerCase))){
        isEqual.setPrice(newPrice);
      }
    }
  }

  /**
  * Increases the date by the number of days
  * @return the actual date
  */
  protected int getDate(){
    return _date;
  }

  /**
  * Advances the date the specified number of days
  * @param numberOfDays
  * @throws InvalidDateException
  * @return the increased date
  */
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
