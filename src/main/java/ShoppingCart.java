
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

import user.User;

import java.util.ArrayList;

public class ShoppingCart {
    private long cartID;
    private User user;
    ArrayList<Product> shoppingList = new ArrayList<>();
    private String cartStatus;
    private double discount;
    private double totalPriceAfterDiscount = 0;
    private double totalPrice = 0;

    public ShoppingCart(User user, Product product) {
        this.cartID = generateCartID();
        this.cartStatus = "NEW";
        this.user=user;
        shoppingList.add(product);

    }

    public User getUser() {
        return user;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void addDiscount(double discount) {
        this.discount = discount;
    }


    public void addToCart(Product product) {
        shoppingList.add(product);
        totalPrice+=product.getPrice();
    }

    public void removeFromCart(Product product){
        shoppingList.remove(product);
        totalPrice-=product.getPrice();
    }


    private long generateCartID() {
        // Generowanie losowej 10-cyfrowej liczby
        return 1000000000L + (long) (Math.random() * (9999999999L - 1000000000L + 1));
    }

    public void setCartStatus(String newCartStatus) {
        this.cartStatus = cartStatus;
    }
}

