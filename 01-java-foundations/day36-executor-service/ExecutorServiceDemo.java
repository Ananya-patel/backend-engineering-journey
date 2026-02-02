import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.submit(() -> {
                System.out.println(
                    "Task " + id +
                    " running on " +
                    Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}

