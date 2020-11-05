package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;
import woo.core.StoreManager;

/**
 * Open menu for client management.
 */
public class DoOpenMenuClients extends Command<StoreManager> {

  public DoOpenMenuClients(StoreManager receiver) {
    super(Label.OPEN_MENU_CLIENTS, receiver);
  }

  @Override
  public final void execute() {
    Menu menu = new woo.app.clients.Menu(_receiver);
    menu.open();
  }
}
