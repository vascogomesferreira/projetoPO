package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
import woo.core.Client;
import woo.core.Transaction;
import woo.app.exception.UnknownClientKeyException;

import java.util.List;
import java.util.ArrayList;

/**
 * Show all transactions for a specific client.
 */
public class DoShowClientTransactions extends Command<StoreManager> {

    private Input<String> _clientId;

  public DoShowClientTransactions(StoreManager storefront) {
    super(Label.SHOW_CLIENT_TRANSACTIONS, storefront);
    _clientId = _form.addStringInput(Message.requestClientKey());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      List<Transaction> transactions = _receiver.getClientTransactions(_clientId.value());

      for (Transaction transaction: transactions){
        _display.addLine(transaction.toString());
      }
      _display.display();
    } catch (UnknownClientKeyException ucke) {
      throw new UnknownClientKeyException(_clientId.value());
    }
  }
}
