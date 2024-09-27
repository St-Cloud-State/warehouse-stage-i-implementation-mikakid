import java.util.*;
import java.lang.*;
import java.io.*;
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private int stock;
  private String id;
  private double price;

  public Product(String name, double price, int stock, String id){
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public double getPrice(){
    return price;
  }  

  public String getID() {
    return id;
  }
  public int getStock() {
    return stock;
  }

  public String toString() {
    return "Name: " + name + "Price: " + price + "Stock: " + stock + " id: " + id;
}

}