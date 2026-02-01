import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();

        User u1 = new User(1, "Alice");
        User u2 = new User(1, "Alice");

        map.put(u1, "Engineer");

        System.out.println(map.get(u2)); // Works 
        System.out.println(u1);          // Clean logs
    }
}

