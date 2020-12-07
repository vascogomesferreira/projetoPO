package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Supplier;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Show all suppliers.
 */
public class DoShowSuppliers extends Command<StoreManager> {

  public DoShowSuppliers(StoreManager receiver) {
    super(Label.SHOW_ALL_SUPPLIERS, receiver);
  }

  @Override
  public void execute() throws DialogException {
    List<Supplier> suppliers = _receiver.getAllSuppliers();

    for (Supplier supplier: suppliers){
      _display.addLine(supplier.toString());
    }
    _display.display();
  }
}
