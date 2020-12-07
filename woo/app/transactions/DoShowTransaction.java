package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

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
    //FIXME implememt command
  }
}
