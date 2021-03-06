package woo.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import woo.core.exception.UnavailableFileException;
import woo.core.exception.MissingFileAssociationException;
import woo.core.exception.ImportFileException;
import woo.core.exception.BadEntryException;
import woo.core.exception.UnknownCoreServiceType;
import woo.app.exception.UnknownClientKeyException;
import woo.app.exception.InvalidDateException;
import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.InvalidDateException;
import woo.app.exception.DuplicateClientKeyException;
import woo.app.exception.DuplicateSupplierKeyException;
import woo.app.exception.UnknownServiceTypeException;
import woo.app.exception.UnknownServiceLevelException;
import woo.app.exception.UnknownTransactionKeyException;
import woo.app.exception.UnauthorizedSupplierException;
import woo.app.exception.UnknownProductKeyException;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * StoreManager: façade for the core classes.
 */
public class StoreManager {

  /** Current filename. */
  private String _filename = "";

  private String _savefile;

  /** The actual store. */
  private Store _store = new Store();

  public List<Supplier> getAllSuppliers() {
    return _store.getAllSuppliers();
  }

  public Supplier getSupplier(String id) throws UnknownSupplierKeyException {
    return _store.getSupplier(id);
  }

  public void registerSupplier(String id, String name, String address) throws DuplicateSupplierKeyException {
    _store.registerSupplier(id, name, address);
  }

  public void addSupplier(Supplier supplier) {
    _store.addSupplier(supplier);
  }

  public String toggleSupplierActive(String supplierId) throws UnknownSupplierKeyException{
    return _store.toggleSupplierActive(supplierId);
  }

  public List<Client> getAllClients() {
    return _store.getAllClients();
  }

  public Client getClient(String id) throws UnknownClientKeyException {
    return _store.getClient(id);
  }

  public void registerClient(String id, String name, String address) throws DuplicateClientKeyException {
    _store.registerClient(id, name, address);
  }

  public void addClient(Client client) {
    _store.addClient(client);
  }

  public void registerProductBook(String id, String supplierId, int price, int crit, int q, String title, String author, String isbn) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _store.registerProductBook(id, supplierId, price, crit, q, title, author, isbn);
  }

  public void registerProductBox(String id, String supplierId, int price, int crit, int q, String s) throws DuplicateProductKeyException, UnknownSupplierKeyException, UnknownServiceTypeException {
    _store.registerProductBox(id, supplierId, price, crit, q, s);
  }

  public void registerProductContainer(String id,  String supplierId, int price, int crit, int q, String s, String level) throws DuplicateProductKeyException, UnknownSupplierKeyException, UnknownServiceLevelException, UnknownServiceTypeException, UnknownCoreServiceType {
    _store.registerProductContainer(id,  supplierId, price, crit, q, s, level);
  }

  public void addProduct(Product product){
    _store.addProduct(product);
  }

  public List<Product> getAllProducts(){
    return _store.getAllProducts();
  }

  public List<Product> getProductsUnder(int price){
    return _store.getProductsUnder(price);
  }

  public void changeProductPrice(String productId, int newPrice) {
    _store.changeProductPrice(productId, newPrice);
  }

  public void registerOrder(String supplierId, List<Item> items) throws IOException, UnknownSupplierKeyException, UnknownProductKeyException, UnauthorizedSupplierException {
    _store.registerOrder(supplierId, items);
  }

  public List<Item> registerItems(List<String> productIds, List<Integer> quantities){
    return _store.registerItems(productIds, quantities);
  }


  public void registerSale(String clientId, int paymentDeadline, String productId, int quantity, List<Item> items){
    _store.registerSale(clientId, paymentDeadline, productId, quantity, items);
  }

  public Transaction getTransaction(int id) throws UnknownTransactionKeyException{
    return _store.getTransaction(id);
  }

  public List<Transaction> getSupplierTransactions(String supplierId) throws UnknownSupplierKeyException{
    return _store.getSupplierTransactions(supplierId);
  }

  public List<Transaction> getClientTransactions(String clientId) throws UnknownClientKeyException{
    return _store.getClientTransactions(clientId);
  }

  public void payTransaction(int id) throws UnknownTransactionKeyException{
    _store.payTransaction(id);
  }

  public List<Transaction> getPaidClientTransactions(String clientId) throws UnknownClientKeyException{
    return _store.getPaidClientTransactions(clientId);
  }

  public int getCurrentDate(){
    return _store.getDate();
  }

  public int advanceDay(int numberOfDays) throws InvalidDateException {
    return _store.advanceDay(numberOfDays);
  }

  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public void save() throws IOException, MissingFileAssociationException {
    if (_savefile == null)
      throw new MissingFileAssociationException();
    try (ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(_savefile))) {
      obOut.writeObject(_store);
    }
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void saveAs(String filename) throws IOException {
    try (ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(filename))) {
      obOut.writeObject(_store);
      _savefile = filename;
    }
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   */
  public void load(String filename) throws IOException, ClassNotFoundException, FileNotFoundException {
    try (ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(filename))) {
      _store = (Store) obIn.readObject();
      _savefile = filename;
    }
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException {
    try {
      _store.importFile(textfile);
    } catch (IOException | BadEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(textfile);
    }
  }

}
