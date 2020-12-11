package woo.app.transactions;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;
import woo.core.StoreManager;
import woo.core.Item;

import java.util.List;
import java.util.ArrayList;

import woo.app.exception.UnknownSupplierKeyException;
import woo.app.exception.UnknownProductKeyException;
import woo.app.exception.UnauthorizedSupplierException;
import java.lang.NullPointerException;
import java.io.IOException;

/**
 * Register order.
 */
public class DoRegisterOrderTransaction extends Command<StoreManager> {

  private Input<String> _supplierId;
  private Input<String> _productId;
  private Input<Integer> _quantity;
  private Input<Boolean> _more;
  private Form _form2;

  public DoRegisterOrderTransaction(StoreManager receiver) {
    super(Label.REGISTER_ORDER_TRANSACTION, receiver);
    _form2 = new Form();
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
    _productId = _form2.addStringInput(Message.requestProductKey());
    _quantity = _form2.addIntegerInput(Message.requestAmount());
    _more = _form2.addBooleanInput(Message.requestMore());
  }

  @Override
  public final void execute() throws DialogException {
    List<Item> _items = new ArrayList<Item>();
    List<String> _productsIds = new ArrayList<String>();
    List<Integer> _quantities = new ArrayList<Integer>();

    _form.parse();
    while(true){
      try {
        _form2.parse();
        _productsIds.add(_productId.value());
        if (_quantity.value().intValue() > 0){
          _quantities.add(_quantity.value().intValue());
        }
        else{
          _quantities.add(0);
        }
        if (!(_more.value().equals(true))){
          _items = _receiver.registerItems(_productsIds, _quantities);
          _receiver.registerOrder(_supplierId.value(), _items);
          break;
        }
      } catch (UnknownSupplierKeyException uske) {
        throw new UnknownSupplierKeyException(_supplierId.value());
      } catch (UnknownProductKeyException upke) {
        throw new UnknownProductKeyException(_productId.value());
      } catch (UnauthorizedSupplierException use) {
        throw new UnauthorizedSupplierException(_supplierId.value());
      } catch(IOException | NullPointerException e){
        throw new UnknownProductKeyException(_productId.value());
      }
    }
  }
}
