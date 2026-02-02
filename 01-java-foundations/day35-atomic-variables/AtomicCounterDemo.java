import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterDemo {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter: " + counter.get());
    }
}

