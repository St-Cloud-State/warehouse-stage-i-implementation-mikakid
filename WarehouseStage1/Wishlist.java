import java.util.*;
import java.io.*;

public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Product, Integer> wishlistItems;

    public Wishlist() {
        wishlistItems = new HashMap<>();
    }

    // Add a product to the wishlist or update quantity if it already exists
    public boolean addProduct(Product product, int quantity) {
        wishlistItems.put(product, wishlistItems.getOrDefault(product, 0) + quantity);
        return true;
    }

    // Display the wishlist items with their quantities
    public void displayWishlist() {
        if (wishlistItems.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            for (Map.Entry<Product, Integer> entry : wishlistItems.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product + " | Quantity: " + quantity);
            }
        }
    }

    // Get all products and their quantities
    public Map<Product, Integer> getWishlistItems() {
        return wishlistItems;
    }

    public boolean isEmpty() {
        return wishlistItems.isEmpty();
    }
}
