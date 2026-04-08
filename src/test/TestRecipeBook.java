import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.najah.code.Recipe;
import main.najah.code.RecipeBook;

@DisplayName("RecipeBook Tests")
public class TestRecipeBook {

    @Test
    @DisplayName("Add recipe successfully")
    void testAddRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");

        boolean added = book.addRecipe(recipe);

        assertTrue(added);
        assertEquals("Mocha", book.getRecipes()[0].getName());
    }

    @Test
    @DisplayName("Add duplicate recipe should fail")
    void testAddDuplicateRecipe() {
        RecipeBook book = new RecipeBook();

        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");

        Recipe recipe2 = new Recipe();
        recipe2.setName("Latte");

        book.addRecipe(recipe1);
        boolean addedAgain = book.addRecipe(recipe2);

        assertFalse(addedAgain);
        assertEquals("Latte", book.getRecipes()[0].getName());
    }

    @Test
    @DisplayName("Delete existing recipe")
    void testDeleteRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Espresso");

        book.addRecipe(recipe);
        String deletedName = book.deleteRecipe(0);

        assertEquals("Espresso", deletedName);
        assertEquals("", book.getRecipes()[0].getName());
    }

    @Test
    @DisplayName("Delete empty recipe slot returns null")
    void testDeleteEmptyRecipe() {
        RecipeBook book = new RecipeBook();

        String deletedName = book.deleteRecipe(0);

        assertNull(deletedName);
        assertNull(book.getRecipes()[0]);
    }

    @Test
    @DisplayName("Edit existing recipe")
    void testEditRecipe() {
        RecipeBook book = new RecipeBook();

        Recipe oldRecipe = new Recipe();
        oldRecipe.setName("Old Coffee");
        book.addRecipe(oldRecipe);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("New Coffee");

        String editedName = book.editRecipe(0, newRecipe);

        assertEquals("Old Coffee", editedName);
        assertEquals("", book.getRecipes()[0].getName());
    }

    @Test
    @DisplayName("Edit empty recipe slot returns null")
    void testEditEmptyRecipe() {
        RecipeBook book = new RecipeBook();

        Recipe recipe = new Recipe();
        recipe.setName("Any");

        String editedName = book.editRecipe(0, recipe);

        assertNull(editedName);
        assertNull(book.getRecipes()[0]);
    }
}