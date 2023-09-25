import java.util.Scanner;

public class FrontSite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w sklepie BestBuy Kamps");
        System.out.println("dostępne opcje dla użytkownika niezalogowanego");
        System.out.println("1. Logowanie | 2. Przejdź do produktów | 3. Przejdź do koszyka |  4.Newsletter");


        Product product1 = new Product("telefon","elektronika",2000.00,"najlepszy telefon","ekran i reszta bajerów");
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addToCart(product1);
        cart1.addDiscount(20.00);
        System.out.println(cart1.getTotalPrice());
        System.out.println(cart1.getTotalPriceAfterDiscount());

        //cart1.toString();

    }



}
