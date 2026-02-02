import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("Apple", "Red");
        map.put("Banana", "Yellow");
        map.put("Grapes", "Green");

        System.out.println(map.get("Apple"));
        System.out.println(map.get("Banana"));
    }
}

