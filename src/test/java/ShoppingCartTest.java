import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        // Inicjalizacja obiektu ShoppingCart i produktów przed każdym testem
        shoppingCart = new ShoppingCart();
        product1 = new Product("telefon", CategoryType.Elektronika, 2000.00, "najlepszy telefon", "ekran i reszta bajerów");
    }

    @Test
    public void testAddToCart() {
        assertTrue(shoppingCart.addToCart(product1));
        assertEquals(1, shoppingCart.getProducts().size());
        assertEquals(2000.00, shoppingCart.getTotalPrice());
    }

    @Test
    public void testAddDiscount() {
        shoppingCart.addDiscount(10.0);
        assertEquals(10.0, shoppingCart.getDiscount());
    }

    @Test
    public void testRemoveFromCart() {
        shoppingCart.addToCart(product1);
        shoppingCart.removeFromCart(product1);
        assertFalse(shoppingCart.getProducts().contains(product1));
        assertEquals(0, shoppingCart.getProducts().size());
    }

    @Test
    public void testGenerateCartID() {
        long cartID = shoppingCart.getCartID();
        assertTrue(cartID >= 1000000000L && cartID <= 9999999999L);
    }


}
