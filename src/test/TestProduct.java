import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.najah.code.Product;

@DisplayName("Product Tests")
public class TestProduct {

    @Test
    @DisplayName("Create product with valid data")
    void testValidProduct() {
        Product product = new Product("Milk", 100.0);

        assertEquals("Milk", product.getName());
        assertEquals(100.0, product.getPrice());
    }

    @Test
    @DisplayName("Create product with negative price should throw exception")
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Milk", -10.0);
        });
    }

    @Test
    @DisplayName("Apply valid discount")
    void testApplyValidDiscount() {
        Product product = new Product("Milk", 200.0);
        product.applyDiscount(25);

        assertEquals(25, product.getDiscount());
        assertEquals(150.0, product.getFinalPrice());
    }

    @Test
    @DisplayName("Apply invalid discount should throw exception")
    void testApplyInvalidDiscount() {
        Product product = new Product("Milk", 200.0);

        assertThrows(IllegalArgumentException.class, () -> {
            product.applyDiscount(60);
        });
    }

    @Test
    @DisplayName("Apply negative discount should throw exception")
    void testApplyNegativeDiscount() {
        Product product = new Product("Milk", 200.0);

        assertThrows(IllegalArgumentException.class, () -> {
            product.applyDiscount(-5);
        });
    }
}