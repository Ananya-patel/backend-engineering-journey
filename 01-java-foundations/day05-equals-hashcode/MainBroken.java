import java.util.HashMap;
import java.util.Map;

public class MainBroken {
    public static void main(String[] args) {
        Map<UserBroken, String> map = new HashMap<>();

        UserBroken u1 = new UserBroken(1, "Alice");
        UserBroken u2 = new UserBroken(1, "Alice");

        map.put(u1, "Engineer");

        System.out.println(map.get(u2)); // null 
    }
}
