import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        // LIST
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        System.out.println("List: " + list);

        // SET
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A");
        System.out.println("Set: " + set);

        // MAP
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 1);
        map.put("Bob", 2);
        System.out.println("Map Alice: " + map.get("Alice"));
    }
}
