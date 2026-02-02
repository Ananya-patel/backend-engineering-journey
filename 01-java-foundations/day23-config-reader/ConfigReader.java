import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class ConfigReader {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("app.config");

        Map<String, String> configMap =
                Files.readAllLines(path)
                        .stream()
                        .map(line -> line.split("="))
                        .collect(Collectors.toMap(
                                parts -> parts[0],
                                parts -> parts[1]
                        ));

        System.out.println("App Name: " + configMap.get("app.name"));
        System.out.println("Port: " + configMap.get("app.port"));
        System.out.println("Environment: " + configMap.get("app.env"));
        System.out.println("\nOnly app-related configs:");

configMap.entrySet()
         .stream()
         .filter(entry -> entry.getKey().startsWith("app."))
         .forEach(entry ->
             System.out.println(entry.getKey() + " = " + entry.getValue())
         );

    }
}
