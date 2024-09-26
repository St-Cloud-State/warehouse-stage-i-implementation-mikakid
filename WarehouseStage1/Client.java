import java.util.*;
import java.io.*;

public class Client implements Serializable {
    private String id;
    private String name;
    private String address;
    private static final String CLIENT_STRING = "C";
    private String phone;
    private static final long serialVersionUID = 1L;


    public Client (String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        id = CLIENT_STRING + ClientIdServer.instance().getId();

    }

    public String getName() { return name;}
    public String getPhone() { return phone;}
    public String getAddress() {return address;}
    public String getId() { return id; }

    public void setName(String newName) { name = newName; }

    public String toString(){
        String string = "Client Name: " + name + " Id: " + id + " Address: " + address + " Phone: " + phone;
        return string;
    }

}