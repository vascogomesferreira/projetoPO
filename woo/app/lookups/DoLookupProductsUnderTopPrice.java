package woo.app.lookups;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Product;

/**
 * Lookup products cheaper than a given price.
 */
public class DoLookupProductsUnderTopPrice extends Command<StoreManager> {

  private Input<Integer> _priceLimit;

  public DoLookupProductsUnderTopPrice(StoreManager storefront) {
    super(Label.PRODUCTS_UNDER_PRICE, storefront);
    _priceLimit = _form.addIntegerInput(Message.requestPriceLimit());
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
  }
}
