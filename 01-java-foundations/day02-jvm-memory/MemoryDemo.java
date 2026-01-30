

import java.util.ArrayList;
import java.util.List;

public class MemoryDemo {

    static class User {
        String name;
        User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            users.add(new User("User " + i));
        }

        System.out.println("Objects created");
    }
}
