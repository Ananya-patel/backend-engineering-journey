public class VolatileDemo {

    static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            while (running) {
                // simulate work
            }
            System.out.println("Worker stopped");
        });

        worker.start();

        Thread.sleep(2000);
        running = false;

        System.out.println("Main updated running flag");
    }
}
