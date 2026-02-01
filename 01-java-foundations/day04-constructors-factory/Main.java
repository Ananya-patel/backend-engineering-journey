public class Main {
    public static void main(String[] args) {
        User admin = User.createAdmin("Alice");
        User customer = User.createCustomer("Bob");

        System.out.println(admin.getRole());
        System.out.println(customer.getRole());
    }
}

