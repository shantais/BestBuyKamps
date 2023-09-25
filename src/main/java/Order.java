/*





        status zamówienia (złożone, przyjęte, wysłane do doręczenia, niedostarczone, dostarczone)
        */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order {
    private StatusOrder statusOrder;
    private User user;
    Delivery delivery;
    private ShoppingCart shoppingCart;
    private PaymentMethod selectedPaymentMethod;
    private List<Product> productOrder = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Order(){}

        public boolean userIsLoggedOrNot () {  // metoda sprawdzajaca czy uzytkownik jest zalogowany
            if (user.isLoggedStatus()) {    /// potrzebuje gettera w klasie User ktory poda mi wartosc true lub false metody loggedStatus
                return true;
            } else {
                System.out.println("Please give me your name:");
                String name = scanner.nextLine();
                System.out.println("Please give me your surname:");
                String surname = scanner.nextLine();
                User newUser = new User();
                user.setName(name);
                user.setSurname(surname);
            }
            return false;
        }
        public void showOrder () {   // metoda pokazujaca jak wyglada nasze obecne zamowienie
            for (Product product : productOrder) {
                System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " +
                        product.getCategory() + " " + product.getDescription() + " " + product.getSpecification());
            }
        }
        public void choosePaymentMethod () {           // wybor platnosci za zamowienie
            System.out.println("Choose payment method:");
            List<PaymentMethod> methodList = Arrays.asList(PaymentMethod.values()); // przekształcam wartości klasy enum w listę ( klasy enum maja wbudowana metode values )
            for (PaymentMethod method : methodList) {
                System.out.println((methodList.indexOf(method) + 1) + ". " + method);
            }

            int choice;  // ten fragment kodu służy do uzyskiwania od użytkownika wyboru metody płatności, a następnie do przechowywania tego wyboru.
            do {
                System.out.print("Enter choice (1-" + methodList.size() + "): ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > methodList.size());
            selectedPaymentMethod = methodList.get(choice - 1);  // zalozylem ze utworzymy klase paymentMethod abysmy mogli dokladnie wskazac do jakiej platnosci uzytkownik sie odnosi
            System.out.println("Selected payment method: " + selectedPaymentMethod);
        }
        public void chooseDeliveryMethod(){ // tworze metode bardzo podobnie jak wybor platnosci
            System.out.println("Choose payment method:");
            List<Delivery> methodDelivery = Arrays.asList(Delivery.values());
            for(Delivery delivery : methodDelivery){
                System.out.println((methodDelivery.indexOf(delivery) + 1) + ". ");
            }
            int choice;
            do {
                System.out.println("Enter choice (1-" + methodDelivery.size() + "): ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > methodDelivery.size());
            delivery = methodDelivery.get(choice - 1);
            System.out.println("Selected delivery: " + delivery);
        }
        public void displayOrderStatus() {
            System.out.println("Current order status: " + statusOrder);
        }
        public void totalPriceOrder(){ // pobranie wartosci koszyka :)

            System.out.println("You need to pay " + shoppingCart.getTotalPrice() + " for your order");
        }
    public void totalPriceOrderAfterDiscount(){ // pobranie wartosci koszyka po zastosowanej znizce

        System.out.println("You need to pay " + shoppingCart.getTotalPriceAfterDiscount() + " for your order after discount");
    }
    }
// biore wszystkie dane z koszyka  :)
// metoda zaakceptowania zamowienia
// przypisanie id klasy koszyk do nr zamowienia