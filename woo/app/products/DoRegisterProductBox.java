package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import java.lang.IllegalArgumentException;

import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.UnknownServiceTypeException;

/**
 * Register box.
 */
public class DoRegisterProductBox extends Command<StoreManager> {

  private Input<String> _id;
  private Input<Integer> _price;
  private Input<Integer> _criticalValue;
  private Input<String> _supplierId;
  private Input<String> _serviceType;

  public DoRegisterProductBox(StoreManager receiver) {
    super(Label.REGISTER_BOX, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _price = _form.addIntegerInput(Message.requestPrice());
    _criticalValue = _form.addIntegerInput(Message.requestStockCriticalValue());
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
    _serviceType = _form.addStringInput(Message.requestServiceType());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
     try {
       _receiver.registerProductBox(_id.value(), _supplierId.value(), _price.value().intValue(), _criticalValue.value().intValue(), 0, _serviceType.value());
       _display.display();
     } catch (DuplicateProductKeyException dpke) {
       throw new DuplicateProductKeyException(_id.value());
     } catch (UnknownSupplierKeyException uske) {
       throw new UnknownSupplierKeyException(_supplierId.value());
     } catch (IllegalArgumentException iae) {
       throw new UnknownServiceTypeException(_serviceType.value());
     }
  }
}
