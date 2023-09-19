import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Private User user;
    private List<Product> productOrder = new ArrayList<>();

    public OrderTest(ShoppingCart shoppingCart, User user) {
        if(!user.isLogged)
            this.productOrder.addAll(shoppingCart.getProducts());
    }
    public void showOrder(){
        for(Product product : productOrder){
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " +
                    product.getCategory() + " " + product.getDescription() + " " + product.getSpecification());
        }
    }

}