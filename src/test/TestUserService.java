import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.najah.code.UserService;

@DisplayName("UserService Tests")
public class TestUserService {

    @Test
    @DisplayName("Valid email returns true")
    void testValidEmail() {
        UserService service = new UserService();

        assertTrue(service.isValidEmail("admin@test.com"));
        assertFalse(service.isValidEmail("admintest.com"));
    }

    @Test
    @DisplayName("Null email returns false")
    void testNullEmail() {
        UserService service = new UserService();

        assertFalse(service.isValidEmail(null));
        assertFalse(service.isValidEmail("abc"));
    }

    @Test
    @DisplayName("Correct username and password")
    void testAuthenticateValid() {
        UserService service = new UserService();

        assertTrue(service.authenticate("admin", "1234"));
        assertFalse(service.authenticate("admin", "0000"));
    }

    @Test
    @DisplayName("Wrong username or password")
    void testAuthenticateInvalid() {
        UserService service = new UserService();

        assertFalse(service.authenticate("user", "1234"));
        assertFalse(service.authenticate("admin", "pass"));
    }
}