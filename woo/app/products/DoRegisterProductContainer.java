package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import java.lang.IllegalArgumentException;

import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.UnknownServiceTypeException;
import woo.app.exception.UnknownServiceLevelException;

import woo.core.exception.UnknownCoreServiceType;

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

  // TODO
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerProductContainer(_id.value(), _supplierId.value(), _price.value().intValue(), _criticalValue.value().intValue(), 0 , _serviceType.value(), _serviceLevel.value());
      _display.display();
     } catch (DuplicateProductKeyException dpke) {
       throw new DuplicateProductKeyException(_id.value());
     } catch (UnknownSupplierKeyException uske) {
       throw new UnknownSupplierKeyException(_supplierId.value());
     } catch (UnknownCoreServiceType uste) {
       throw new UnknownServiceTypeException(_serviceType.value());
     } catch (IllegalArgumentException ucst) {
       throw new UnknownServiceLevelException(_serviceLevel.value());
     }
  }
}
