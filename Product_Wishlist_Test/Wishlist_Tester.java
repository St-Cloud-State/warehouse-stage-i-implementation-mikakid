import java.util.*;

public class Wishlist_Tester {
    public static void main(String[] args) {

        // Create products
        Product product1 = new Product("Laptop", 10, "001", 900);
        Product product2 = new Product("Smartphone", 15, "002", 500);
        Product product3 = new Product("Headphones", 5, "003", 100);
        Product product4 = new Product("Tablet", 20, "004", 300);

        // Create first client and their wishlist
        Client client1 = new Client("John Deer", "123 Junction St", "123-4567");

        System.out.println("Adding products to John's wishlist...");
        client1.addProductToWishlist(product1, 2);
        client1.addProductToWishlist(product2, 1);
        client1.addProductToWishlist(product3, 3);

        // Try adding an existing product to the wishlist (should update the quantity)
        System.out.println("\nAdding one Laptop on top of John's 2 laptops (Should total 3 laptops)");
        client1.addProductToWishlist(product1, 1);

        // Display John's wishlist
        System.out.println("\nDisplaying John's wishlist:");
        client1.displayWishlist();

        // Create second client and their wishlist
        Client client2 = new Client("Jane Deer", "123 Oak St", "987-6543");

        System.out.println("\nAdding products to Jane's wishlist (Should be 2 Headphones and 1 Tablet)");
        client2.addProductToWishlist(product3, 2);
        client2.addProductToWishlist(product4, 1);

        // Display Jane's wishlist
        System.out.println("\nDisplaying Jane's wishlist:");
        client2.displayWishlist();
    }
}
