import java.util.*;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        List<String> data = List.of("1", "2", "3");

        data.stream()
            .map(Integer::parseInt)      // static method reference
            .forEach(System.out::println); // instance method reference
    }
}
