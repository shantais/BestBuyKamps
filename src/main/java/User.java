import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class User {
    private Boolean loggedStatus = false;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String phoneNumber;
    List <Product> favouriteProducts;
    ShoppingCart savedCart;

    public boolean isLogged() {
        return loggedStatus;
    }

}
