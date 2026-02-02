import java.nio.file.*;

public class JavaNioDemo {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("data.txt");

        // write
        Files.write(path, "Learning Java NIO".getBytes());

        // read
        String content = Files.readString(path);
        System.out.println(content);

        // check existence
        if (Files.exists(path)) {
            System.out.println("File exists");
        }
    }
}
