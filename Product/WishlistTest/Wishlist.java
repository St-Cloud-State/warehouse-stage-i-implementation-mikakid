import java.io.*;
import java.util.*;

public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> wishlistItems; // Maps product ID to quantity
    private String clientId; // To associate with a specific client

    public Wishlist(String clientId) {
        this.clientId = clientId;
        this.wishlistItems = new HashMap<>();
    }

    // Add product to wishlist, update quantity if product already exists
    public boolean addProductToWishlist(Product product, int quantity) {
        if (wishlistItems.containsKey(product.getID())) {
            wishlistItems.put(product.getID(), wishlistItems.get(product.getID()) + quantity); // Update quantity
        } else {
            wishlistItems.put(product.getID(), quantity); // Add new product
        }
        return true;
    }

    // Get wishlist items
    public Map<String, Integer> getWishlistItems() {
        return wishlistItems;
    }

    // Display all items in the wishlist with quantities
    public void displayWishlist(Catalog catalog) {
        System.out.println("Wishlist for client ID: " + clientId);
        for (String productId : wishlistItems.keySet()) {
            Product product = findProductById(catalog, productId);
            if (product != null) {
                System.out.println(product.getName() + " (ID: " + productId + "), Quantity: " + wishlistItems.get(productId));
            } else {
                System.out.println("Product with ID " + productId + " not found.");
            }
        }
    }

    // Helper method to find a product by ID in the catalog
    private Product findProductById(Catalog catalog, String productId) {
        Iterator<Product> iterator = catalog.getProducts();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getID().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
