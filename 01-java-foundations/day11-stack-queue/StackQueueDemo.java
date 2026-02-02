import java.util.*;

public class StackQueueDemo {
    public static void main(String[] args) {

        // STACK
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack pop: " + stack.pop());

        // QUEUE
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Queue poll: " + queue.poll());
    }
}
