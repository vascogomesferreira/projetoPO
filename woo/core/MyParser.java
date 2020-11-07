package woo.core;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import woo.core.exception.BadEntryException;
// add here more imports if needed

public class MyParser {
  private Store _store;  // ou outra entidade

  MyParser(Store s) {
    _store = s;
  }

  void parseFile(String fileName) throws IOException, BadEntryException /* may have other exceptions */ {

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;

      while ((line = reader.readLine()) != null)
        parseLine(line);
    }
  }

  private void parseLine(String line) throws BadEntryException {
    String[] components = line.split("\\|");

    switch(components[0]) {
      case "SUPPLIER":
        parseSupplier(line, components);
        break;

      case "CLIENT":
        parseClient(line, components);
        break;

      case "BOX":
        parseBox(line, components);
        break;

      case "CONTAINER":
        parseContainer(line, components);
        break;

      case "BOOK":
        parseBook(line, components);
        break;

      default:
        throw new BadEntryException("Type of line not supported: " + line);
    }
  }

  // Format: SUPPLIER|id|nome|endereço
  private void parseSupplier(String line, String[] components)  throws BadEntryException {
    if (components.length != 4)
      throw new BadEntryException("Invalid number of fields in supplier description (4) " + line);

    String id = components[1];
    String name = components[2];
    String address = components[3];

    // _store.registerSupplier(id, name, address);
  }

  // Format: CLIENT|id|nome|endereço
  private void parseClient(String line, String[] components) throws BadEntryException {
    if (components.length != 4)
      throw new BadEntryException("Invalid number of fields (4) in client description: " + line);

      String id = components[1];
      String name = components[2];
      String address = components[3];

      // _store.registerClient(id, name, address);
  }

  // Format: BOX|id|tipo-de-serviço|id-fornecedor|preço|valor-crítico|exemplares
  private void parseBox(String line, String[] components) throws BadEntryException {
    if (components.length != 7)
      throw new BadEntryException("wrong number of fields in box description  (7) " + line);

    String id = components[1];
    ServiceType s = ServiceType.valueOf(components[2]);
    String sup = String.valueOf(components[3]);
    int price = Integer.parseInt(components[4]);
    int crit = Integer.parseInt(components[5]);
    int q = Integer.parseInt(components[6]);

    Box box = new Box(id, sup, price, crit, q , s);

    _store.addProduct(box);
  }

  // Format: BOOK|id|título|autor|isbn|id-fornecedor|preço|valor-crítico|exemplares
  private void parseBook(String line, String[] components) throws BadEntryException {
   if (components.length != 9)
      throw new BadEntryException("Invalid number of fields (9) in box description: " + line);

      String id = components[1];
      String title = components[2];
      String author = components[3];
      String isbn = components[4];
      String sup = String.valueOf(components[5]);
      int price = Integer.parseInt(components[6]);
      int crit = Integer.parseInt(components[7]);
      int q = Integer.parseInt(components[8]);

      Book book = new Book(id, sup, price, crit, q, title, author, isbn);

      _store.addProduct(book);
  }

  // Format: CONTAINER|id|tipo-de-serviço|nível-de-serviço|id-fornecedor|preço|valor-crítico|exemplares
  private void parseContainer(String line, String[] components) throws BadEntryException {
    if (components.length != 8)
      throw new BadEntryException("Invalid number of fields (8) in container description: " + line);

      String id = components[1];
      ServiceType s = ServiceType.valueOf(components[2]);
      ServiceLevel level = ServiceLevel.valueOf(components[3]);
      String sup = String.valueOf(components[4]);
      int price = Integer.parseInt(components[5]);
      int crit = Integer.parseInt(components[6]);
      int q = Integer.parseInt(components[7]);


      Container container = new Container(id, sup, price, crit, q , s, level);

      _store.addProduct(container);
  }
}
