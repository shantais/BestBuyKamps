/*
dodaje dane z koszyka ✔️
sprawdza czy zalogowany ✔️
jeśli niezalogowany to prosi o dane
jeśli zalogowany to pobiera dane z konta i prosi o uzupełnienie brakujących/potwierdzenie istniejących
wyliczenie czasu realizacji zamówienia
wybór formy płatności i dostawy
status zamówienia (złożone, przyjęte, wysłane do doręczenia, niedostarczone, dostarczone)
 */

import java.util.ArrayList;

public class Order {
    Private User user;
    private List<Product> productOrder = new ArrayList<>();

    public Order(ShoppingCart shoppingCart, User user) {
        if(!user.isLogged()){
            throw new IllegalStateException("The User is not logged in");
        }
        this.productOrder.addAll(shoppingCart.getProducts());
        this.user = user;
    }
    public void showOrder(){
        for(Product product : productOrder){
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " +
                    product.getCategory() + " " + product.getDescription() + " " + product.getSpecification());
        }
    }

    }

