import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDemo {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello, Java I/O!");
            writer.write("\nThis is written to a file.");
            writer.close();

            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

