import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrontSite {
    public static void main(String[] args) throws InterruptedException {

        User user = new User();

        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> magazine = new ArrayList<>(List.of(
                new Product("telefon",CategoryType.Elektronika,2000.00,"najlepszy telefon","ekran i reszta bajerów"),
                new Product("telefon",CategoryType.Elektronika,2000.00,"najlepszy telefon","ekran i reszta bajerów"),
                new Product("laptop", CategoryType.Elektronika, 2500.00, "super laptop", "szybki i lekki"),
                new Product("telewizor", CategoryType.Elektronika, 1500.00, "duży telewizor", "wysoka rozdzielczość"),
                new Product("kamera", CategoryType.Elektronika, 800.00, "profesjonalna kamera", "nagrywanie w 4K"),
                new Product("konsola do gier", CategoryType.Elektronika, 1200.00, "najnowsza konsola", "wysoka wydajność"),
                new Product("rower", CategoryType.Elektronika, 800.00, "górski rower", "dobre hamulce")
        ));
        String currentCommend;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------------------------------------------");
            System.out.println("----------------------------------------------------------");
            System.out.println("----------------------------------------------------------");
            System.out.println("Welcome to  BestBuy Main Kamps");
            if(!user.isLoggedStatus()){
                System.out.println("Available options for unregistered user");
                System.out.println("----------------------------------------------------------");
                System.out.println(" |1. Log in | 2. Products | 3. Cart |  4.Newsletter |");
                System.out.println("----------------------------------------------------------");
                text();
            }
            if(user.isLoggedStatus()){
                System.out.println("Hello  " + user.getUsername() + " !");
                System.out.println("Available options for logged user " );
                System.out.println("----------------------------------------------------------");
                System.out.println(" |1. Log out | 2. Products | 3. Cart |  4.Newsletter |");
                System.out.println("----------------------------------------------------------");
                text();
            }

            currentCommend = scanner.next();
            if(currentCommend.equals("1")){
                if(!user.isLoggedStatus()){
                    GeneralMethods.logInLoop(scanner,user);
                    shoppingCart.setUser(user);
                }else{
                    System.out.println("Logged out: " + user.getUsername());
                    user= new User();
                    shoppingCart = new ShoppingCart();

                }

            }else if(currentCommend.equals("2")){
                System.out.println("-------------------------");
                System.out.println("------- Products : ------");
                System.out.println("-------------------------");
                for (Product product: magazine) {
                    System.out.println("--------------------");
                    System.out.println(product.getId());
                    System.out.println(product.getName());
                    System.out.println(product.getCategory());
                    System.out.println(product.getPrice());
                    System.out.println(product.getSpecification());
                    System.out.println(product.getDescription());
                    System.out.println("--------------------");
                }// TODO brakuje magazynu

                System.out.println("Add product by id number or type 0 to go back ... ");
                do{

                    currentCommend = scanner.nextLine();
                    Product product2 = new Product();
                    for (Product product1: magazine) {
                        if(Integer.toString(product1.getId()).equals(currentCommend)){
                            shoppingCart.addToCart(product1);
                            product2 = product1;
                            System.out.println("Added to cart: " + product1.getName() );
                            System.out.println("Add product by id number or type 0 to go back ... ");
                        }
                    }
                    magazine.remove(product2);
                }while(!currentCommend.equals("0"));


            } else if(currentCommend.equals("3")){

                System.out.println("-------------------------");
                System.out.println("-------   Cart :   ------");
                System.out.println("-------------------------");
                shoppingCart.toString();
                System.out.println("1. Back to Menu | 2. Place Order | 3. Remove item from cart");
                currentCommend = scanner.next();
                if(currentCommend.equals("1")){
                    continue;
                } else if(currentCommend.equals("2") && shoppingCart.getProducts().size()==0) {
                    System.out.println("Order cannot be placed without products");
                    continue;
                }else if (currentCommend.equals("2")){
                    //składanie zamówienia
                    System.out.println("-------------------------");
                    System.out.println("---- Placing Order : ----");
                    System.out.println("-------------------------");
                    Order order = new Order();
                    order.setShoppingCart(shoppingCart);
                    order.setUser(user);

                    order.userIsLoggedOrNot();
                    System.out.println("Product in order");
                    order.showOrder();
                    System.out.println("-------------------------");
                    order.chooseDeliveryMethod();
                    System.out.println("-------------------------");
                    order.choosePaymentMethod();
                    System.out.println("-------------------------");
                    order.displayOrderStatus();

                    if(shoppingCart.getUser().isLoggedStatus()){
                        System.out.println("Name: " + user.getName());
                        System.out.println("Surname: " + user.getSurname());
                    }else {
                        System.out.println("name: " + order.getUser().getName());
                        System.out.println("Surname: " + order.getUser().getSurname());
                    }

                    order.totalPriceOrder();
                    order.totalPriceOrderAfterDiscount();
                    System.out.println("-------------------------");
                    System.out.println("-------------------------");
                    System.out.println("1. Place Order | 2. Cancel Order");
                    text();
                    currentCommend = scanner.next();
                    if(currentCommend.equals("1")) {
                        order.placeOrder();
                        shoppingCart = new ShoppingCart();
                        continue;
                    }
                    if(currentCommend.equals("2")) {
                        order = new Order();
                        continue;
                    }

                    //////////////////////////////////////////////
                }else if (currentCommend.equals("3")){
                    for (Product product1: shoppingCart.getProducts()) {
                        System.out.println("-------------------------");
                        System.out.println("Product id : "+ product1.getId());
                        System.out.println("Product name: " + product1.getName() );
                        System.out.println("-------------------------");
                    }

                    do {
                        scanner = new Scanner(System.in);
                        System.out.println("Remove product by id number or type 0 to go back ... ");
                        currentCommend = scanner.nextLine();
                        Product product3 = new Product();
                        for (Product product1 : shoppingCart.getProducts()) {
                            if(currentCommend.equals(Integer.toString(product1.getId()))) {
                                product3=product1;
                                magazine.add(product1);
                            }
                        }
                        shoppingCart.removeFromCart(product3);
                    }while(!currentCommend.equals("0"));

            }


            } else if(currentCommend.equals("4")){
                System.out.println("-------------------------");
                System.out.println("------- Newsletter ------");
                System.out.println("-------------------------");
                Newsletter news = new Newsletter();
                news.startNewsletter();
                continue;
            }
            else{
                System.out.println("Something is not Yes");
            }

        }

    }

public static void text(){
    System.out.println("Choose option: ...");
}

    public static String validateString(String currentCommand , String regex){
        String command="";
        return command;
    }


}


