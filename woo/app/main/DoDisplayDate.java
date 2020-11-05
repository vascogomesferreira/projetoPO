package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
//FIXME import other classes

/**
 * Show current date.
 */
public class DoDisplayDate extends Command<StoreManager> {

  //FIXME add input fields

  public DoDisplayDate(StoreManager receiver) {
    super(Label.SHOW_DATE, receiver);
  }

  @Override
  public final void execute() throws DialogException {
    _display.popup(Message.currentDate(_receiver.getCurrentDate()));
  }
}
