import java.util.*;
import java.io.*;

public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Product, Integer> wishlistItems;

    public Wishlist() {
        wishlistItems = new HashMap<>();
    }

    public boolean addProduct(Product product, int quantity) {
        wishlistItems.put(product, wishlistItems.getOrDefault(product, 0) + quantity);
        return true;
    }

    public void displayWishlist() {
        if (wishlistItems.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } 
        else {
            for (Map.Entry<Product, Integer> entry : wishlistItems.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                double totalPrice = quantity * product.getPrice();
                System.out.println("Product Name: " + product.getName() + 
                                   " | ID: " + product.getID() + 
                                   " | Quantity: " + quantity + 
                                   " | Total Price: $" + totalPrice);
            }
        }
    }

    public Map<Product, Integer> getWishlistItems() {
        return wishlistItems;
    }

    public boolean isEmpty() {
        return wishlistItems.isEmpty();
    }
}
