import java.util.*;
import java.util.function.*;

public class FunctionalInterfacesDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 10, 15, 20);

        Predicate<Integer> greaterThan10 = n -> n > 10;
        Function<Integer, Integer> doubleIt = n -> n * 2;
        Consumer<Integer> printer = System.out::println;

        numbers.stream()
               .filter(greaterThan10)
               .map(doubleIt)
               .forEach(printer);
    }
}
