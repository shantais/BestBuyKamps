
/*
pola klasy ShoppingCart:

cartID : unikalny numer koszyka generowany w momencie dodania produktu do koszyka (long)

currentUser: login zalogowanego użytkownika , pusty w przypadku użytkownika niezalogowanego(String) +

shoppingList : lista produktów (ArrayList) +

cartStatus : status koszyka(String lub enum)

totalPrice : suma całkowita (double)

totalPriceAfterDiscount : cena po zniżkach(double)

discount: zniżka/voucher promocyjny(double)

metody:

addToCart - dodanie produktu do koszyka (zwraca boolean - true jak został dodany do koszyka)

removeFromCart : usunięcie produktu z koszyka ( zwraca Product - produkt usunięty z koszyka)

addDiscount : dodanie zniżki (void)




 */

//getProducts zwraca array list produktów

import user.User;

import java.util.ArrayList;

public class ShoppingCart {
    private long cartID;
    ArrayList<Product> shoppingList = new ArrayList<>();
    private double discount = 0.00;
    private double totalPriceAfterDiscount = 0;
    private double totalPrice = 0;
    private User user;

    private StatusOrder status;

    public ShoppingCart() {
        this.cartID = generateCartID();
        status = StatusOrder.CREATED;
    }

    public ShoppingCart(User user) {
        this.cartID = generateCartID();
        this.user = user;
        status = StatusOrder.CREATED;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public long getCartID() {
        return cartID;
    }

    public ArrayList<Product> getProducts() {
        return shoppingList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalPriceAfterDiscount() {
        totalPriceAfterDiscount = totalPrice - (totalPrice * (discount / 100));
        return totalPriceAfterDiscount;
    }

    public void addDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }


    public boolean addToCart(Product product) {
        shoppingList.add(product);
        totalPrice += product.getPrice();
        return shoppingList.contains(product);
    }

    public void removeFromCart(Product product) {
        shoppingList.remove(product);
        totalPrice -= product.getPrice();
    }


    private long generateCartID() {
        // Generowanie losowej 10-cyfrowej liczby
        return 1000000000L + (long) (Math.random() * (9999999999L - 1000000000L + 1));
    }

    public void setCartStatus(StatusOrder newStatus) {
        this.status = newStatus;
    }

    public StatusOrder getCartStatus() {
        return status;
    }

    @Override
    public String toString() {
        System.out.println("Numer koszyka : " + cartID);
        // System.out.println("Przypisany użytkownik: "+ user.getUsername);
        System.out.println("Produkty w koszyku: ");

        for (Product product : shoppingList) {
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println("--------------------");
        }
        System.out.println("Sumaryczna cena: " + getTotalPrice());

        if (discount != 0) {
            System.out.println("Brak naliczonych zniżek");
        } else {
            System.out.println("Naliczona zniżka : " + discount + " %");
            System.out.println("Sumaryczna cena ze zniżką : " + getTotalPriceAfterDiscount());
        }

        return "";
    }
}




