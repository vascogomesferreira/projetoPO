package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.app.exception.UnknownProductKeyException;


import woo.core.Product;

/**
 * Change product price.
 */
public class DoChangePrice extends Command<StoreManager> {

  private Input<String> _productId;
  private Input<Integer> _newPrice;

  public DoChangePrice(StoreManager receiver) {
    super(Label.CHANGE_PRICE, receiver);
    _productId = _form.addStringInput(Message.requestProductKey());
    _newPrice = _form.addIntegerInput(Message.requestPrice());
  }

  /*TODO: EXCEPTIONS*/
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    _receiver.changeProductPrice(_productId.value(), _newPrice.value());
  }
}
