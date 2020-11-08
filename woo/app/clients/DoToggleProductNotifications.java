package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Product;
import woo.core.Notification;
import woo.core.Client;

/**
 * Toggle product-related notifications.
 */
public class DoToggleProductNotifications extends Command<StoreManager> {

    private Input<String> _clientId;
    private Input<String> _productId;

  public DoToggleProductNotifications(StoreManager storefront) {
    super(Label.TOGGLE_PRODUCT_NOTIFICATIONS, storefront);
    _clientId = _form.addStringInput(Message.requestClientKey());
    _productId = _form.addStringInput(Message.requestProductKey());
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
  }

}
