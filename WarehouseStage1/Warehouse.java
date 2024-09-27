import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private ClientList clientList;   // Stores clients
    private Catalog catalog;         // Stores products

    private static Warehouse warehouse;

    private Warehouse() {
        clientList = ClientList.instance();
        catalog = Catalog.instance();
    }

    public static Warehouse instance() {
        if (warehouse == null) {
            ClientIdServer.instance();
            return (warehouse = new Warehouse());
        } else {
            return warehouse;
        }
    }

    // Add a new client to the system
    public Client addClient(String name, String address, String phone) {
        Client client = new Client(name, address, phone);
        if (clientList.insertClient(client)) {
            return client;
        }
        return null;
    }

    // Get the list of clients
    public List<Client> getClients() {
        return clientList.getClients();
    }

    // Add a new product to the catalog
    public boolean addProduct(String name, int stock, String id, double price) {
        Product product = new Product(name, stock, id, price);
        return catalog.addProduct(product);
    }

    // Add a product to a client's wishlist
    public boolean addProductToWishlist(String clientId, String productId, int quantity) {
        Client client = clientList.search(clientId);
        if (client != null) {
            Product product = findProduct(productId);
            if (product != null) {
                return client.addProductToWishlist(product, quantity);  // Use Client's wishlist method
            }
        }
        return false;
    }

    // Find a product in the catalog by its ID
    public Product findProduct(String productId) {
        Iterator<Product> products = catalog.getProducts();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getID().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Retrieve warehouse from file
    public static Warehouse retrieve() {
        try {
            FileInputStream file = new FileInputStream("WarehouseData");
            ObjectInputStream input = new ObjectInputStream(file);
            warehouse = (Warehouse) input.readObject();
            ClientIdServer.retrieve(input);
            return warehouse;

        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }

    // Save warehouse to file
    public static boolean save() {
        try {
            FileOutputStream file = new FileOutputStream("WarehouseData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(warehouse);
            output.writeObject(ClientIdServer.instance());
            return true;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    // Serialization support
    private void writeObject(java.io.ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(warehouse);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void readObject(java.io.ObjectInputStream input) {
        try {
            input.defaultReadObject();
            if (warehouse == null) {
                warehouse = (Warehouse) input.readObject();
            } else {
                input.readObject();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
