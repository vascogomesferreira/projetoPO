package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
import woo.core.Item;

import java.util.List;
import java.util.ArrayList;

import woo.app.exception.UnknownTransactionKeyException;

import woo.core.Transaction;
/**
 * Show specific transaction.
 */
public class DoShowTransaction extends Command<StoreManager> {

  private Input<Integer> _transactionId;
  private Transaction _transaction;
  private List<Item> _items;

  public DoShowTransaction(StoreManager receiver) {
    super(Label.SHOW_TRANSACTION, receiver);
    _transactionId = _form.addIntegerInput(Message.requestTransactionKey());

  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _items = _receiver.getTransaction(_transactionId.value()).getItems();
      _display.addLine(_receiver.getTransaction(_transactionId.value()).toString());

      if (_items.size() > 0){
        for(Item item: _items){
          _display.addLine(item.toString());
        }
      }
      _display.display();
    } catch(UnknownTransactionKeyException utke) {
      throw new UnknownTransactionKeyException(_transactionId.value());
    }
  }
}
