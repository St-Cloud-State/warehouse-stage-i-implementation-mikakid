public class WishlistTest {
    public static void main(String[] args) {
        // Create a catalog and some products
        Catalog catalog = Catalog.instance();
        Product p1 = new Product("Laptop", 10, "P001", 1500.0);
        Product p2 = new Product("Phone", 20, "P002", 800.0);
        catalog.addProduct(p1);
        catalog.addProduct(p2);

        // Create a wishlist for a client
        Wishlist wishlist = new Wishlist("C001");

        // Add products to the wishlist
        wishlist.addProductToWishlist(p1, 1);
        wishlist.addProductToWishlist(p2, 2);

        // Display wishlist
        wishlist.displayWishlist(catalog);
    }
}
