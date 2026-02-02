import java.util.concurrent.*;

public class AdvancedCompletableFutureDemo {

    static CompletableFuture<String> serviceA() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "A";
        });
    }

    static CompletableFuture<String> serviceB() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return "B";
        });
    }

    public static void main(String[] args) {

        CompletableFuture<String> result =
            serviceA()
                .thenCompose(a ->
                    serviceB().thenApply(b -> a + b)
                )
                .orTimeout(3, TimeUnit.SECONDS)
                .exceptionally(ex -> "FALLBACK");

        System.out.println("Result: " + result.join());
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
