import java.util.*;

public class WildcardsDemo {

    static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        addNumbers(ints);
        printNumbers(ints);

        List<Double> doubles = Arrays.asList(1.1, 2.2);
        printNumbers(doubles);
    }
}
