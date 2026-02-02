public class ThreadLifecycleDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker started");
                Thread.sleep(2000);
                System.out.println("Worker finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Main starting worker");
        worker.start();

        worker.join(); // wait for worker

        System.out.println("Main finished");
    }
}
