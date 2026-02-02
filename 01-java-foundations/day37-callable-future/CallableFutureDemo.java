import java.util.concurrent.*;

public class CallableFutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "Result from task 1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1500);
            return "Result from task 2";
        };

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);

        System.out.println("Main thread doing other work");

        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();
    }
}
