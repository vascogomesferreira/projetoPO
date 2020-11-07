package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
//FIXME import other classes

/**
 * Register container.
 */
public class DoRegisterProductContainer extends Command<StoreManager> {

  private Input<String> _id;
  private Input<Integer> _price;
  private Input<Integer> _criticalValue;
  private Input<String> _supplierId;
  private Input<String> _serviceLevel;
  private Input<String> _serviceType;

  public DoRegisterProductContainer(StoreManager receiver) {
    super(Label.REGISTER_CONTAINER, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _price = _form.addIntegerInput(Message.requestPrice());
    _criticalValue = _form.addIntegerInput(Message.requestStockCriticalValue());
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
    _serviceType = _form.addStringInput(Message.requestServiceType());
    _serviceLevel = _form.addStringInput(Message.requestServiceLevel());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();

    // _display.add(Message.userRegistrationSuccessful(_receiver.registerUser(_name.value(), _mail.value())));
    _display.display();
  }
}
