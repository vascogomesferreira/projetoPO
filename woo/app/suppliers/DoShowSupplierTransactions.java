package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.app.exception.UnknownSupplierKeyException;

import woo.core.Transaction;

import java.util.List;
import java.util.ArrayList;


/**
 * Show all transactions for specific supplier.
 */
public class DoShowSupplierTransactions extends Command<StoreManager> {

  private Input<String> _supplierId;

  public DoShowSupplierTransactions(StoreManager receiver) {
    super(Label.SHOW_SUPPLIER_TRANSACTIONS, receiver);
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      List<Transaction> transactions = _receiver.getSupplierTransactions(_supplierId.value());

      for (Transaction transaction: transactions){
        _display.addLine(transaction.toString());
      }
      _display.display();
    } catch (UnknownSupplierKeyException uske) {
      throw new UnknownSupplierKeyException(_supplierId.value());
    }
  }
}
