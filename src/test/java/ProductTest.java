import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeAll
    static void setUpTestCase() {
        System.out.println("Ten komunikat wyświetli się raz przed wykonaniem wszystkich metod testujących");
    }

    @AfterAll
    static void tearDownTestCase() {
        System.out.println("Ten komunikat wyświetli się raz po wykonaniu wszystkich metod testujących");
    }

    @BeforeEach
    public void setUP() {
        product = new Product("name", CategoryType.Elektronika, 99.99, "desciprion", "specification");
    }
    @AfterEach
    void tearDown() {
        product = null;
        System.out.println("Ten komunikat wyświetli się po wykonaniu każdej z metod testujących");
    }

    @Test
    public void testGetID() {
        Assertions.assertEquals(1, product.getId());
    }


}