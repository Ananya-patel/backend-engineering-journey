import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("A");
        set.add("B");
        set.add("A"); // duplicate

        System.out.println(set);
    }
}
