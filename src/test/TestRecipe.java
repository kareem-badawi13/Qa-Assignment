import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.najah.code.Recipe;
import main.najah.code.RecipeException;

@DisplayName("Recipe Tests")
public class TestRecipe {

    @Test
    @DisplayName("Default constructor values")
    void testDefaultConstructor() {
        Recipe recipe = new Recipe();

        assertEquals("", recipe.getName());
        assertEquals(0, recipe.getPrice());
        assertEquals(0, recipe.getAmtCoffee());
        assertEquals(0, recipe.getAmtMilk());
        assertEquals(0, recipe.getAmtSugar());
        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    @DisplayName("Set valid name")
    void testSetName() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");

        assertEquals("Mocha", recipe.getName());
        assertEquals("Mocha", recipe.toString());
    }

    @Test
    @DisplayName("Set null name does not change value")
    void testSetNullName() {
        Recipe recipe = new Recipe();
        recipe.setName(null);

        assertEquals("", recipe.getName());
    }

    @Test
    @DisplayName("Set valid price")
    void testSetValidPrice() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setPrice("15");

        assertEquals(15, recipe.getPrice());
    }

    @Test
    @DisplayName("Set invalid price throws exception")
    void testSetInvalidPrice() {
        Recipe recipe = new Recipe();

        assertThrows(RecipeException.class, () -> recipe.setPrice("-1"));
        assertThrows(RecipeException.class, () -> recipe.setPrice("abc"));
    }

    @Test
    @DisplayName("Set valid coffee amount")
    void testSetValidCoffee() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("3");

        assertEquals(3, recipe.getAmtCoffee());
    }

    @Test
    @DisplayName("Set invalid coffee amount throws exception")
    void testSetInvalidCoffee() {
        Recipe recipe = new Recipe();

        assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-1"));
        assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("abc"));
    }

    @Test
    @DisplayName("Set valid milk amount")
    void testSetValidMilk() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtMilk("2");

        assertEquals(2, recipe.getAmtMilk());
    }

    @Test
    @DisplayName("Set invalid milk amount throws exception")
    void testSetInvalidMilk() {
        Recipe recipe = new Recipe();

        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-1"));
        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("abc"));
    }

    @Test
    @DisplayName("Set valid sugar amount")
    void testSetValidSugar() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtSugar("4");

        assertEquals(4, recipe.getAmtSugar());
    }

    @Test
    @DisplayName("Set invalid sugar amount throws exception")
    void testSetInvalidSugar() {
        Recipe recipe = new Recipe();

        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-1"));
        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("abc"));
    }

    @Test
    @DisplayName("Set valid chocolate amount")
    void testSetValidChocolate() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtChocolate("5");

        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    @DisplayName("Set invalid chocolate amount throws exception")
    void testSetInvalidChocolate() {
        Recipe recipe = new Recipe();

        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-1"));
        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("abc"));
    }

    @Test
    @DisplayName("Equals and hashCode with same names")
    void testEqualsAndHashCode() {
        Recipe r1 = new Recipe();
        r1.setName("Latte");

        Recipe r2 = new Recipe();
        r2.setName("Latte");

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    @DisplayName("Equals with different names")
    void testEqualsDifferentNames() {
        Recipe r1 = new Recipe();
        r1.setName("Latte");

        Recipe r2 = new Recipe();
        r2.setName("Mocha");

        assertNotEquals(r1, r2);
    }

    @Test
    @DisplayName("Equals with null and different class")
    void testEqualsNullAndDifferentClass() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");

        assertNotEquals(recipe, null);
        assertNotEquals(recipe, "Coffee");
    }
}