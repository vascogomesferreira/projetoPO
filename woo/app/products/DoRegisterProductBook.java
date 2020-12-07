package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.app.exception.DuplicateProductKeyException;
import woo.app.exception.UnknownSupplierKeyException;
import woo.core.Book;

/**
 * Register book.
 */
public class DoRegisterProductBook extends Command<StoreManager> {

  private Input<String> _id;
  private Input<String> _title;
  private Input<String> _author;
  private Input<String> _isbn;
  private Input<Integer> _price;
  private Input<Integer> _criticalValue;
  private Input<String> _supplierId;

  public DoRegisterProductBook(StoreManager receiver) {
    super(Label.REGISTER_BOOK, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _title = _form.addStringInput(Message.requestBookTitle());
    _author = _form.addStringInput(Message.requestBookAuthor());
    _isbn = _form.addStringInput(Message.requestISBN());
    _price = _form.addIntegerInput(Message.requestPrice());
    _criticalValue = _form.addIntegerInput(Message.requestStockCriticalValue());
    _supplierId = _form.addStringInput(Message.requestSupplierKey());
  }

  // TODO
  @Override
  public final void execute() throws DialogException {
    _form.parse();
     try {
      _receiver.registerProductBook(_id.value(), _supplierId.value(), _price.value().intValue(), _criticalValue.value().intValue(), 0, _title.value(), _author.value(), _isbn.value());
      _display.display();
     } catch (DuplicateProductKeyException dpke) {
       throw new DuplicateProductKeyException(_id.value());
     } catch (UnknownSupplierKeyException uske) {
       throw new UnknownSupplierKeyException(_supplierId.value());
     }
  }
}
