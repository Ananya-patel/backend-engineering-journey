import java.util.*;

public class ListComparison {
    public static void main(String[] args) {

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "X"); // insertion in middle

        System.out.println("ArrayList: " + arrayList);

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add(1, "X"); // insertion in middle

        System.out.println("LinkedList: " + linkedList);
    }
}
// Same output — different internal cost.
//which one to use?
/*ArrayList by default.
LinkedList only when I do frequent insertions/removals in the middle.*/
