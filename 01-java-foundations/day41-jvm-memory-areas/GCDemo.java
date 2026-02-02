import java.util.*;

public class GCDemo {

    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 1024]); // 1MB
        }
    }
}
