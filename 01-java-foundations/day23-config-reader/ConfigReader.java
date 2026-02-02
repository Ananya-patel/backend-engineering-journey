import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class ConfigReader {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("app.config");

        List<String> lines = Files.readAllLines(path);

        System.out.println(lines);
    }
}
