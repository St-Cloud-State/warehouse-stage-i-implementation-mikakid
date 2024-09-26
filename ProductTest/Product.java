import java.util.*;
import java.lang.*;
import java.io.*;
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private int stock;
  private String id;

  public Product(String name, int stock, String id){
    this.name = name;
    this.stock = stock;
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public String getID() {
    return id;
  }
  public int getStock() {
    return stock;
  }

  public String toString() {
    return "Name: " + name + " stock: " + stock + " id: " + id;
}

}