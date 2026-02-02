import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // using lambda
        numbers.forEach(n -> System.out.println(n));

        // filter using lambda
        numbers.stream()
               .filter(n -> n > 3)
               .forEach(n -> System.out.println("Filtered: " + n));
    }
}

