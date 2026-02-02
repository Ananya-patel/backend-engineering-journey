import java.util.concurrent.*;

public class ThreadPoolTuningDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(
                2,                 // core threads
                4,                 // max threads
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy()
            );

        for (int i = 1; i <= 10; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println(
                    "Task " + id +
                    " running on " +
                    Thread.currentThread().getName()
                );
                sleep();
            });
        }

        executor.shutdown();
    }

    static void sleep() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
