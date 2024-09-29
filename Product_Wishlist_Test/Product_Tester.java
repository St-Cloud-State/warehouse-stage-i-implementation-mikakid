public class Product_Tester {
    public static void main(String[] args) {

        Product product1 = new Product("Laptop", 10, "001", 900);
        Product product2 = new Product("Smartphone", 50, "002", 500);
        Product product3 = new Product("Headphones", 100, "003", 100);
        
        System.out.println("Product 1 Name: " + product1.getName());
        System.out.println("Product 2 Name: " + product2.getName());
        System.out.println("Product 3 Name: " + product3.getName());

        System.out.println("Product 1 ID: " + product1.getID());
        System.out.println("Product 2 ID: " + product2.getID());
        System.out.println("Product 3 ID: " + product3.getID());

        System.out.println("Product 1 Stock: " + product1.getStock());
        System.out.println("Product 2 Stock: " + product2.getStock());
        System.out.println("Product 3 Stock: " + product3.getStock());

        System.out.println("Product 1 Price: $" + product1.getPrice());
        System.out.println("Product 2 Price: $" + product2.getPrice());
        System.out.println("Product 3 Price: $" + product3.getPrice());

        System.out.println("\nProduct 1 Details: " + product1.toString());
        System.out.println("Product 2 Details: " + product2.toString());
        System.out.println("Product 3 Details: " + product3.toString());
    }
}
