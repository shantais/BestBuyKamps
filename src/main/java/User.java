import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class User {
    private final Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
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

    public Path getPath() {
        return path;
    }

    public Boolean isLoggedStatus() {
        return loggedStatus;
    }

    public void setLoggedStatus(Boolean loggedStatus) {
        this.loggedStatus = loggedStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addFavouriteProduct(Product product) {
        this.favouriteProducts.add(product);
        //TODO: add to file
    }

    public List<Product> getFavouriteProducts() {
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserSavedData.txt");
        return favouriteProducts;
    }

    //TODO: *
    public void setSavedCart(ShoppingCart savedCart) {
        this.savedCart = savedCart;
    }

    public ShoppingCart getSavedCart() {
        return savedCart;
    }

    public void setAllUserData(String logInData) {
        String userData = GeneralMethods.getFromFile(getPath(), logInData);

        List<String> userDataList = new LinkedList<>(List.of(userData.split("\\|")));
        List<String> formStrings = new LinkedList<>(List.of("username=", "password=", "name=", "surname=", "email=", "street=",
                "houseNumber=", "postalCode=", "city=", "phoneNumber="));
        List<String> userGetterData = new LinkedList<>();
        for (String formValue : formStrings){
            for (String userValue : userDataList){
                if (userValue.contains(formValue)){
                    userGetterData.add(userValue.split(formValue)[1]);
//                    System.out.println(userValue.split(formValue)[1]);
                }
            }
        }
        setName(userGetterData.get(3));
        setSurname(userGetterData.get(5));
        setEmail(userGetterData.get(6));
        setStreet(userGetterData.get(7));
        setHouseNumber(userGetterData.get(8));
        setPostalCode(userGetterData.get(9));
        setCity(userGetterData.get(10));
        setPhoneNumber(userGetterData.get(11));
    }


}
