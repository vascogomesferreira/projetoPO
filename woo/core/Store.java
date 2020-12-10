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
import woo.app.exception.UnknownServiceTypeException;
import woo.app.exception.UnknownServiceLevelException;
import woo.app.exception.UnknownTransactionKeyException;


import woo.core.exception.MissingFileAssociationException;
import woo.core.exception.BadEntryException;
import woo.core.exception.UnknownCoreServiceType;

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

  /**/
  private Map<String, List<String>> _notificationsReceivers;

  /**
  * The constructor of the class Store.
  * It creats four HashMaps and initializes the date
  */
  public Store(){
    _date = 0;
    _nextTransactionId = 0;
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
        return s1.getId().toLowerCase().compareTo(s2.getId().toLowerCase());
      }
    };

    suppliers.sort(comparator);
    return suppliers;
  }

  protected Supplier getSupplier(String id) throws UnknownSupplierKeyException {
    if (_suppliers.containsKey(id)) {
      return _suppliers.get(id);
    } else {
      throw new UnknownSupplierKeyException(id);
    }
  }

  /**
  * Registrates a supplier with his arguments
  * @param id
  * @param name
  * @param address
  * @throws DuplicateSupplierKeyException
  */
  protected void registerSupplier(String id, String name, String address) throws DuplicateSupplierKeyException{
    if (!(_suppliers.containsKey(id))){
      _suppliers.put(id, new Supplier(id, name, address));
    } else {
      throw new DuplicateSupplierKeyException(id);
    }
  }

  /**
  * Adds an instance of a supplier to the HashMap
  * @param supplier
  */
  protected void addSupplier(Supplier supplier) {
    String id = supplier.getId();
    _suppliers.put(id, supplier);
  }

  protected String toggleSupplierActive(String supplierId) throws UnknownSupplierKeyException{
    if (_suppliers.containsKey(supplierId)){
      return _suppliers.get(supplierId).toogleTransactions(supplierId);
    } else {
      throw new UnknownSupplierKeyException(supplierId);
    }

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
    if (!(_clients.containsKey(id))){
      _clients.put(id, new Client(id, name, address));
    } else {
      throw new DuplicateClientKeyException(id);
    }
  }

  /**
  * Adds an instance of a client to the HashMap
  * @param client
  */
  protected void addClient(Client client) {
    String id = client.getId();
    _clients.put(id, client);
  }

  protected void addProductNotification(String productId){
    List<Client> clients = getAllClients();

    Iterator<Client> iter = clients.iterator();

    while (iter.hasNext()){
      Client nextClient = iter.next();
      // nextClient.addProductNotification(productId);
    }
  }

  protected void toggleProductNotification(String clientId, String productId) throws UnknownClientKeyException{
    Client client = getClient(clientId);
    // client.toggleNotifications(productId);
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
    if (!(_products.containsKey(id))){
      if(_suppliers.containsKey(supplierId)){
        _products.put(id, new Book(id, supplierId, price, crit, q, title, author, isbn));
        // addProductNotification(id);
      }
      else {
        throw new UnknownSupplierKeyException(supplierId);
      }
    } else {
      throw new DuplicateProductKeyException(id);
    }
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
  protected void registerProductBox(String id, String supplierId, int price, int crit, int q, String s) throws DuplicateProductKeyException, UnknownSupplierKeyException, UnknownServiceTypeException {
    if (!(_products.containsKey(id))){
      if(_suppliers.containsKey(supplierId)){
        _products.put(id, new Box(id, supplierId, price, crit, q, ServiceType.valueOf(s)));
        // addProductNotification(id);
      }
      else {
        throw new UnknownSupplierKeyException(supplierId);
      }
    } else {
      throw new DuplicateProductKeyException(id);
    }
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
  protected void registerProductContainer(String id, String supplierId, int price, int crit, int q, String s, String level) throws DuplicateProductKeyException, UnknownSupplierKeyException, UnknownServiceTypeException, UnknownServiceLevelException, UnknownCoreServiceType {
    if (!(_products.containsKey(id))){
      if(_suppliers.containsKey(supplierId)){
        _products.put(id, new Container(id, supplierId, price, crit, q, ServiceType.valueOf(s), ServiceLevel.valueOf(level)));
        // addProductNotification(id);
      }
      else {
        throw new UnknownSupplierKeyException(supplierId);
      }
    } else {
      throw new DuplicateProductKeyException(id);
    }
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

  protected List<Product> getProductsUnder(int price){
      List<Product> products = getAllProducts();
      List<Product> _productsUnder = new ArrayList<Product>();

      Iterator<Product> iter = products.iterator();

      while (iter.hasNext()){
        Product isEqual = iter.next();
        if ((isEqual.getPrice() < price)){
          _productsUnder.add(isEqual);
        }
      }
    return _productsUnder;
  }

  protected void changeProductPrice(String productId, int newPrice) {
    if (newPrice > 0) {
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
  }

  protected void registerOrder(String supplierId, String productId, int q) throws UnknownSupplierKeyException {
    int price = 0;
    int orderPrice = 0;

    String lowerCase = productId.toLowerCase();
    List<Product> products = getAllProducts();
    Supplier supplier = getSupplier(supplierId);


    Iterator<Product> iter = products.iterator();

    while (iter.hasNext()){
      Product isEqual = iter.next();
      if ((isEqual.getId().toLowerCase().contains(lowerCase))){
        price = isEqual.getPrice();
      }
    }

    orderPrice = q * price;


    if (supplier.getEnabled().equals("SIM")) {
      _transactions.put(_nextTransactionId, new Order(_nextTransactionId, supplierId, orderPrice, getDate()));
      _nextTransactionId++;
    }
  }

  protected void registerSale(String clientId, int paymentDeadline, String productId, int amount){
    int price = 0;
    int salePrice = 0;
    int currentQuantity = 0;

    String lowerCase = productId.toLowerCase();
    List<Product> products = getAllProducts();


    Iterator<Product> iter = products.iterator();

    while (iter.hasNext()){
      Product isEqual = iter.next();
      if ((isEqual.getId().toLowerCase().contains(lowerCase))){
        price = isEqual.getPrice();
        currentQuantity = isEqual.getCurrentQuantity();
      }
    }


    salePrice = amount * price;

    _transactions.put(_nextTransactionId, new Sale(_nextTransactionId, clientId, productId, amount, salePrice, getDate(), paymentDeadline));
    _nextTransactionId++;
  }

  protected Transaction getTransaction(int id) throws UnknownTransactionKeyException {
    if (_transactions.containsKey(id)) {
      return _transactions.get(id);
    }
    else {
      throw new UnknownTransactionKeyException(id);
    }
  }

  protected List<Transaction> getSupplierTransactions(String supplierId) throws UnknownSupplierKeyException{
    if (_suppliers.containsKey(supplierId)){
      String lowerCase = supplierId.toLowerCase();
      List<Transaction> transactions = new ArrayList<Transaction>(_transactions.values());
      List<Transaction> supplierTransactions = new ArrayList<Transaction>();

      Iterator<Transaction> iter = transactions.iterator();

      while (iter.hasNext()){
        Transaction containsSupplier = iter.next();
        if ((containsSupplier.getId().toLowerCase().contains(lowerCase))){
            supplierTransactions.add(containsSupplier);
        }
      }
      return supplierTransactions;
    } else {
      throw new UnknownSupplierKeyException(supplierId);
    }
  }

  protected List<Transaction> getClientTransactions(String clientId){
    String lowerCase = clientId.toLowerCase();
    List<Transaction> transactions = new ArrayList<Transaction>(_transactions.values());
    List<Transaction> clientTransactions = new ArrayList<Transaction>();

    Iterator<Transaction> iter = transactions.iterator();

    while (iter.hasNext()){
      Transaction containsClient = iter.next();
      if ((containsClient.getId().toLowerCase().contains(lowerCase))){
          clientTransactions.add(containsClient);
      }
    }

    // Comparator<Transaction> comparator = new Comparator<Transaction>() {
    //   public int compare(Transaction t1, Transaction t2) {
    //     return t1.getTransId() - t2.getTransId();
    //   }
    // };
    //
    // clientTransactions.sort(comparator);
    return clientTransactions;
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
