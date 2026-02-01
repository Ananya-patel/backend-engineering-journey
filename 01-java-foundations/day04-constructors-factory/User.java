public class User {
    private final String name;
    private final String role;

    private User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public static User createAdmin(String name) {
        return new User(name, "ADMIN");
    }

    public static User createCustomer(String name) {
        return new User(name, "CUSTOMER");
    }

    public String getRole() {
        return role;
    }
}

