import java.util.*;

public class PerformanceThinking {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // Imagine 1 million elements
        // Which is faster?
        list.contains(999999); // O(n)
        set.contains(999999);  // O(1)
    }
}
