import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();

        // add from both ends
        deque.addFirst("A");
        deque.addLast("B");
        deque.addLast("C");

        System.out.println(deque); // [A, B, C]

        // remove from both ends
        System.out.println(deque.removeFirst()); // A
        System.out.println(deque.removeLast());  // C

        System.out.println(deque); // [B]
    }
}

