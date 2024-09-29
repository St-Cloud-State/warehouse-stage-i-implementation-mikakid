import java.util.*;

public class Wishlist_Tester {
    public static void main(String[] args) {

        Product product1 = new Product("Laptop", 10, "001", 900);
        Product product2 = new Product("Smartphone", 15, "002", 500);
        Product product3 = new Product("Headphones", 5, "003", 100);

        Client client = new Client("John Deer", "123 Junction St", "123-4567");

        System.out.println("Adding products to John's wishlist...");
        client.addProductToWishlist(product1, 2);
        client.addProductToWishlist(product2, 1);
        client.addProductToWishlist(product3, 3);

        // Try adding an existing product to the wishlist (should update the quantity)
        System.out.println("\nAdding one Laptop on top of John's 2 laptops (Should total 3 laptops)");
        client.addProductToWishlist(product1, 1);

        // Display the wishlist to verify that products were added and quantities were updated
        System.out.println("\nDisplaying John's wishlist:");
        client.displayWishlist();
    }
}
