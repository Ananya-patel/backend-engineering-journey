class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

public class ReferenceDemo {

    static void modify(User u) {
        u.name = "Modified";
    }

    public static void main(String[] args) {
        User user = new User("Original");
        modify(user);

        System.out.println(user.name);
    }
}
