import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrontSite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Witamy w sklepie BestBuy Main Kamps");
            System.out.println("dostępne opcje dla użytkownika niezalogowanego");
            System.out.println(" |1. Logowanie | 2. Produkty | 3. Koszyk |  4.Newsletter |");
            text();
            currentCommend = scanner.next();
            if(currentCommend.equals("1")){
                System.out.println("Przejście do Logowania"); // TODO
            }else if(currentCommend.equals("2")){
                System.out.println("Przejście do Produktów");
                for (Product product: magazine) {
                    System.out.println(product.getId());
                    System.out.println(product.getName());
                    System.out.println(product.getCategory());
                    System.out.println(product.getPrice());
                    System.out.println(product.getSpecification());
                    System.out.println(product.getDescription());
                    System.out.println("--------------------");
                }// TODO brakuje magazynu

                System.out.println("Dodaj produkt do koszyka po ID(zero aby wyjść z pentli) : ...");
                do{
                    System.out.println("oczekuje: ");
                    currentCommend = scanner.next();

                    for (Product product1: magazine) {
                        if(Integer.toString(product1.getId()).equals(currentCommend)){
                            shoppingCart.addToCart(product1);
                            System.out.println("Dodano do koszyka: " + product1.getName() );
                        }
                    }
                }while(!currentCommend.equals("0"));
                if(currentCommend.equals("0")) continue;



            } else if(currentCommend.equals("3")){
                System.out.println("Przejście do Koszyka");
                shoppingCart.toString();
                System.out.println("1. Przejdź do menu | 2. Złóż zamówienie");
                currentCommend = scanner.next();
                if(currentCommend.equals("1")) continue;
                //składanie zamówienia


            } else if(currentCommend.equals("4")){
                System.out.println("Przejście do Newsletter`a");
                Newsletter news = new Newsletter();
                news.startNewsletter();
                continue;
            }

        }

    }

public static void text(){
    System.out.println("Wybierz opcję : ...");
}

}
