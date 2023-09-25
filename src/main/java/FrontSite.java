import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrontSite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        } else if(currentCommend.equals("3")){
            System.out.println("Przejście do Koszyka");
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.toString();
        } else if(currentCommend.equals("3")){
            System.out.println("Przejście do Newsletter`a");
        }

    }

public static void text(){
    System.out.println("Wybierz opcję : ...");
}

}
