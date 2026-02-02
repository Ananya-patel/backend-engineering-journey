import java.util.Optional;

public class OptionalDemo {

    static Optional<String> getUsername(boolean exists) {
        if (exists) {
            return Optional.of("ananya");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {

        Optional<String> user = getUsername(false);

        // safe usage
        String name = user.orElse("guest");

        System.out.println("User: " + name);
    }
}
