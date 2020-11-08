package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.core.StoreManager;

import woo.core.Client;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Show all clients.
 */
public class DoShowAllClients extends Command<StoreManager> {

  public DoShowAllClients(StoreManager storefront) {
    super(Label.SHOW_ALL_CLIENTS, storefront);

  }

  @Override
  public void execute() throws DialogException {
    List<Client> clients = _receiver.getAllClients();

    for (Client client: clients){
      _display.addLine(client.toString());
    }
    _display.display();
  }
}
