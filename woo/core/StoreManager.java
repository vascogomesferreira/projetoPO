package woo.core;

import java.io.IOException;
import java.io.FileNotFoundException;

import woo.core.exception.UnavailableFileException;
import woo.core.exception.MissingFileAssociationException;
import woo.core.exception.ImportFileException;
import woo.core.exception.BadEntryException;

import java.util.List;
import java.util.ArrayList;

/**
 * StoreManager: façade for the core classes.
 */
public class StoreManager {

  /** Current filename. */
  private String _filename = "";

  /** The actual store. */
  private Store _store = new Store();

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

  public void advanceDay(int numberOfDays){
    _store.advanceDay(numberOfDays);
  }

  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException {
    //FIXME implement serialization method
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    _filename = filename;
    save();
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   */
  public void load(String filename) throws UnavailableFileException {
    //FIXME implement serialization method
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
