import java.util.*;

public class IterationDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // for-each loop
        for (String s : list) {
            System.out.println("For-each: " + s);
        }

        // iterator removal
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("B")) {
                it.remove();
            }
        }

        System.out.println("After removal: " + list);
    }
}
