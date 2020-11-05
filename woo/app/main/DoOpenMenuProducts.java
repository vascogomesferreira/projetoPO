package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;
import woo.core.StoreManager;

/**
 * Open menu for product management.
 */
public class DoOpenMenuProducts extends Command<StoreManager> {

  public DoOpenMenuProducts(StoreManager receiver) {
    super(Label.OPEN_MENU_PRODUCTS, receiver);
  }

  @Override
  public final void execute() {
    Menu menu = new woo.app.products.Menu(_receiver);
    menu.open();
  }
}
