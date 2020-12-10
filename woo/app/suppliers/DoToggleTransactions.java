package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Transaction;
import woo.core.Supplier;

import woo.app.exception.UnknownSupplierKeyException;

/**
 * Enable/disable supplier transactions.
 */
public class DoToggleTransactions extends Command<StoreManager> {

  private Input<String> _supplierId;

  public DoToggleTransactions(StoreManager receiver) {
    super(Label.TOGGLE_TRANSACTIONS, receiver);
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      _display.popup(_receiver.toggleSupplierActive(_supplierId.value()));
    } catch (UnknownSupplierKeyException uske) {
      throw new UnknownSupplierKeyException(_supplierId.value());
    }
  }
}
