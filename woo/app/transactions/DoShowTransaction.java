package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.app.exception.UnknownTransactionKeyException;

import woo.core.Transaction;
/**
 * Show specific transaction.
 */
public class DoShowTransaction extends Command<StoreManager> {

  private Input<Integer> _transactionId;

  public DoShowTransaction(StoreManager receiver) {
    super(Label.SHOW_TRANSACTION, receiver);
    _transactionId = _form.addIntegerInput(Message.requestTransactionKey());

  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _display.popup(_receiver.getTransaction(_transactionId.value()));
    } catch(UnknownTransactionKeyException utke) {
      throw new UnknownTransactionKeyException(_transactionId.value());
    }
  }
}
