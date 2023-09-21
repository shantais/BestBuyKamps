/*      dodaje dane z koszyka ✔️
        sprawdza czy zalogowany ✔️
        jeśli niezalogowany to prosi o dane ✔️
        jeśli zalogowany to pobiera dane z konta i prosi o uzupełnienie brakujących/potwierdzenie istniejących
        wyliczenie czasu realizacji zamówienia
        wybór formy płatności i dostawy
        status zamówienia (złożone, przyjęte, wysłane do doręczenia, niedostarczone, dostarczone)
        */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order extends ShoppingCart {
    private User user;
    private PaymentMethod selectedPaymentMethod;
    private GuestUser guestUser;
    private UserLogged userLogged;
    private List<Product> productOrder = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public Order(ShoppingCart shoppingCart, User user) {
        this.productOrder.addAll(shoppingCart.getProducts());
    }


    public Order(ShoppingCart shoppingCart, User user) {
            if (!user.isLogged()) {
                throw new IllegalStateException("The User is not logged in");
            }
            this.productOrder.addAll(shoppingCart.getProducts());

            this.user = user;
        }
        public boolean userIsLoggedOrNot () {
            if (userLogged != null) {
                return true;
            } else {
                System.out.println("Please give me your name and surname:");
                String nameAndSurname = scanner.nextLine();
                guestUser = new GuestUser(nameAndSurname);
            }
            return false;
        }
        public void showOrder () {
            for (Product product : productOrder) {
                System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " +
                        product.getCategory() + " " + product.getDescription() + " " + product.getSpecification());
            }
        }
        public void choosePaymentMethod () {
            System.out.println("Choose payment method:");
            List<PaymentMethod> methodList = Arrays.asList(PaymentMethod.values()); // przekształcam wartości klasy enum w listę ( klasy enum maja wbudowana metode values )
            for (PaymentMethod method : methodList) {
                System.out.println((methodList.indexOf(method) + 1) + ". " + method);
            }

            int choice;  // ten fragment kodu służy do uzyskiwania od użytkownika wyboru metody płatności, a następnie do przechowywania tego wyboru.
            do {
                System.out.print("Enter choice (1-" + methods.length + "): ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > methods.length);
            selectedPaymentMethod = methods[choice - 1];  // zalozylem ze utworzymy klase paymentMethod abysmy mogli dokladnie wskazac do jakiej platnosci uzytkownik sie odnosi
            System.out.println("Selected payment method: " + selectedPaymentMethod);
        }
    }
