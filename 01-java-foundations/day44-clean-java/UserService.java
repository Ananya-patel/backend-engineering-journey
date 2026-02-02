import java.util.Objects;

public class UserService {

    public void registerUser(String email) {
        validateEmail(email);
        save(email);
    }

    private void validateEmail(String email) {
        Objects.requireNonNull(email, "email must not be null");

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    private void save(String email) {
        System.out.println("Saved user: " + email);
    }
}
