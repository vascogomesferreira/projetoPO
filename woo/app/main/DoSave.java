package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
import java.io.IOException;
import woo.core.exception.MissingFileAssociationException;

/**
 * Save current state to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<StoreManager> {

  private Input<String> _filename;

  /** @param receiver */
  public DoSave(StoreManager receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try {
      _receiver.save();
    } catch (MissingFileAssociationException exc1) {
      _form.parse();
      try {
        _receiver.saveAs(_filename.value());
      } catch (IOException exc2) {
        exc2.printStackTrace();
      }
    } catch (IOException exc3) {
      exc3.printStackTrace();
    }
  }
}
