package woo.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import woo.core.exception.UnavailableFileException;
import woo.core.exception.MissingFileAssociationException;
import woo.core.exception.ImportFileException;
import woo.core.exception.BadEntryException;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;

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

  public void registerSupplier(String id, String name, String address) {
    _store.registerSupplier(id, name, address);
  }

  public List<Client> getAllClients() {
    return _store.getAllClients();
  }

  public Client getClient(String id) {
    return _store.getClient(id);
  }

  public void registerClient(String id, String name, String address) {
    _store.registerClient(id, name, address);
  }

  public void registerProductBook(String id, String supplierId, int price, int crit, int q, String title, String author, String isbn) {
    _store.registerProductBook(id, supplierId, price, crit, q, title, author, isbn);
  }

  public void registerProductBox(String id, String supplierId, int price, int crit, int q, ServiceType s) {
    _store.registerProductBox(id, supplierId, price, crit, q, s);
  }

  public void registerProductContainer(String id, String supplierId, int price, int crit, int q, ServiceType s, ServiceLevel level) {
    _store.registerProductContainer(id, supplierId, price, crit, q, s, level);
  }

  public void addProduct(Product product){
    _store.addProduct(product);
  }

  public List<Product> getAllProducts(){
      return _store.getAllProducts();
    }

  public int getCurrentDate(){
    return _store.getDate();
  }

  public int advanceDay(int numberOfDays){
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
  public void load(String filename) throws IOException, ClassNotFoundException {
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
