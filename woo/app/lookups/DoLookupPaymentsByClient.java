package woo.app.lookups;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
import woo.core.Transaction;
import woo.app.exception.UnknownClientKeyException;

import java.util.List;
import java.util.ArrayList;

/**
 * Lookup payments by given client.
 */
public class DoLookupPaymentsByClient extends Command<StoreManager> {

  private Input<String> _clientId;

  public DoLookupPaymentsByClient(StoreManager storefront) {
    super(Label.PAID_BY_CLIENT, storefront);
    _clientId = _form.addStringInput(Message.requestClientKey());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try{
      List<Transaction> transactions = _receiver.getPaidClientTransactions(_clientId.value());

      for (Transaction transaction: transactions){
        _display.addLine(transaction.toString());
      }
      _display.display();
    } catch (UnknownClientKeyException ucke) {
      throw new UnknownClientKeyException(_clientId.value());
    }

  }
}
