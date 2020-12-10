package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Transaction;
import woo.core.Product;
import woo.core.Supplier;

/**
 * Register order.
 */
public class DoRegisterOrderTransaction extends Command<StoreManager> {

  private Input<String> _supplierId;
  private Input<String> _productId;
  private Input<Integer> _quantity;
  private Input<Boolean> _more;

  public DoRegisterOrderTransaction(StoreManager receiver) {
    super(Label.REGISTER_ORDER_TRANSACTION, receiver);
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
    _productId = _form.addStringInput(Message.requestProductKey());
    _quantity = _form.addIntegerInput(Message.requestAmount());
    _more = _form.addBooleanInput(Message.requestMore());
  }

  // TODO : EXCEPTIONS
  @Override
  public final void execute() throws DialogException {

    // try {
    while(true){
      _form.parse();
      _receiver.registerOrder(_supplierId.value(), _productId.value(), _quantity.value().intValue());
      if (!_more.value().equals(true)){
        break;
      }
    }
  }
}
