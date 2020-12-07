package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.app.exception.InvalidDateException;
/**
 * Advance current date.
 */
public class DoAdvanceDate extends Command<StoreManager> {

  private Input<Integer> _numberOfDays;

  public DoAdvanceDate(StoreManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    _numberOfDays = _form.addIntegerInput(Message.requestDaysToAdvance());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
     try {
      _receiver.advanceDay(_numberOfDays.value());
    } catch (InvalidDateException ide) {
      throw new InvalidDateException(_numberOfDays.value());
    }
  }
}
