package woo.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

abstract public class Transaction implements Serializable {

  private int _cost;
  private int _id;
  private int _date;
}
