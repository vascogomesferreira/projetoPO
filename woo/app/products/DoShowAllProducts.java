package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Product;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Show all products.
 */
public class DoShowAllProducts extends Command<StoreManager> {

  public DoShowAllProducts(StoreManager receiver) {
    super(Label.SHOW_ALL_PRODUCTS, receiver);
  }

  @Override
  public final void execute() throws DialogException {
    List<Product> products = _receiver.getAllProducts();

    for (Product product: products){
      _display.addLine(product.toString());
    }
    _display.display();
  }
}
