import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
            CompletableFuture.supplyAsync(() -> 10)
                .thenApply(n -> n * 2)
                .thenApply(n -> n + 5);

        System.out.println("Result: " + future.join());
    }
}

