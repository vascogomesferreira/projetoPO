package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import java.io.IOException;
import woo.app.exception.FileOpenFailedException;
import woo.core.exception.UnavailableFileException;

/**
 * Open existing saved state.
 */
public class DoOpen extends Command<StoreManager> {

  private Input<String> _filename;

  /** @param receiver */
  public DoOpen(StoreManager receiver) {
    super(Label.OPEN, receiver);
    _filename = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException{
    _form.parse();
    try {
      _receiver.load(_filename.value());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }
}
