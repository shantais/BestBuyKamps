import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private User user;
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