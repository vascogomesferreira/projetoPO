package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import java.util.List;
import java.util.ArrayList;

import woo.core.Transaction;
import woo.core.Product;
import woo.core.Client;
import woo.core.Item;
/**
 * Register sale.
 */
public class DoRegisterSaleTransaction extends Command<StoreManager> {

  private Input<String> _clientId;
  private Input<Integer> _paymentDeadline;
  private Input<String> _productId;
  private Input<Integer> _quantity;

  public DoRegisterSaleTransaction(StoreManager receiver) {
    super(Label.REGISTER_SALE_TRANSACTION, receiver);
    _clientId = _form.addStringInput(Message.requestClientKey());
    _paymentDeadline = _form.addIntegerInput(Message.requestPaymentDeadline());
    _productId = _form.addStringInput(Message.requestProductKey());
    _quantity = _form.addIntegerInput(Message.requestAmount());

  }

  @Override
  public final void execute() throws DialogException {
    List<Item> _items = new ArrayList<Item>();

    _form.parse();
    
    _receiver.registerSale(_clientId.value(), _paymentDeadline.value().intValue(), _productId.value(), _quantity.value().intValue(), _items);
  }
}
