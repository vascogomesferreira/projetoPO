package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;
//FIXME import other classes

/**
 * Register new client.
 */
public class DoRegisterClient extends Command<StoreManager> {

  //FIXME add input fields

  public DoRegisterClient(StoreManager storefront) {
    super(Label.REGISTER_CLIENT, storefront);
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
  }

}
