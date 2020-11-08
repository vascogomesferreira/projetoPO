package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Client;

/**
 * Show client.
 */
public class DoShowClient extends Command<StoreManager> {

  private Input<String> _id;

  public DoShowClient(StoreManager storefront) {
    super(Label.SHOW_CLIENT, storefront);
    _id = _form.addStringInput(Message.requestClientKey());
  }

  @Override
  public void execute() throws DialogException {
      _form.parse();
      _display.popup(_receiver.getClient(_id.value()));
  }

}
