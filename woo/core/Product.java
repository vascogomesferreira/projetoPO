package woo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

abstract public class Product implements Serializable {

  private String _id;
  private String _supplierId;
  private int _price;
  private int _criticalValue;
  private int _currentQuantity;

  private Map<String, Client> _clients;

  protected Product(String id, String supplierId, int price, int crit, int q){
    _id = id;
    _supplierId = supplierId;
    _price = price;
    _criticalValue = crit;
    _currentQuantity = q;
    _clients = new HashMap<>();
  }

  public String getId(){
    return _id;
  }

  public String getSupplierId(){
    return _supplierId;
  }

  public int getPrice(){
    return _price;
  }

  public int getCriticalValue(){
    return _criticalValue;
  }

  public int getCurrentQuantity(){
    return _currentQuantity;
  }

  // public void setCurrentQuantity(int newQuantity, List<Client> clients){
  //  if (newQuantity > 0 && _currentQuantity == 0){
  //   NOTIFICAR CLIENTES COM NEW, VERIFICAR SE ESTAO INACTIVE PARA ESTE PRODUTO
  //   NOTIFICAR STORE
  //  }
  //   _currentQuantity = newQuantity;
  // }

  public void setPrice(int newPrice){
    // if (newPrice < _price) {
    //   NOTIFICAR TODOS OS CLIENTES COM BARGAIN, VERIFICAR SE ESTAO INACTIVE PARA ESTE PRODUTO
    //   NOTIFICAR STORE
    // }
    _price = newPrice;
  }

  @Override
  public abstract String toString();
}
