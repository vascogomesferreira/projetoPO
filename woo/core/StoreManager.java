package woo.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import woo.core.exception.UnavailableFileException;
import woo.core.exception.MissingFileAssociationException;
import woo.core.exception.ImportFileException;
import woo.core.exception.BadEntryException;
import woo.app.exception.UnknownClientKeyException;
import woo.app.exception.InvalidDateException;
import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.InvalidDateException;
import woo.app.exception.DuplicateClientKeyException;
import woo.app.exception.DuplicateSupplierKeyException;

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

  public void registerSupplier(String id, String name, String address) throws DuplicateSupplierKeyException {
    _store.registerSupplier(id, name, address);
  }

  public void addSupplier(Supplier supplier) {
    _store.addSupplier(supplier);
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

  public void registerProductBox(String id, String supplierId, int price, int crit, int q, ServiceType s) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _store.registerProductBox(id, supplierId, price, crit, q, s);
  }

  public void registerProductContainer(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level) throws DuplicateProductKeyException, UnknownSupplierKeyException {
    _store.registerProductContainer(id, supplierId, price, crit, q, s, level);
  }

  public void addProduct(Product product){
    _store.addProduct(product);
  }

  public List<Product> getAllProducts(){
    return _store.getAllProducts();
  }

  public void changeProductPrice(String productId, int newPrice){
    _store.changeProductPrice(productId, newPrice);
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
