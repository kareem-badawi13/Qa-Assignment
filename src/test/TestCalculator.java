import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.najah.code.Calculator;

@TestMethodOrder(OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Calculator Tests")
public class TestCalculator {

    Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("setup complete before all calculator tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("all calculator tests finished");
    }

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        System.out.println("before each calculator test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each calculator test");
    }

    @Test
    @Order(1)
    @DisplayName("Add valid numbers")
    void testAddValidNumbers() {
        assertEquals(8, calc.add(5, 3));
        assertNotEquals(9, calc.add(5, 3));
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({
            "1,2,3",
            "5,5,10",
            "-1,1,0"
    })
    @DisplayName("Parameterized add test")
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }

    @Test
    @Order(3)
    @DisplayName("Divide valid numbers")
    void testDivideValid() {
        assertEquals(5, calc.divide(10, 2));
        assertNotEquals(4, calc.divide(10, 2));
    }

    @Test
    @Order(4)
    @DisplayName("Divide by zero throws exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    @Test
    @Order(5)
    @DisplayName("Factorial valid input")
    void testFactorialValid() {
        assertEquals(120, calc.factorial(5));
        assertNotEquals(100, calc.factorial(5));
    }

    @Test
    @Order(6)
    @DisplayName("Factorial negative input throws exception")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
    }

    @Test
    @Order(7)
    @DisplayName("Timeout test for calculator")
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> calc.add(1, 2));
    }

    @Disabled("Intentional failing test. Fix by changing expected result to 8")
    @Test
    @Order(8)
    @DisplayName("Disabled failing test")
    void testFailingDisabled() {
        assertEquals(100, calc.add(5, 3));
    }
}