import java.util.*;

public class StreamsPerformanceDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 10, 15, 20, 25);

        numbers.stream()
               .filter(n -> {
                   System.out.println("Filtering: " + n);
                   return n > 10;
               })
               .map(n -> {
                   System.out.println("Mapping: " + n);
                   return n * 2;
               })
               .findFirst();
    }
}
